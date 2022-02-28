package com.e1.ims.trk.config;

import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class TrackerThreadConfiguration {

	@Value("${tracker.min-pool-size}")
    private int minPoolSize;

	@Value("${tracker.max-pool-size}")
	private int maxPoolSize;

	@Value("${tracker.queue-size}")
	private int queueSize;


	@Bean(name = "logServiceExecutor")
	public ThreadPoolTaskExecutor threadPoolTaskExecutor() {

		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(minPoolSize);
		executor.setMaxPoolSize(maxPoolSize);
		executor.setQueueCapacity(queueSize);
		executor.setAllowCoreThreadTimeOut(false); // Core Thread도 종료 할지
		executor.setKeepAliveSeconds(20); // Thread 유지시간
		//executor.setThreadNamePrefix("Tracker_Execute_Thread-");

		executor.setThreadNamePrefix("Tracker_Thread-");
		executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy()); //가용 Thread가 없을 경우 자기 자신의 Thread 활용
		executor.setWaitForTasksToCompleteOnShutdown(true); // 처리하는 Thread 처리 완료 후 종료
		executor.setAwaitTerminationSeconds(60); // shutdown 최대 60초 대기
		executor.initialize();

		return executor;
	}


}
