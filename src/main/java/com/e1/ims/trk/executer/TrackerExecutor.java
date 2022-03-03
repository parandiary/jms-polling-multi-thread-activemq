package com.e1.ims.trk.executer;

import org.springframework.scheduling.annotation.Async;

public interface TrackerExecutor {

	@Async("trackerThreadPoolTaskExecutor")
    void asyncProcTracker(String param) throws Exception;

}
