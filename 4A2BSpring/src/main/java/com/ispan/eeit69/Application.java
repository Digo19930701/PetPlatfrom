package com.ispan.eeit69;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		System.out.println("Application.java進入點");
		SpringApplication.run(Application.class, args);
	}

}
