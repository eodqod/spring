package kr.human.di.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import kr.human.di.config.SetObjectConfig;
import kr.human.di.vo.SetObject;

public class SetObjectMain2 {
	public static void main(String[] args) {
		AbstractApplicationContext context =
				new AnnotationConfigApplicationContext(SetObjectConfig.class);

		SetObject object = context.getBean("setObj1", SetObject.class);
		System.out.println(object);
		
		SetObject object2 = context.getBean("setObj2", SetObject.class);
		System.out.println(object2);
		
		context.close();
	}
}
