package kr.human.di.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.human.di.vo.SetObject;

public class SetObjectMain {
	public static void main(String[] args) {
		AbstractApplicationContext context =
				new ClassPathXmlApplicationContext("SetObject.xml");

		SetObject object = context.getBean("setObj1", SetObject.class);
		System.out.println(object);
		
		SetObject object2 = context.getBean("setObj2", SetObject.class);
		System.out.println(object2);
		
		context.close();
	}
}
