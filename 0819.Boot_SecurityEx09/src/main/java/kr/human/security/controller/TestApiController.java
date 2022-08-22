package kr.human.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.human.security.service.TestService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api")
public class TestApiController {
	
	@Autowired
	private TestService testService;
	
	@RequestMapping(value = "/today")
	public String today() {
		return testService.today();
	}
}
