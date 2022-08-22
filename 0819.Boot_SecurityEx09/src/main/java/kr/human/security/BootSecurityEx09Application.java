package kr.human.security;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BootSecurityEx09Application {

	public static void main(String[] args) {
		SpringApplication.run(BootSecurityEx09Application.class, args);
	}
	
	@Bean
	public CommandLineRunner start1() throws Exception {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				System.out.println("http://localhost:8080 으로 접속해보세요!!");
			}
		};
	}

}
