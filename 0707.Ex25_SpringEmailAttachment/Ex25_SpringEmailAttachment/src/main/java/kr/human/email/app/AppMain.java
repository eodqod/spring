package kr.human.email.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.human.email.service.MailService;

public class AppMain {
	public static void main(String[] args) {
		// 메일 발송
		AbstractApplicationContext context =
				new ClassPathXmlApplicationContext("AppConfig.xml");
		
		MailService mailService = context.getBean("mailService", MailService.class);
		
		mailService.sendEmail();
		
		mailService.sendEmail("oss7140@naver.com", "제목", "<h1>내용</h1>");
		
		context.close();
	}
}
