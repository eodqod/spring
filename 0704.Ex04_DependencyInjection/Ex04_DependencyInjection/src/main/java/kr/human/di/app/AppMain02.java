package kr.human.di.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.human.di.vo.Communication;
import kr.human.di.vo.Encryption;
import kr.human.di.vo.Messaging;

public class AppMain02 {
	public static void main(String[] args) {
		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("AppMain02.xml");
		
		Communication communication = context.getBean("communication", Communication.class);
		communication.communicate();
		
		Messaging messaging = context.getBean("messaging", Messaging.class);
		messaging.sendMessage();
		
		Encryption encryption = context.getBean("encryption", Encryption.class);
		encryption.encryptData();
		
		Communication communication2 = context.getBean("communication", Communication.class);
		communication.communicate();
		
		Communication communication3 = context.getBean("communication", Communication.class);
		communication.communicate();
		context.close();
	}
}
