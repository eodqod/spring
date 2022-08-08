package kr.human.email;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootTest
class BootEmailEx01ApplicationTests {

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Test
	void contextLoads() {
		assertNotNull(javaMailSender);
	}

}
