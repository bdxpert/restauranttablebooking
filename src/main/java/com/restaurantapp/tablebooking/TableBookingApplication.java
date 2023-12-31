package com.restaurantapp.tablebooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class TableBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(TableBookingApplication.class, args);
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("*");
						//.allowedOrigins("sanjiv.com.s3.us-east-1.amazonaws.com")
						//.allowedOrigins("http://localhost:4200");
			}
		};
	}
}
