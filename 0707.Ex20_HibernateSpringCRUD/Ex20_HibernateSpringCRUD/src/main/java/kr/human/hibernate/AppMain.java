package kr.human.hibernate;

import java.util.List;
import java.util.Random;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.human.hibernate.service.StudentService;
import kr.human.hibernate.vo.Student;

public class AppMain {
	public static void main(String[] args) {
		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("AppConfig.xml");
		
		StudentService studentService = context.getBean("studentService", StudentService.class);
		
		selectList(studentService);
//		studentService.insert(new Student(0, "박", "문수", "초급프로그래머"));
//		studentService.insert(new Student(0, "박", "달봉", "중급프로그래머"));
		studentService.update(new Student(7, "강", "감찬", "장군"));
		System.out.println(studentService.selectById(7));
		System.out.println("-".repeat(80));
		try {
			studentService.delete(new Random().nextInt(20)+1);
			System.out.println("삭제성공");
		}catch (Exception e) {
			System.out.println("삭제실패");
		}
		selectList(studentService);
		
		context.close();
	}

	private static void selectList(StudentService studentService) {
		List<Student> list = studentService.selectList();
		if(list!=null && list.size()>0) {
			System.out.println("전체 : " + list.size() + "개\n" + "-".repeat(80));
			for(Student s : list) System.out.println(s);
			System.out.println("-".repeat(80));
		}
	}
}
