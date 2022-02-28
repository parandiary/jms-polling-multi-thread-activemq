package com.e1.ims.trk.service;

import java.util.List;

import org.springframework.scheduling.annotation.Async;

public interface TrkLogService {

	@Async("logServiceExecutor")
    void test(String param) throws Exception;

	@Async("logServiceExecutor")
	void bulk(List messages) throws Exception;

	void syncTest(String param) throws Exception;

}
