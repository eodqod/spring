package kr.human.di.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kr.human.di.vo.Company;
import kr.human.di.vo.Employee2;

@Configuration
public class CompanyConfig {
	
	@Bean(name = "emp1")
	public Employee2 emp1() {
		return new Employee2("한사람", "220001", "총무부");
	}
	@Bean
	public Employee2 emp2() {
		return new Employee2("두사람", "220002", "인사처");
	}
	@Bean
	public Employee2 emp3() {
		return new Employee2("세사람", "220003", "인력개발부");
	}
	
	@Bean
	public List<Employee2> list(){
		List<Employee2> list = new ArrayList<>();
		list.add(emp1());
		list.add(emp2());
		list.add(emp3());
		return list;
	}
	
	@Bean
	public Company company1() {
		return new Company("(주)사람인", list());
	}

	@Bean
	public Company company2() {
		Company company =  new Company();
		company.setCompanyName("(주)휴먼컴");
		company.setEmployees(list());
		return company;
	}
}
