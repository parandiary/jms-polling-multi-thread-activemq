package com.e1.ims.trk.executer.impl;

import java.util.ArrayList;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.e1.ims.trk.Demo1Application;
import com.e1.ims.trk.executer.TrackerExecutor;
import com.e1.ims.trk.executer.TrkLogExecutor;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TrackerExecutorImpl implements TrackerExecutor {

	@Autowired
	private ActiveMQConnectionFactory connectionFactory;

	@Autowired
	private TrkLogExecutor trkLogExecutor;


	@Value("${tracker.tracker-queue-name}")
    private String trackerQueueName;

	private static int ackMode = Session.AUTO_ACKNOWLEDGE;
    private boolean transacted = false;
    private Session session;

    private ArrayList<String> recivedMessages = new ArrayList<String>();
    int recivedMsgCnt = 0;


	@Override
	@Async("trackerThreadPoolTaskExecutor")
	public void asyncProcTracker(String param) throws Exception {
		String threadName = Thread.currentThread().getName();
		log.info("Tracker thread[{}] start with param {} ",threadName, param);

		Connection connection;
		try {
			connection = connectionFactory.createConnection();
			connection.start();
			this.session = connection.createSession(this.transacted, ackMode);
			Destination trackingQueue = this.session.createQueue(trackerQueueName);

			//Set up a consumer to consume messages off of the admin queue
			MessageConsumer consumer = this.session.createConsumer(trackingQueue);

			while(!Demo1Application.STOP) {
				// recive가 0일 경우 polling
				Message message = consumer.receive(0);
				if (message instanceof TextMessage) {
					TextMessage textMessage = (TextMessage) message;
					//log.info("{} receive {}",threadName, textMessage.getText());
					recivedMessages.add(textMessage.getText());
					recivedMsgCnt++;
				}

				//bulk size
				if(recivedMsgCnt > 10) {
					recivedMsgCnt = 0;
					ArrayList<String> paramMessages = new ArrayList<String>();
					paramMessages.addAll(recivedMessages); //객체일 경우 Deep Copy 검토
					recivedMessages.clear();
					log.debug("recivedMessages {}", recivedMessages);
					log.debug("paramMessages {}", paramMessages);

					// database insert를 위한 thread 수행
					trkLogExecutor.insertRmLog(paramMessages);
					trkLogExecutor.insertRmLogBuf(paramMessages);

				}


				log.info("check message {}",!Demo1Application.STOP);
				//Thread.sleep(1000);
			}

		} catch (JMSException e) {
			//Handle the exception appropriately
			log.error(e.getMessage());
		}


	}



}
