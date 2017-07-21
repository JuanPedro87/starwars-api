package com.example.start.wars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// para eventListener
//@EnableJpaAuditing
public class StartwarsApplication {

	public static void main(String[] args) {
		SpringApplication.run(StartwarsApplication.class, args);
	}
}
