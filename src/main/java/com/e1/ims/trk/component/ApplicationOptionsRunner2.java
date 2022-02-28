package com.e1.ims.trk.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Order(2)
@Slf4j
public class ApplicationOptionsRunner2 implements ApplicationRunner  {

	private static final Logger log = LoggerFactory.getLogger(ApplicationOptionsRunner2.class);


	@Override
	public void run(ApplicationArguments args) throws Exception {

		log.info("Argument Check2");
		System.out.println("sysout : argument check2");


        System.out.println("is contained 'IMS_HOME' : "  + args.containsOption("IMS_HOME"));
        System.out.println("is 'IMS_HOME' : "  + args.getOptionValues("IMS_HOME"));
        System.out.println("is contained 'bar' : "  + args.containsOption("bar"));

        System.out.println("env IMS_HOME : "+ System.getenv("IMS_HOME"));

        if(!args.containsOption("start")) {
        	System.out.println("start가 없어 종료함.");
        	log.info("start가 없어 종료함.");
        	System.exit(-1);
        }


	}

}



