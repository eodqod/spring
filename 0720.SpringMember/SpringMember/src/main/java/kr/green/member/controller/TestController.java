package kr.green.member.controller;

import java.util.HashMap;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.green.member.service.TestService;
import kr.green.member.vo.TestVO;
import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
public class TestController {

	@Autowired
	private TestService testService;
	
	@RequestMapping(value = "/test")
	public String test(Model model, 
			@RequestParam(required = false) Integer num1,
			@RequestParam(required = false) Integer num2) {
		num1 = (num1==null) ?  22: num1;
		num2 = (num2==null) ?  33: num2;

		model.addAttribute("num1", num1);
		model.addAttribute("num2", num2);
		model.addAttribute("today", testService.selectToday());
		model.addAttribute("sum", testService.selectSum(num1, num2));
		model.addAttribute("mul", testService.selectMul(num1, num2));

		TestVO testVO = new TestVO();
		testVO.setNum1(num1);
		testVO.setNum2(num2);
		model.addAttribute("vo", testService.selectVO(testVO));
		
		return "test";
	}
	
	@Autowired
	private JavaMailSender mailSender;
	
	@RequestMapping(value = "/testMail")
	public String sendMail() {
		// 메일 보내기 준비하는 객체
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage) throws Exception {
				mimeMessage.setFrom("oss7140@naver.com");// 보내는 사람 아이디
				mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress("oss7140@naver.com"));// 받는 사람 아이디
				mimeMessage.setText("메일 내용입니다."); // 내용
				mimeMessage.setSubject("제목이란다."); // 제목
			}
		};
		try {
            mailSender.send(preparator);
            System.out.println("메일을 성공적으로 보냈습니다.");
        } catch (MailException ex) {
            System.err.println(ex.getMessage());
        }
        return "home";
	}
}
