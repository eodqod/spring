package kr.human.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@GetMapping(value = {"/","/hello","/hi.it"})
	public String hello() {
		return "반갑다 스프링 부트!!!!";
	}
}
