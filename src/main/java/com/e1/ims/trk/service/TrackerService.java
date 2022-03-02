package com.e1.ims.trk.service;

import org.springframework.scheduling.annotation.Async;

public interface TrackerService {

	@Async("trackerThreadPoolTaskExecutor")
    void asyncProcTracker(String param) throws Exception;

}
