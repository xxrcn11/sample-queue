package com.bt.sample.queue.service;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class SenderStartup implements ApplicationListener<ApplicationReadyEvent> {

	private static final Logger log = LoggerFactory.getLogger(Receiver.class);
	
	@Autowired
	private BlockingQueue<String> queue;
	
	
	@Autowired
	private Executor threadPoolTaskExecutor;
	
	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		log.info("================================ Application Ready Evnet");
		
		
		threadPoolTaskExecutor.execute(new SendThread(queue));
		threadPoolTaskExecutor.execute(new SendThread(queue));
		threadPoolTaskExecutor.execute(new SendThread(queue));
	}

}
