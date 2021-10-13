package com.hexa.air;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.hexa.air.repository"})
public class AirlinereservationsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirlinereservationsystemApplication.class, args);
	}

}
