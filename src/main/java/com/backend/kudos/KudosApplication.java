package com.backend.kudos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "Model")
@ComponentScan(basePackages = "Security")
@EnableJpaRepositories("Repository")
public class KudosApplication {
	public static void main(String[] args) {
		SpringApplication.run(KudosApplication.class, args);
	}
}