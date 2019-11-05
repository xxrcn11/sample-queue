package com.bt.sample.queue.service;

import java.util.concurrent.BlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Receiver {

	private static final Logger log = LoggerFactory.getLogger(Receiver.class);
	@Autowired
	private BlockingQueue<String> queue;
	
	@RequestMapping("/receive")
	public String receive(String msg) {
		
		log.info("메시지 수신 : {}", msg);
		queue.add(msg);
		
		log.info("size={}", queue.size());
		
		return "Hello " + msg;
	}
}
