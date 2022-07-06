package kr.human.di.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import kr.human.di.config.GeeksConfig;
import kr.human.di.vo.Geeks;

public class GeeksAppAnnotation {
	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(GeeksConfig.class);
		
		Geeks geeks = context.getBean("geeks", Geeks.class);
		System.out.println(geeks);
		geeks.geeksMessage();
		
		context.close();
	}
}
