package com.e1.ims.trk.component;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Order(1)
@Slf4j
public class ApplicationOptionsRunner implements ApplicationRunner  {

	//private static final Logger log = LoggerFactory.getLogger(ApplicationOptionsRunner.class);


	@Override
	public void run(ApplicationArguments args) throws Exception {

		log.info("Argument Check runner1");
		System.out.println("sysout : argument check");


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




	}

}



