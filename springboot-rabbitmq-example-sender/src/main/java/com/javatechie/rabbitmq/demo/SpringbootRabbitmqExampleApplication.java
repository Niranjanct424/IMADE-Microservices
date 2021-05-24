package com.javatechie.rabbitmq.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
//@EnableRetry
public class SpringbootRabbitmqExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRabbitmqExampleApplication.class, args);
	}

}
