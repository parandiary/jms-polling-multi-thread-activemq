package com.e1.ims.trk.executer.impl;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
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

	@Value("${tracker.jms-receive-timeout}")
	private long jmsReciveTimeout;

	@Value("${tracker.commit-cnt}")
	private int commitCnt;

	//private static int ackMode = Session.AUTO_ACKNOWLEDGE; // 자동으로 메세지 수신
	//private boolean transacted = true; // JMS 트랜잭션 사용여부
	private static int ackMode = Session.AUTO_ACKNOWLEDGE; // 자동으로 메세지 수신
	private boolean transacted = false; // JMS 트랜잭션 사용여부
    private Session session;

    int recivedMsgCnt = 0;

    LocalDateTime checkTime = null;
    Duration duration = null;

    long testMsgCnt = 0;


	@Override
	@Async("trackerThreadPoolTaskExecutor")
	public void asyncProcTracker(String param) {

		String threadName = Thread.currentThread().getName();
		log.info("Tracker thread[{}] start with param {} recive-time-out={} ",threadName, param, jmsReciveTimeout);

		ArrayList<String> recivedMessages = new ArrayList<String>();

		//test
//		LocalDateTime start = LocalDateTime.now();
//		try {
//			Thread.sleep(1500);
//		} catch (InterruptedException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		LocalDateTime end = LocalDateTime.now();
//		Duration duration = Duration.between(start, end);
//		log.info("duration test {} {} {}",start,end, duration.getSeconds());

		Connection connection;
		try {
			connection = connectionFactory.createConnection();
			connection.start();
			this.session = connection.createSession(this.transacted, ackMode);
			Destination trackingQueue = this.session.createQueue(trackerQueueName);

			//Set up a consumer to consume messages off of the admin queue
			MessageConsumer consumer = this.session.createConsumer(trackingQueue);

			checkTime = LocalDateTime.now();
			while(!Demo1Application.STOP) {

				// recive(waitTimeMs)
				Message message = consumer.receive(jmsReciveTimeout);
				if (message instanceof TextMessage) {
					TextMessage textMessage = (TextMessage) message;
					//log.info("{} receive {}",threadName, textMessage.getText());

					// TODO: 파싱/Convert 해서 문제가 없어야 하며 문제가 있을 경우 해당 msg는 문제 메세지로 DB에 저장하고 다음 메세지 처리로 넘어간다.
					recivedMessages.add(textMessage.getText() + testMsgCnt++);
					recivedMsgCnt++;
				}

				// TODO: session connection 체크하는 로직 필요

				//bulk size and duration
				duration = Duration.between(checkTime, LocalDateTime.now());
				//log.info("duration check {} {} {} {}",recivedMsgCnt, checkTime,LocalDateTime.now(), duration.getSeconds());

				if(recivedMsgCnt >= commitCnt || ( duration.getSeconds() > 1 && recivedMsgCnt > 0)  ) {
					log.debug("#### DB SAVE START - msgcnt {}, duration {}", recivedMsgCnt, duration.getSeconds());
					ArrayList<String> paramMessages = new ArrayList<String>();
					paramMessages.addAll(recivedMessages); //객체일 경우 Deep Copy 검토
					log.debug("recivedMessages {}", recivedMessages);
					log.debug("paramMessages {}", paramMessages);

					// database insert를 위한 thread 수행
					try {
						trkLogExecutor.insertRmLog(paramMessages);
						//trkLogExecutor.insertRmLogBuf(paramMessages);

						// db pool 이 모자라는 현상
						//Connection is not available, request timed out after 30006ms

						//message.acknowledge();


					} catch (Exception e) {
						e.printStackTrace();

						// DB 입력에 문제가 있을 경우 DB Connection 문제면 connection이 될때까지 계속 연결 시도를 수행한다.
						// 해당 메세지에 대해 재처리를 수행한다.
						// 재처리를 하려면.. trkLogExecutor가 sync가 되어야 하나??? == >그러면 앞단의 스레드를 늘여야 되네

						// 파티션 없을 경우에 대한 예외처리 필요
					}


					// TODO: DB insert 오류시 예외처리 및 rollback 필요


					recivedMessages.clear();
					recivedMsgCnt = 0;
					checkTime = LocalDateTime.now();

					//testMsgCnt = 0;



				}

				//this.session.commit();


				//log.info("check message {}",!Demo1Application.STOP);
				//받은 메세지가 없을 경우 잠시 sleep
				if(jmsReciveTimeout < 500 && "".equals(message.getJMSCorrelationID())){
					Thread.sleep(1000);
				}
			}

			if(consumer != null) consumer.close();
			if(connection != null) {
				connection.stop();
				connection.close();
			}

		} catch (JMSException e) {
			//Handle the exception appropriately
			log.error(e.getMessage());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				this.session.close();
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		}


	}



}
