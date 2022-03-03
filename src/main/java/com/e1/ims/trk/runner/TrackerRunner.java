package com.e1.ims.trk.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.e1.ims.trk.executer.TrackerExecutor;

import lombok.extern.slf4j.Slf4j;

@Component
@Order(4)
@Slf4j
public class TrackerRunner implements CommandLineRunner {

	@Value("${tracker.pool-size}")
	private int poolSize;

	@Autowired
	private TrackerExecutor trackerExecutor;

	@Override
	public void run(String... args) throws Exception {

		log.info("### Trackerf thread start ###");
		for(int i = 0 ; i < poolSize ; i++) {
    		// thread 실행
			String param = ""+i;
			trackerExecutor.asyncProcTracker(param);

    	}


	}

}
