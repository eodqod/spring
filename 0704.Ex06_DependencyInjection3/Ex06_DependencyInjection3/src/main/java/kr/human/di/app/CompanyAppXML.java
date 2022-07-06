package kr.human.di.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.human.di.vo.Company;

public class CompanyAppXML {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("Company.xml");
		
		Company company1 = context.getBean("company1", Company.class);
		System.out.println(company1);
		company1.display();
		System.out.println();
		
		Company company2 = context.getBean("company2", Company.class);
		System.out.println(company2);
		company2.display();
		System.out.println();
		
		context.close();
	}
}
