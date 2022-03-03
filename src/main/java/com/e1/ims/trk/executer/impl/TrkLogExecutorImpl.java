package com.e1.ims.trk.executer.impl;

import java.util.List;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.e1.ims.trk.executer.TrkLogExecutor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TrkLogExecutorImpl implements TrkLogExecutor {

	@Override
	public void syncTest(String param) throws Exception {
		log.debug("TrkLogServiceImpl message {} ", param);
		Thread.sleep(1000);
	}



	@Override
	@Async("dbProcThreadPoolTaskExecutor")
	public void insertRmLog(List messages) throws Exception {
		log.debug("TrkLogServiceImpl insertRmLog messages {} ", messages);
		Thread.sleep(1000);

	}


	@Override
	@Async("dbProcThreadPoolTaskExecutor")
	public void insertRmLogBuf(List messages) throws Exception {
		log.debug("TrkLogServiceImpl insertRmLogBuf messages {} ", messages);
		Thread.sleep(500);

	}

}
