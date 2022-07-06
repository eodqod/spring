package kr.human.di.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.human.di.vo.Employee;

public class EmployeeAppXML {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("Employee.xml");
		
		Employee employee = context.getBean("employee", Employee.class);
		System.out.println(employee);
		
		context.close();
	}
}
