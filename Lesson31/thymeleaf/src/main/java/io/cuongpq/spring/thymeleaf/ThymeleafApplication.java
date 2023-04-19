package io.cuongpq.spring.thymeleaf;

import io.cuongpq.spring.thymeleaf.services.DatabaseService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ThymeleafApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThymeleafApplication.class, args);
		DatabaseService databaseService = DatabaseService.getInstance();
	}

}
