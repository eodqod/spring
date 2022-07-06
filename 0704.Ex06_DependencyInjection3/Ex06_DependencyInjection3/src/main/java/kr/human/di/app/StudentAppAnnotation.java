package kr.human.di.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import kr.human.di.config.StudentConfig;
import kr.human.di.vo.Student;

public class StudentAppAnnotation {
	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(StudentConfig.class);
		
		Student student1 = context.getBean("stu1", Student.class);
		System.out.println(student1.getStudentName() + "("+ student1.getStudentCourse() +")");
		
		Student student2 = context.getBean("stu2", Student.class);
		System.out.println(student2.getStudentName() + "("+ student2.getStudentCourse() +")");
		
		context.close();
	}
}
