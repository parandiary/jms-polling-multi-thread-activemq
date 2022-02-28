package com.e1.ims.trk;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;

import com.e1.ims.trk.listener.BootListener;

@SpringBootApplication
public class Demo1Application implements ApplicationRunner, CommandLineRunner  {

	// file log를 위해 사용
	private static final Logger log = LoggerFactory.getLogger(Demo1Application.class);
	private static String PROFILE = "DEV";

	public static void main(String[] args) throws InterruptedException {


		System.out.println("check env IMS_HOME : "+ System.getenv("IMS_HOME"));
		System.out.println("check env TRK_HOME : "+ System.getenv("TRK_HOME"));


		System.out.println("JVM argument TRK_HOME : "+ System.getProperty("TRK_HOME"));
		System.out.println("JVM argument tracker_name : "+ System.getProperty("tracker_name"));





		String fileStr = System.getenv("IMS_HOME") + File.separator + "ctl" + File.separator + "TRK_" + PROFILE + ".pid";
		System.out.println("fileStr : "+fileStr);
		File pidFile = new File(fileStr);

		log.info("Start Application");
		//SpringApplication.run(Demo1Application.class, args);
		SpringApplication app = new SpringApplication(Demo1Application.class);
		app.addListeners(new BootListener());
		app.addListeners(new ApplicationPidFileWriter(pidFile));
		app.run(args);

		System.out.println("Application 시작됨");

//		int idx=0;
//		while(idx++ < 10) {
//
//			log.info("while {}",idx);
//			Thread.sleep(1000);
//		}



	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		if(args.getNonOptionArgs().size() > 0) PROFILE = args.getNonOptionArgs().get(0);
		log.debug("ApplicationRunner PROFILE {} checked ", PROFILE);
	}

	//CommandLineRunner - daemon화
	@Override
	public void run(String... args) throws Exception {
		log.info("Joining thread, you can press Ctrl+C to shutdown application");
        Thread.currentThread().join();
	}

}
