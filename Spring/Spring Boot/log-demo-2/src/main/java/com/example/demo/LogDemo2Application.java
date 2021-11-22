package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class LogDemo2Application {

	private static final Logger logger=LoggerFactory.getLogger(LogDemo2Application.class);
	
	@GetMapping("/")
	public String home()
	{
		for(int i=0;i<Integer.MAX_VALUE;i++)
			logger.warn("This is a log entry created by Jag..."+i);
		return "Hi world";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(LogDemo2Application.class, args);
	}

}
