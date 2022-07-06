package kr.human.di.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.human.di.vo.StudentVO;

public class StudentVOMain {
	public static void main(String[] args) {
		AbstractApplicationContext context =
				new ClassPathXmlApplicationContext("StudentVO.xml");
		
		StudentVO vo1 = context.getBean("stu", StudentVO.class);
		System.out.println(vo1);
		
		context.close();
	}
}
