package kr.human.email;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MailController {

	@Autowired
	private JavaMailSender javaMailSender;
	
	@RequestMapping(value = {"/","/index","/home"})
	public String home(Model model) {
		MailHandler mailHandler=null;
		try {
			mailHandler = new MailHandler(javaMailSender);
			mailHandler.setFrom("네이버계정@naver.com", "보내는사람이름");
			mailHandler.setTo("ithuman202204@gmail.com"); // 받는사람
			mailHandler.setSubject("메일이 갈까요?"); // 제목
			mailHandler.setText("<h1>하하하하하 정말 갈까?</h1>"); // 내용
			mailHandler.send(); // 메일 보내기
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		LocalDateTime today = LocalDateTime.now();
		String todayStr =  today.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일(E) HH:mm:ss"));
		model.addAttribute("today", todayStr);
		log.info(String.format("서버시간 : %s", todayStr));
		
		return "home";
	}
}
