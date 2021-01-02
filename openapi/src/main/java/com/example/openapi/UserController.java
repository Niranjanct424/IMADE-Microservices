package com.example.openapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("users")
@OpenAPIDefinition(info = @Info (title = "User APIS ", description = "Apis to check user crud operations", version = "1.0") )
public class UserController {
	
	@GetMapping("/getName/{name}")
//	@ApiResponse(description = "display user name", responseCode = "200")
	public String name(@PathVariable String name) {
		return " your name is "+name;
		
	}
	
	@GetMapping("/greet")
	public String greet() {
		return "Hello user";
		
	}

}
