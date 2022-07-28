package kr.human.security04.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.human.security04.service.EmployeeService;
import kr.human.security04.vo.EmployeeVO;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@RequestMapping(value = "/")
	public String home() {
		// PasswordEncoder encoder = new BCryptPasswordEncoder();
		// jdbcTemplate.update("insert into users values ('user',?,true)", encoder.encode("123456"));
		// jdbcTemplate.update("insert into users values ('admin',?,true)", encoder.encode("123456"));
		// jdbcTemplate.update("update users set password=? where username='admin'", encoder.encode("123456"));
		// jdbcTemplate.update("update users set password=? where username='user'", encoder.encode("123456"));
		return "home";
	}
	
	@RequestMapping(value = {"/welcome"})
	public ModelAndView firstPage() {
		return new ModelAndView("welcome");
	}

	@RequestMapping(value = "/addNewEmployee", method = RequestMethod.GET)
	public ModelAndView show() {
		return new ModelAndView("addEmployee", "emp", new EmployeeVO());
	}

	@RequestMapping(value = "/addNewEmployee", method = RequestMethod.POST)
	public ModelAndView processRequest(@ModelAttribute("emp") EmployeeVO emp) {

		employeeService.insertEmployee(emp);
		List<EmployeeVO> employees = employeeService.getAllEmployees();
		ModelAndView model = new ModelAndView("getEmployees");
		model.addObject("employees", employees);
		return model;
	}

	@RequestMapping("/getEmployees")
	public ModelAndView getEmployees() {
		List<EmployeeVO> employees = employeeService.getAllEmployees();
		ModelAndView model = new ModelAndView("getEmployees");
		model.addObject("employees", employees);
		return model;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("errorMsg", "Your username and password are invalid.");

		if (logout != null)
			model.addAttribute("msg", "You have been logged out successfully.");

		return "login";
	}

}