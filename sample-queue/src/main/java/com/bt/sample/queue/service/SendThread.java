package com.bt.sample.queue.service;

import java.util.concurrent.BlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SendThread implements Runnable {

	private static final Logger log = LoggerFactory.getLogger(Receiver.class);
	private BlockingQueue<String> queue;
	
	public SendThread(BlockingQueue<String> queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		log.info("thread start {}",Thread.currentThread().getName() );
		String message = null;
		while(true) {
			try {
				message = this.queue.take();
				log.info("{} 송신 메시지 : {}", Thread.currentThread().getName() , message);
			} catch (InterruptedException e) {
				log.error("InterruptedException", e);
			}
			
		}

	}

}
