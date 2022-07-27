package kr.human.security03;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeMvcController {
	
	@RequestMapping(value = {"/","/index","/home"})
	public String home(Principal principal, Model model) {
		if(principal!= null)
			model.addAttribute("userName", principal.getName());
		return "index";
	}
	
	@RequestMapping(value = {"/hello"})
	public String hello(Principal principal, Model model) {
		model.addAttribute("userName",principal.getName());
		return "hello";
	}
	
	@RequestMapping(value = {"/admin"})
	public String admin(Principal principal, Model model) {
		model.addAttribute("userName",principal.getName());
		return "admin";
	}

	@GetMapping(value = {"/login"})
	public String login(@RequestParam(required = false) String error,
						@RequestParam(required = false) String logout,
						Model model ) {
		if(error!=null) model.addAttribute("error","error");
		if(logout!=null) model.addAttribute("logout","logout");
		return "login";
	}

	@GetMapping(value = {"/accessDenied"})
	public String accessDenied() {
		return "accessDenied";
	}
	/*
	@GetMapping(value = {"/error"})
	public String error() {
		return "errors/error";
	}
	*/
	// 첫번째 오류: 0으로 나눴으므로 500 오류를 발생시킨다.
	@GetMapping("/divide")
	public String problem(Model model) {
		int result = 1 / 0;
		model.addAttribute("serverTime", result);
		return "home";
	}

	// 두 번째 오류: @PostMapping이므로 Get 방식으로 요청 시 405 오류를 발생시킨다.
	@PostMapping("/method")
	public String method(Model model) {
		return "home";
	}
	
}
