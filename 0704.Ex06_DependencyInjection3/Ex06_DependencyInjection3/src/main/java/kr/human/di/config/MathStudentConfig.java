package kr.human.di.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kr.human.di.vo.MathCheat;
import kr.human.di.vo.MathStudent;

@Configuration
public class MathStudentConfig {
	
	@Bean
	public MathCheat mathCheat() {
		return new MathCheat();
	}
	
	@Bean(name = "mathStudent1")
	public MathStudent getMathStudent1() {
		return new MathStudent(2022340001, mathCheat());
	}

	@Bean(name = "mathStudent2")
	public MathStudent getMathStudent2() {
		return new MathStudent(2022340001, new MathCheat());
	}

	@Bean(name = "mathStudent3")
	public MathStudent getMathStudent3() {
		MathStudent mathStudent = new MathStudent();
		mathStudent.setId(2022340003);
		mathStudent.setMathCheat(mathCheat());
		return mathStudent;
	}

	@Bean(name = "mathStudent4")
	public MathStudent getMathStudent4() {
		MathStudent mathStudent = new MathStudent();
		mathStudent.setId(2022340004);
		mathStudent.setMathCheat(new MathCheat());
		return mathStudent;
	}
}
