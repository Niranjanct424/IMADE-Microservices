package com.example.eruekaclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Value("${server.port}")
	String port_name;

	@RequestMapping("/welcome")
	public String getName() {
		System.out.println("Inside Client project");
		return "Hello Niranjan welcome to Eureka-client";
	}

	@GetMapping("/getuser")
	public User getUserDetails() {
		User user = new User("Niranjan", "Tangodar"+" from port "+port_name);
		return user;
	}

}
