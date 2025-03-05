package com.backend.kudos;

import jakarta.persistence.Entity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "Model")
public class KudosApplication {

	public static void main(String[] args) {
		SpringApplication.run(KudosApplication.class, args);
	}

}
