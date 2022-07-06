package kr.human.di.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.human.di.vo.QuestionVO;

public class QuestionVOMain {
	public static void main(String[] args) {
		AbstractApplicationContext context =
				new ClassPathXmlApplicationContext("Question.xml");
		
		QuestionVO vo1 = context.getBean("quest1", QuestionVO.class);
		System.out.println(vo1);
		
		QuestionVO vo2 = context.getBean("quest2", QuestionVO.class);
		System.out.println(vo2);
		
		context.close();
	}
}
