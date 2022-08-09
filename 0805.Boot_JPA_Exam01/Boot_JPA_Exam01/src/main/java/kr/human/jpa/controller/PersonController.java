package kr.human.jpa.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.human.jpa.service.PersonService;
import kr.human.jpa.vo.Person;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class PersonController {
	@Autowired
	private PersonService personService;

	@GetMapping(value = "/list")
	public String list(@RequestParam(required = false, defaultValue = "desc") String sort, Model model) {
		List<Person> list = personService.selectList(sort);
		model.addAttribute("list", list);
		model.addAttribute("totalCount", personService.selectCount());
		return "list";
	}

	@GetMapping(value = "/findAllByIds")
	public String findAllByIds(Model model) {
		List<Person> list = personService.findAllByIds();
		model.addAttribute("list", list);
		model.addAttribute("totalCount", personService.selectCount());
		return "findAllByIds";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insertGet() {
		return "redirect:/";
	}
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insertPost(@ModelAttribute Person person) {
		personService.insert(person);
		return "redirect:/list";
	}
	@RequestMapping(value = "/saveAll")
	public String saveAll() {
		Random rnd = new Random();
		List<Person> list = new ArrayList<>();
		for(int i=0;i<rnd.nextInt(3)+1;i++) {
			list.add(new Person("사람 " + String.format("%03d",rnd.nextInt(100)),rnd.nextInt(100), rnd.nextBoolean(), new Date()));
		}
		log.info("저장 : " + list);
		personService.saveAll(list);
		return "redirect:/list";
	}
	
	@RequestMapping(value = "/deleteAll", method = RequestMethod.GET)
	public String deleteAll() {
		personService.deleteAll();
		return "redirect:/list";
	}
	
	@RequestMapping(value = "/deleteAll2", method = RequestMethod.GET)
	public String deleteAl2l() {
		personService.deleteAll2();
		return "redirect:/list";
	}
	
	@RequestMapping(value = "/deleteByIdx")
	public String deleteById(@RequestParam long idx) {
		personService.deleteByIdx(idx);
		return "redirect:/list";
	}
	
	@RequestMapping(value = "/deleteByObject")
	public String deleteByObject(@RequestParam long idx) {
		personService.deleteByObject(idx);
		return "redirect:/list";
	}

	@RequestMapping(value = "/existById")
	public String existById(Model model) {
		model.addAttribute("msg", personService.existById());
		return "existById";
	}
}
