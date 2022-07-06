package kr.human.di.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.human.di.vo.Company;

public class CompanyMain {
	public static void main(String[] args) {
		AbstractApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Company com = context.getBean("company", Company.class);
		com.display();
		
		context.close();
	}
}
