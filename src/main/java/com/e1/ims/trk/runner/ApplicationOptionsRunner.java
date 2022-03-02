package com.e1.ims.trk.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.e1.ims.trk.Demo1Application;

import lombok.extern.slf4j.Slf4j;

@Component
@Order(1)
@Slf4j
public class ApplicationOptionsRunner implements ApplicationRunner  {


	@Override
	public void run(ApplicationArguments args) throws Exception {

		log.info("Argument Check runner1");
		System.out.println("sysout : argument check");


		//profile check
		if(args.getNonOptionArgs().size() > 0) Demo1Application.PROFILE = args.getNonOptionArgs().get(0);
		else Demo1Application.PROFILE = "DEV";
		log.debug("ApplicationRunner PROFILE {} checked ", Demo1Application.PROFILE);


		// check Program Argument
        System.out.println("is contained 'IMS_HOME' : "  + args.containsOption("IMS_HOME"));
        System.out.println("is 'IMS_HOME' : "  + args.getOptionValues("IMS_HOME"));
        System.out.println("is contained 'bar' : "  + args.containsOption("bar"));

        log.debug("program argument getOptionNames {}",args.getOptionNames()); //-- 붙은거
        log.debug("program argument getNonOptionArgs {}",args.getNonOptionArgs()); //--없는거


        // check ENV variables
        System.out.println("env IMS_HOME : "+ System.getenv("IMS_HOME"));

        // check JVM Argument
        System.out.println("JVM argument TRK_HOME : "+ System.getProperty("TRK_HOME"));
		System.out.println("JVM argument tracker_name : "+ System.getProperty("tracker_name"));
        System.out.println("env IMS_HOME : "+ System.getenv("IMS_HOME"));

//        if(!args.containsOption("start")) {
//        	System.out.println("start가 없어 종료함.");
//        	log.info("start가 없어 종료함.");
//        	System.exit(-1);
//        }

	}

}



