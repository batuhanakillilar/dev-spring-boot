package com.demo.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
@SpringBootApplication(
		//explicitly list base packages to scan
		scanBasePackages = {
				"com.demo.springcoredemo",
				"com.luv2code.util"
		}
)*/
@SpringBootApplication
public class SpringcoredemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringcoredemoApplication.class, args);
	}

}
