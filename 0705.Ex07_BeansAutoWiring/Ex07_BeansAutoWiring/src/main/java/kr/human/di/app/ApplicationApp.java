package kr.human.di.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.human.di.vo.Application;

public class ApplicationApp {
	public static void main(String[] args) {
		AbstractApplicationContext context =
				new ClassPathXmlApplicationContext("Application.xml");
		
		Application application1 = context.getBean("application1", Application.class);
		System.out.println(application1);
		
		Application application2 = context.getBean("application2", Application.class);
		System.out.println(application2);
		
		context.close();
	}
}
