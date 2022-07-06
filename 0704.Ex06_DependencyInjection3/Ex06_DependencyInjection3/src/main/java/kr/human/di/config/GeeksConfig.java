package kr.human.di.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kr.human.di.vo.Geeks;

@Configuration
public class GeeksConfig {

	@Bean
	public Geeks geeks() {
		return Geeks.getInstance();
	}
	
}
