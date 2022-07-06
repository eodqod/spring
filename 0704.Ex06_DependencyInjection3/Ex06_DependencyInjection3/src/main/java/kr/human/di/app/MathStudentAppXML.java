package kr.human.di.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.human.di.vo.MathStudent;

public class MathStudentAppXML {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("MathStudent.xml");
		
		MathStudent student1 = context.getBean("mathStudent1", MathStudent.class);
		student1.cheating();

		MathStudent student2 = context.getBean("mathStudent2", MathStudent.class);
		student2.cheating();
		
		context.close();
	}
}
