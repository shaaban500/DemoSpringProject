package com.example.demoSpringApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoSpringAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringAppApplication.class, args);
		System.out.println("Server Running");
	}

}
