package com.knoldus.MentorService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MentorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MentorServiceApplication.class, args);
	}

	/**
	 * This method creates and returns a {@code RestTemplate} object, which is used to make RESTful API calls.
	 * The object is a Spring bean, and is automatically managed by the Spring container.
	 * @return a new {@code RestTemplate} object
	 */
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
