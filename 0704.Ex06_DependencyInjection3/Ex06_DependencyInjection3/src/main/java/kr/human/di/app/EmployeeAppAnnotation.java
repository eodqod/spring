package kr.human.di.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import kr.human.di.config.EmployeeConfig;
import kr.human.di.vo.Employee;

public class EmployeeAppAnnotation {
	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(EmployeeConfig.class);
		
		Employee employee = context.getBean("employee", Employee.class);
		System.out.println(employee);
		
		context.close();
	}
}
