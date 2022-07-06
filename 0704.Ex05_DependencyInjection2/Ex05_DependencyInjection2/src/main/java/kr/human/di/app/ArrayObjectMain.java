package kr.human.di.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.human.di.vo.ArrayObject;

public class ArrayObjectMain {
	public static void main(String[] args) {
		AbstractApplicationContext context =
				new ClassPathXmlApplicationContext("ArrayObject.xml");
		
		ArrayObject object = context.getBean("arrayObject", ArrayObject.class);
		System.out.println(object);
		
		ArrayObject object2 = context.getBean("arrayObject2", ArrayObject.class);
		System.out.println(object2);
		
		context.close();
	}
}
