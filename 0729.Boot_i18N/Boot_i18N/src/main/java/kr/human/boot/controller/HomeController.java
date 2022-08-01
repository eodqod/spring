package kr.human.boot.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Controller
public class HomeController {

	@RequestMapping(value = {"/"})
	public String home(Model model) {
		LocalDateTime today = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일(E) hh:mm:ss");
		model.addAttribute("today", today.format(formatter));
		return "index";
	}
	
	@GetMapping("/test")
    public String test() {
        return "test";
    }
}
