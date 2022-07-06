package kr.human.hello.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.human.hello.vo.HelloWorld;

public class AppMain03 {
	public static void main(String[] args) {
		// 환경설정 파일을 읽어서 컨텍스트 객체를 얻어라
		// 컨텍스트 : 이 애플리케이션의 모든 정보를 갖고 있는 스프링 컨테이너이다.
		AbstractApplicationContext context =
				new ClassPathXmlApplicationContext("AppMain03.xml");
		
		// 스프링 컨테이너에서 필요한 객체를 찾아온다.
		HelloWorld helloWorld = context.getBean("helloWorld", HelloWorld.class);
		// 객체 사용
		helloWorld.sayHello("한사람");
		System.out.println(helloWorld.hashCode());
		
		HelloWorld helloWorld2 = context.getBean("helloWorld", HelloWorld.class);
		System.out.println(helloWorld2.hashCode());
		// 해쉬코드가 같다. 같은 객체다. 스프링이 알아서 싱글톤으로 관리한다.
		
		context.close();
	}
}
