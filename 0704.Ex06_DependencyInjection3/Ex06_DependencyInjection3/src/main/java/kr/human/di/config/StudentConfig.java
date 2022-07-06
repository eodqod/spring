package kr.human.di.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kr.human.di.vo.Student;

@Configuration
public class StudentConfig {
	
	@Bean(name = "stu1")
	public Student getStudent1() {
		return new Student("세사람", "웹 개발자 되기");
	}

	@Bean(name = "stu2")
	public Student getStudent2() {
		Student student = new Student();
		student.setStudentName("네사람");
		student.setStudentCourse("서버 개발자 되기");
		return student;
	}
}
