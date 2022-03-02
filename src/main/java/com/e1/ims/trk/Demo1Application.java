package com.e1.ims.trk;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class Demo1Application implements ApplicationListener<ContextClosedEvent>  {

	public volatile static boolean STOP = false;

	final Object event = new Object();

	//private static final Logger log = LoggerFactory.getLogger(Demo1Application.class);
	public static String IMS_HOME = "";
	public static String PROFILE = "DEV";

	public static void main(String[] args) throws InterruptedException {

		String userDirectory = new File("").getAbsolutePath();
		System.out.println("userDirectory : " + userDirectory);

		if(null == System.getenv("IMS_HOME") || "".equals(System.getenv("IMS_HOME")) || "null".equals(System.getenv("IMS_HOME"))) {
			IMS_HOME = new File("").getAbsolutePath() ;
		}else {
			IMS_HOME = System.getenv("IMS_HOME") ;
		}

		String fileStr = IMS_HOME + File.separator + "ctl" + File.separator + "TRK_" + PROFILE + ".pid";
		File pidFile = new File(fileStr);

		log.info("Start Application");

		SpringApplication app = new SpringApplication(Demo1Application.class);
		app.addListeners(new ApplicationPidFileWriter(pidFile));
		app.run(args);

		System.out.println("Application 시작됨");


		// 이클립스에서 종료 테스트를 위해 설정함.ㅇ
		// 이클립스 환경변수에 RUNNING_IN_ECLIPSE 를 true로 설정해 놓기
//		if(Boolean.parseBoolean(System.getenv("RUNNING_IN_ECLIPSE"))) {
//			System.out.println("using eclipse click in this console and press ENTER to call System.exit ");
//			try {
//				System.in.read();
//			}catch(IOException e){
//				e.printStackTrace();
//			}
//
//			System.exit(0);
//		}


	}



//	@PreDestroy
//	public void onExit() {
//		log.info("###STOPing onExit ###");
//		System.out.println(">>>>>>>>>>>>>@PreDestroy");
//		try {
//			Thread.sleep(1 * 1000);
//		} catch (InterruptedException e) {
//			log.error("", e);
//		}
//		log.info("###STOP FROM THE LIFECYCLE onExit ###");
//	}

	@Override
	public void onApplicationEvent(ContextClosedEvent event) {
		log.info("Protocol handler is shutting down");
		System.out.println(">>>>>>>>>>>>onApplicationEvent");
		log.info("###STOPing###");
		STOP = true;

		try {
			Thread.sleep(2 * 1000);
		} catch (InterruptedException e) {
			log.error("", e);
		}
		log.info("###STOP FROM THE LIFECYCLE###");
		System.out.println(">>>>>>>>>>>>onApplicationEvent STOPED");
	}


}
