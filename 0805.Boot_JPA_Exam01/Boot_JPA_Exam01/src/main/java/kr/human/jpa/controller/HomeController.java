package kr.human.jpa.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {
	@RequestMapping(value = { "/", "/index" })
	public String index(Model model) {
		LocalDateTime today = LocalDateTime.now();
		String todayStr =  today.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일(E) HH:mm:ss"));
		model.addAttribute("today", todayStr);
		log.info(String.format("서버시간 : %s", todayStr));
		return "index";
	}
	
	@RequestMapping(value = { "/select" })
	public String select(Model model) {
		LocalDateTime today = LocalDateTime.now();
		String todayStr =  today.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일(E) HH:mm:ss"));
		model.addAttribute("today", todayStr);
		log.info(String.format("서버시간 : %s", todayStr));
		return "select";
	}
	@RequestMapping(value = { "/select2" })
	public String select2(Model model) {
		LocalDateTime today = LocalDateTime.now();
		String todayStr =  today.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일(E) HH:mm:ss"));
		model.addAttribute("today", todayStr);
		log.info(String.format("서버시간 : %s", todayStr));
		return "select2";
	}
}
