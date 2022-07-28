package kr.human.security05;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	/*
	 * 인증화면이 나오면 
	 * 사용자 : user
	 * 비번   : 콘솔창의 비번을 입력한다.
	 */
	
	@RequestMapping(value = {"/","/index","/home"})
	public String index(Model model) {
		LocalDateTime today = LocalDateTime.now();
		model.addAttribute("today", today.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일(E) hh:mm:ss")));
		return "index";
	}
}
