package com.ispan.eeit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ispan.eeit._00_init.web.SystemInitializationListener;


@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class}
        )
public class DmotSdjpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DmotSdjpaApplication.class, args);
	}
	@Bean
	SystemInitializationListener executorListener() {
	   return new SystemInitializationListener();
	}
}
