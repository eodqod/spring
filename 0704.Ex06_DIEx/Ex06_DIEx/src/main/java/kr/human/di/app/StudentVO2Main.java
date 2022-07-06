package kr.human.di.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.human.di.vo.StudentVO2;

public class StudentVO2Main {
	public static void main(String[] args) {
		AbstractApplicationContext context =
				new ClassPathXmlApplicationContext("StudentVO2.xml");
		
		StudentVO2 vo1 = context.getBean("stu2", StudentVO2.class);
		System.out.println(vo1);
		vo1.cheating();
		
		context.close();
	}
}
