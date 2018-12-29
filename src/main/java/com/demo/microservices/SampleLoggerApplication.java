package com.demo.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SampleLoggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleLoggerApplication.class, args);
	}

}

