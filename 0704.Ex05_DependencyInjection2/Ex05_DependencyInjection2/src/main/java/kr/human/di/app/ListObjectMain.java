package kr.human.di.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.human.di.vo.ListObject;

public class ListObjectMain {
	public static void main(String[] args) {
		AbstractApplicationContext context =
				new ClassPathXmlApplicationContext("ListObject.xml");

		ListObject object = context.getBean("listObj1", ListObject.class);
		System.out.println(object);
		
		ListObject object2 = context.getBean("listObj2", ListObject.class);
		System.out.println(object2);
		
		ListObject object3 = context.getBean("listObj3", ListObject.class);
		System.out.println(object3);
		
		context.close();
	}
}
