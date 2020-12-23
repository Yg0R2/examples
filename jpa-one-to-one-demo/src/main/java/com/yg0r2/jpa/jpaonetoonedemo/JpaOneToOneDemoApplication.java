package com.yg0r2.jpa.jpaonetoonedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.yg0r2.jpa")
@EntityScan("com.yg0r2.jpa.model")
@EnableJpaRepositories(basePackages = "com.yg0r2.jpa.repository")
public class JpaOneToOneDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaOneToOneDemoApplication.class, args);
	}

}

