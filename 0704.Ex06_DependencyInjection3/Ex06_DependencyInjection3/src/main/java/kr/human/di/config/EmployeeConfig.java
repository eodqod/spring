package kr.human.di.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kr.human.di.vo.Address;
import kr.human.di.vo.Employee;

@Configuration
public class EmployeeConfig {
	
	@Bean(name = "address")
	public Address getAddress() {
		return new Address("1004", "20220001", "수원시", "대한민국");
	}

	@Bean // 이름을 생략하면 무엇이 될까? 메서드명이 된다.
	public Employee employee() {
		return new Employee("220001", "emp001", "휴먼아카데미", getAddress());
	}
}
