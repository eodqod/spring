package kr.human.di.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.human.di.vo.AnswerVO;
import kr.human.di.vo.UserVO;

public class AnswerMain {
	public static void main(String[] args) {
		AbstractApplicationContext context =
				new ClassPathXmlApplicationContext("Answer.xml");
		
		AnswerVO vo1 = context.getBean("answer1", AnswerVO.class);
		System.out.println(vo1);
		
		AnswerVO vo2 = context.getBean("answer2", AnswerVO.class);
		System.out.println(vo2);
		
		UserVO vo3 = context.getBean("user1", UserVO.class);
		System.out.println(vo3);
		
		UserVO vo4 = context.getBean("user2", UserVO.class);
		System.out.println(vo4);
		
		context.close();
	}
}
