package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

// Esta anotação marca a classe como a classe principal da aplicação Spring Boot
@SpringBootApplication
// Esta anotação especifica os pacotes que o Spring Boot deve escanear em busca de classes de entidades JPA.
@EntityScan(basePackages = "com.example.demo")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
