package com.e1.ims.trk.activemq;

import java.time.Instant;
import java.util.ArrayList;

import javax.jms.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;

import com.e1.ims.trk.service.TrkLogService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ActivemqReciver {

	@Autowired
	private TrkLogService trkLogService;

	private long msgCnt = 0;

	private ArrayList<String> messageList = new ArrayList<String>();

	Instant start = Instant.now();
	Instant end = Instant.now();

	//private LocalTime start = LocalTime.of(10, 35, 40);
	//private LocalTime end = LocalTime.of(10, 36, 50, 800);

	//Duration duration = Duration.between(start, end);

    @JmsListener(destination = "helloworld.q")
    public void receive(String message) {
        log.info("hellowworld received message='{}'", message);
    }

    @JmsListener(destination = "time-queue")
    public void timereceive(String message) {
    	log.info("timer received message='{}'", message);
    }

//    @JmsListener(destination = "RMS.LQ")
//    public void rmsLogReciver(String message) throws Exception {
//    	//log.info("rms log received message='{}'", message);
//    	message += " - " + msgCnt++;
//
//    	messageList.add(message);
//    	log.debug("messages size : {}",messageList.size() );
//
//    	//Duration timeElapsed = Duration.between(start, end);
//
//    	if(messageList.size() > 99 ) {
//    		ArrayList<String> tmpMessages = new ArrayList<String>();
//    		tmpMessages.addAll(messageList);
//    		trkLogService.bulk(tmpMessages);
//    		messageList.clear();
//    		start = Instant.now();
//    	}
//
//    	log.debug("tmpMessages size : {}",messageList.size() );
//    	log.debug("messages size : {} \n\n",messageList.size() );
//
//
//    	//trkLogService.test(message);
//    	//trkLogService.bulk(messages);
//    	//trkLogService.syncTest(message);
//
//
//    }


    @JmsListener(destination = "RMS.LQ")
    public void rmsLogReciverBulk(ArrayList messages) throws Exception {


    	log.info("rms log received message {} ='{}'",msgCnt++,  messages);


//    	messageList.add(message);
//    	log.debug("messages size : {}",messageList.size() );
//
//    	//Duration timeElapsed = Duration.between(start, end);
//
//    	if(messageList.size() > 99 ) {
//    		ArrayList<String> tmpMessages = new ArrayList<String>();
//    		tmpMessages.addAll(messageList);
//    		trkLogService.bulk(tmpMessages);
//    		messageList.clear();
//    		start = Instant.now();
//    	}
//
//    	log.debug("tmpMessages size : {}",messageList.size() );
//    	log.debug("messages size : {} \n\n",messageList.size() );


    	//trkLogService.test(message);
    	//trkLogService.bulk(messages);
    	//trkLogService.syncTest(message);


    }
}
