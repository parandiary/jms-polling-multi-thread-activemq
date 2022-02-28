package com.e1.ims.trk.component;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Order(3)
@Slf4j
public class ApplicationConfigCheckRunner implements ApplicationRunner  {

	//private static final Logger log = LoggerFactory.getLogger(ApplicationConfigCheckRunner.class);
	//@Slf4j 어노테이션을 사용하고 loombook에 IDE를 추가하면 logger를 따로 정의 안해 줘도 된다.

	@Override
	public void run(ApplicationArguments args) throws Exception {

		log.info("Config File Check");
		System.out.println("sysout : Config File check");


	}

}



