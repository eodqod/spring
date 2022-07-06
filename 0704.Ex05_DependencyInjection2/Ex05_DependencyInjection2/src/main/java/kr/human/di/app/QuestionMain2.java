package kr.human.di.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import kr.human.di.config.QuestionConfig;
import kr.human.di.vo.QuestionVO;

public class QuestionMain2 {
	public static void main(String[] args) {
		AbstractApplicationContext context = 
				new AnnotationConfigApplicationContext(QuestionConfig.class);
		
		QuestionVO vo1 = context.getBean("question1", QuestionVO.class);
		System.out.println(vo1);
		
		QuestionVO vo2 = context.getBean("question2", QuestionVO.class);
		System.out.println(vo2);
		
		context.close();
	}
}
