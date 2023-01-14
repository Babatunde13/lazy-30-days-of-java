package com.day5.day5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(exclude =  {DataSourceAutoConfiguration.class })
@EnableMongoRepositories
public class Day5Application {

	public static void main(String[] args) {
		SpringApplication.run(Day5Application.class, args);
	}
}
