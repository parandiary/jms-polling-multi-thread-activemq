package com.e1.ims.trk.executer;

import java.util.List;

import org.springframework.scheduling.annotation.Async;

public interface TrkLogExecutor {

	@Async("dbProcThreadPoolTaskExecutor")
    void insertRmLog(List messages) throws Exception;

	@Async("dbProcThreadPoolTaskExecutor")
	void insertRmLogBuf(List messages) throws Exception;

	void syncTest(String param) throws Exception;

}
