package com.e1.ims.trk.service.impl;

import java.util.List;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.e1.ims.trk.service.TrkLogService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TrkLogServiceImpl implements TrkLogService {

	@Override
	@Async("logServiceExecutor")
	public void test(String param) throws Exception {
		log.debug("TrkLogServiceImpl message {} ", param);
		Thread.sleep(1000);
	}


	@Override
	public void syncTest(String param) throws Exception {
		log.debug("TrkLogServiceImpl message {} ", param);
		Thread.sleep(1000);
	}


	@Override
	@Async("logServiceExecutor")
	public void bulk(List messages) throws Exception {
		log.debug("TrkLogServiceImpl messages list {} ", messages);
		Thread.sleep(1000);

	}

}
