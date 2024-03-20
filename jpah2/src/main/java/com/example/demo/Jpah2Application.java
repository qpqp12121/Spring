package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Jpah2Application {

	public static void main(String[] args) {
		SpringApplication.run(Jpah2Application.class, args);
	}
	
	@GetMapping("/")
	public String index() {
		return "hello";
	}

}
