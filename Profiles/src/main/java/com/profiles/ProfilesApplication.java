package com.profiles;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProfilesApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProfilesApplication.class, args);

	}

	@Value(value = "${spring.datasource.url}")
	String environment_URL;

	@Value(value = "${server.port}")
	String port;

	@Value(value = "${spring.application.name}")
	String name;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Connected to environment url is    " + environment_URL);
		System.out.println("app name  " + name);
	}

}
