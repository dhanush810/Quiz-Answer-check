package com.dhanunsh.AnswerCheck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.dhanunsh.AnswerCheck.Service","com.dhanush.AnswerCheck.controller","com.dhanush.AsnwerCheck.model"})
@EnableMongoRepositories("com.dhanush.AnswerCheck.Repository")
public class AnswerCheckApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnswerCheckApplication.class, args);
	}

}
