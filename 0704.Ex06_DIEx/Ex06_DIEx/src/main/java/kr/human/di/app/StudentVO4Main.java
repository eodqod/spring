package kr.human.di.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.human.di.vo.StudentVO4;

public class StudentVO4Main {
	public static void main(String[] args) {
		AbstractApplicationContext context =
				new ClassPathXmlApplicationContext("StudentVO4.xml");
		
		StudentVO4 vo1 = context.getBean("stu4", StudentVO4.class);
		System.out.println(vo1);
		
		context.close();
	}
}
