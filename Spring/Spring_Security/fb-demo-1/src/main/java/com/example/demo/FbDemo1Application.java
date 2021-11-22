package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableOAuth2Sso
@RestController
public class FbDemo1Application {

	@GetMapping("/")
	public String home()
	{
		return "hello world";
	}
	
	@GetMapping("/callback")
	public String callback()
	{
		return "Welcome to home page. You are authenticated!";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(FbDemo1Application.class, args);
	}

}
