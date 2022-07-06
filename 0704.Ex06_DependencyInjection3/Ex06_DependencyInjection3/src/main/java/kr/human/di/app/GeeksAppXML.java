package kr.human.di.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.human.di.vo.Geeks;

public class GeeksAppXML {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("Geeks.xml");
		
		Geeks geeks = context.getBean("geeks", Geeks.class);
		System.out.println(geeks);
		geeks.geeksMessage();
		
		Geeks geeks2 = context.getBean("geeks2", Geeks.class);
		System.out.println(geeks2);
		geeks2.geeksMessage();
		
		context.close();
	}
}
