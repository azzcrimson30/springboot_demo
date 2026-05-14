package com.examplemyproject.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner debugLocalMongo(MongoTemplate mongoTemplate) {
		return args -> {
			System.out.println("============== LOCAL MONGO DIAGNOSTIC ==============");
			System.out.println("Target Database: " + mongoTemplate.getDb().getName());
			System.out.println("Collections Found:");
			for (String name : mongoTemplate.getDb().listCollectionNames()) {
				System.out.println(" -> " + name);
			}
			System.out.println("====================================================");
		};
	}

}
