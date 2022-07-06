package kr.human.di.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.human.di.vo.StudentVO3;

public class StudentVO3Main {
	public static void main(String[] args) {
		AbstractApplicationContext context =
				new ClassPathXmlApplicationContext("StudentVO3.xml");
		
		StudentVO3 vo1 = context.getBean("stu3", StudentVO3.class);
		System.out.println(vo1);
		vo1.displayInfo();
		
		context.close();
	}
}
