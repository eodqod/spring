package kr.human.security03;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BootSecurityEx03Application {

	public static void main(String[] args) {
		SpringApplication.run(BootSecurityEx03Application.class, args);
	}
	@Bean
	public CommandLineRunner start1() throws Exception {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				System.out.println("CommandLineRunner 를 이용한 실행!!!");
				// 웹 브라우저 띄우기
				/*
				try {
					System.setProperty("java.awt.headless", "false");
					Desktop.getDesktop().browse(new URI("http://localhost:8080/"));
				} catch (IOException e) {
					e.printStackTrace();
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}
				*/
			}
		};
	}
}
