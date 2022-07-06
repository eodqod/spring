package kr.human.di.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import kr.human.di.config.ArrayObjectConfig;
import kr.human.di.vo.ArrayObject;

public class ArrayObjectMain2 {
	public static void main(String[] args) {
		AbstractApplicationContext context =
				new AnnotationConfigApplicationContext(ArrayObjectConfig.class);
		
		ArrayObject object = context.getBean("arObj1", ArrayObject.class);
		System.out.println(object);
		
		ArrayObject object2 = context.getBean("arObj2", ArrayObject.class);
		System.out.println(object2);
		
		context.close();
	}
}
