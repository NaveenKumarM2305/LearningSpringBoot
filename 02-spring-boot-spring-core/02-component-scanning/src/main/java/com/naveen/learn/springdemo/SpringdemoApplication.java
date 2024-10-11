package com.naveen.learn.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// USED TO SCAN PACKAGES THAT ARE OUTSIDE springdemo
/*
@SpringBootApplication(
		scanBasePackages = {"com.naveen.learn.springdemo",
		"com.naveen.util"})
*/

@SpringBootApplication
public class SpringdemoApplication {


	public static void main(String[] args) {
		SpringApplication.run(SpringdemoApplication.class, args);
	}

}
