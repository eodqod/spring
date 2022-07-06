package kr.human.di.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import kr.human.di.config.CompanyConfig;
import kr.human.di.vo.Company;

public class CompanyAppAnnotation {
	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(CompanyConfig.class);
		
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
