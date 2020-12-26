package com.example.eruekaclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/getName")
public class UserController {

	
	
	@Autowired
	UserService userService;

	@GetMapping("/user")
	public User getName() {
		
		
		User user = new User();
		user = userService.getUser();
		return user;
	}

	@GetMapping("/hello")
	public String helloUser() {
		return "Hello user";
	}

}
