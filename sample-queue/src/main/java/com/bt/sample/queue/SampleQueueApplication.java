package com.bt.sample.queue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SampleQueueApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleQueueApplication.class, args);
		
		System.out.println("Hi!");
	}

}
