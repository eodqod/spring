package kr.top2blue.security.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;

import kr.top2blue.security.service.EmployeeService;
import kr.top2blue.security.vo.Employee;

@Controller
public class HomeController {

	//@Autowired
	//private JdbcTemplate jdbcTemplate;
	
	@RequestMapping(value = {"/","/index","/home"})
	public String home(Model model) {
		LocalDateTime today = LocalDateTime.now();
		//PasswordEncoder encoder = new BCryptPasswordEncoder();
		//jdbcTemplate.update("update users set password=? where username='admin'", encoder.encode("123456"));
		//jdbcTemplate.update("update users set password=? where username='user'", encoder.encode("123456"));
		model.addAttribute("today", today.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
		return "index";
	}

	// 추가!!!!
	@Bean
	public SpringSecurityDialect securityDialect(){
		return new SpringSecurityDialect();
	}
	
	@Autowired
	EmployeeService employeeService;

	@RequestMapping("/welcome")
	public ModelAndView firstPage() {
		return new ModelAndView("welcome");
	}

	@RequestMapping(value = "/addNewEmployee", method = RequestMethod.GET)
	public ModelAndView show() {
		return new ModelAndView("addEmployee", "emp", new Employee());
	}

	@RequestMapping(value = "/addNewEmployee", method = RequestMethod.POST)
	public ModelAndView processRequest(@ModelAttribute("emp") Employee emp) {

		employeeService.insertEmployee(emp);
		List<Employee> employees = employeeService.getAllEmployees();
		ModelAndView model = new ModelAndView("getEmployees");
		model.addObject("employees", employees);
		return model;
	}

	@RequestMapping("/getEmployees")
	public ModelAndView getEmployees() {
		List<Employee> employees = employeeService.getAllEmployees();
		ModelAndView model = new ModelAndView("getEmployees");
		model.addObject("employees", employees);
		return model;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@RequestParam(required = false) String error, @RequestParam(required = false) String logout, Model model ) {
		if(error!=null) model.addAttribute("error","error");
		if(logout!=null) model.addAttribute("logout","logout");
		return "login";
	}
	
	@GetMapping(value = {"/accessDenied"})
	public String accessDenied() {
		return "accessDenied";
	}

	// 첫번째 오류: 0으로 나눴으므로 500 오류를 발생시킨다.
	@GetMapping("/div")
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
