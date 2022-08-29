package com.example.ex01;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Ex01Application {

	public static void main(String[] args) {
		SpringApplication.run(Ex01Application.class, args);
	}
	@Bean
	public CommandLineRunner start1() throws Exception {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				System.out.println("http://localhost:8080/ 접속!!!!");
			}
		};
	}
	
}
