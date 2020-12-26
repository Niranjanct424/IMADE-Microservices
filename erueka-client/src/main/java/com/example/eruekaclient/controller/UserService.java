package com.example.eruekaclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class UserService {

	@Autowired
	RestTemplate restTemplate;


	@HystrixCommand(fallbackMethod = "defaultFallbackCallGetUser")
	public User getUser() {
		User user = new User();
		 user = restTemplate.getForObject("http://eureka-client2/getuser", User.class);
		 return user;
	}
	
	public User defaultFallbackCallGetUser(){
		System.out.println("*********************Inside fallback*******************");
		User user = new User("", ""+"Server is down Try after some time");
		return user;
		
	}

}
