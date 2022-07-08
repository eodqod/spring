package kr.human.di.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.human.di.vo.Performer;

public class PerfomerApp {
	public static void main(String[] args) {
		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("Performer.xml");
		
		Performer performer1 = context.getBean("performer1", Performer.class);
		System.out.println(performer1);
		
		Performer performer2 = context.getBean("performer2", Performer.class);
		System.out.println(performer2);
		
		context.close();
	}
}
