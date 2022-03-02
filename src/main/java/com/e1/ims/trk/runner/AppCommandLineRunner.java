package com.e1.ims.trk.runner;

import java.io.IOException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(9)
@Component
public class AppCommandLineRunner implements CommandLineRunner  {

	@Override
	public void run(String... args) throws Exception {

		//Spring boot application을 바로 종료 처리 하지 않고 kill 시그널로 종료 가능하게 함.

		//Thread.currentThread().join();

		if(Boolean.parseBoolean(System.getenv("RUNNING_IN_ECLIPSE"))) {
			System.out.println("using eclipse click in this console and press ENTER to call System.exit ");
			try {
				System.in.read();
			}catch(IOException e){
				e.printStackTrace();
			}

			System.exit(0);
		}

	}

}
