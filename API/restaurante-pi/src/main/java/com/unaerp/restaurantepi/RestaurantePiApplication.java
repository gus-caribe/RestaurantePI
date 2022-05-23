package com.unaerp.restaurantepi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class RestaurantePiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantePiApplication.class, args);
	}

}
