package kr.human.security.controller;

import java.security.Principal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.human.security.service.MemService;
import kr.human.security.service.TestService;
import kr.human.security.vo.MemVO;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HelloController {

	@Autowired
	private TestService testService;
	@Autowired
	private MemService memService;
	
	@RequestMapping(value = {"/","/index","/home"})
	public String home(Principal principal, Model model) {
		LocalDateTime today = LocalDateTime.now();
		model.addAttribute("today", today.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일(E) hh:mm:ss")));
		model.addAttribute("today2", testService.today());

		if(principal!= null) {
			model.addAttribute("userName", principal.getName());
			model.addAttribute("auth", principal);
		}
		return "index";
	}
	//==========================================================================================
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@RequestParam(required = false) String error, @RequestParam(required = false) String logout, Model model ) {
		if(error!=null) model.addAttribute("error","error");
		if(logout!=null) model.addAttribute("logout","logout");
		return "login";
	}
	@RequestMapping(value = "/join")
	public String join() {
		log.info("회원가입폼");
		return "join";
	}
	@RequestMapping(value = "/joinOk")
	public String joinOk(@ModelAttribute MemVO memVO) {
		log.info("회원가입 : {}", memVO);
		memService.insertMem(memVO);
		return "redirect:/";
	}

	@RequestMapping(value = "/admin/page1")
	public String admin1() {
		log.info("관리자페이지 1");
		return "admin";
	}
	@RequestMapping(value = "/admin/page2")
	public String admin2() {
		log.info("관리자페이지 2");
		return "admin";
	}

	@RequestMapping(value = "/user/page1")
	public String user1() {
		log.info("회원페이지 1");
		return "user";
	}
	@RequestMapping(value = "/user/page2")
	public String user2() {
		log.info("회원페이지 2");
		return "user";
	}
	
	//==========================================================================================
	@GetMapping(value = {"/accessDenied"})
	public String accessDenied() {
		return "accessDenied";
	}

	// 첫번째 오류: 0으로 나눴으므로 500 오류를 발생시킨다.
	@GetMapping("/error1")
	public String problem(Model model) {
		int result = 1 / 0;
		model.addAttribute("serverTime", result);
		return "home";
	}

	// 두 번째 오류: @PostMapping이므로 Get 방식으로 요청 시 405 오류를 발생시킨다.
	@PostMapping("/error2")
	public String method(Model model) {
		return "home";
	}
}

