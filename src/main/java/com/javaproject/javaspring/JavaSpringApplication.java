package com.javaproject.javaspring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/**
 * <p> This is the main class of the application </p>
 */
public class JavaSpringApplication {

	private static final Logger logger = LoggerFactory.getLogger(SpringApplication.class);
	public static void main(String[] args) {
		logger.info("Init the application...");
		SpringApplication.run(JavaSpringApplication.class, args);
	}

}
