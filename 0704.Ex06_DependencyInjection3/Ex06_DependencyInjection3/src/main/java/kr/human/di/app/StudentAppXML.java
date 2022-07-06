package kr.human.di.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.human.di.vo.Student;

public class StudentAppXML {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("Student.xml");
		
		Student student1 = context.getBean("stu1", Student.class);
		System.out.println(student1.getStudentName() + "("+ student1.getStudentCourse() +")");
		
		Student student2 = context.getBean("stu2", Student.class);
		System.out.println(student2.getStudentName() + "("+ student2.getStudentCourse() +")");
		
		context.close();
	}
}
