package kr.human.mvc03.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.human.mvc03.vo.TestVO;

@Controller
public class UserController {

	// /receive1?name=jun&age=13
	@GetMapping(value = "/receive1", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String receive1(@RequestParam String name) {
		System.out.println("통신 성공");
		System.out.println(">>> " + name);
		return ">>> " + name;
	}
	
	@GetMapping(value = "/receive2", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String receive2(@RequestBody String req) {
		System.out.println("통신 성공");
		System.out.println(">>> " + req);
		return ">>> " + req;
	}
	
	@RequestMapping(value = "/form3")
	public String receive3() {
		return "form3";
	}
	
	@PostMapping(value = "/receive3", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String receive3(@RequestParam TestVO testVO) {
		System.out.println("통신 성공");
		System.out.println(">>> " + testVO);
		return ">>> " + testVO;
	}
	
	@PostMapping(value = "/receive4", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String receive4(@RequestBody TestVO testVO) {
		System.out.println("통신 성공");
		System.out.println(">>> " + testVO);
		return ">>> " + testVO;
	}
	
	@PostMapping(value = "/receive5", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String receive5(@RequestBody Map<String,String> map) {
		System.out.println("통신 성공");
		System.out.println(">>> " + map.get("name"));
		System.out.println(">>> " + map.get("age"));
		return ">>> " + map + "\n" + map.get("name") + "\n" + map.get("age");
	}
	
	
}
