package com.example.SpringBootJsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.example.Transaction","com.example.model"})
public class SpringBootJspApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJspApplication.class, args);
	}

}
