package kr.human.di.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import kr.human.di.config.MathStudentConfig;
import kr.human.di.vo.MathStudent;

public class MathStudentAppAnnotation {
	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(MathStudentConfig.class);
		
		MathStudent student1 = context.getBean("mathStudent1", MathStudent.class);
		student1.cheating();

		MathStudent student2 = context.getBean("mathStudent2", MathStudent.class);
		student2.cheating();

		MathStudent student3 = context.getBean("mathStudent3", MathStudent.class);
		student3.cheating();
		
		MathStudent student4 = context.getBean("mathStudent4", MathStudent.class);
		student4.cheating();
		
		context.close();
	}
}
