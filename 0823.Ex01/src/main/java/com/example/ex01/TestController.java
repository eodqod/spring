package com.example.ex01;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class TestController {
	
	@RequestMapping(value = {"/"})
	public String home(Model model) {
		LocalDateTime today = LocalDateTime.now();
		String format = today.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
		model.addAttribute("today", format);
		return "index"; 
	}
	@RequestMapping(value = {"/js1"})
	public String js1(Model model) {
		LocalDateTime today = LocalDateTime.now();
		String format = today.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
		model.addAttribute("today", format);
		return "jstest1"; 
	}
	@RequestMapping(value = {"/js2"})
	public String js2(Model model) {
		LocalDateTime today = LocalDateTime.now();
		String format = today.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
		model.addAttribute("today", format);
		return "jstest2"; 
	}
	
	@RequestMapping(value = {"/result1"})
	public String result1(@RequestParam(required = false) String keyword,@RequestParam(required = false) String name, Model model) {
		log.info("result1--1 : [{}],[{}]", keyword, name); 
		log.info("result1--2 : {},{}", keyword.getClass().getName(), name.getClass().getName());
		model.addAttribute("keyword", keyword);
		model.addAttribute("name", name);
		log.info("result1--3 : [{}],[{}]", keyword, name); 	
		return "result1"; 
	}
	@RequestMapping(value = {"/result2"})
	public String result2( @RequestParam(required = false) String keyword,
						   @RequestParam(required = false, defaultValue = "1") int p, 
						   @RequestParam(required = false, defaultValue = "10") int s, 
						   @RequestParam(required = false, defaultValue = "10") int b, 
						   @RequestParam(required = false) List<String> theme, 
						   Model model) {
		log.info("result2--1 : [{}],[{}],[{}]", p, s, b); 
		log.info("result2--2 : {},{}", keyword, theme);
		log.info("result2--3 : {},{}", keyword.getClass().getName(), theme.getClass().getName());
		model.addAttribute("keyword", keyword);
		String t = theme.toString();
		t = t.substring(1,t.length()-1);
		model.addAttribute("theme", t);
		model.addAttribute("p", p);
		model.addAttribute("s", s);
		model.addAttribute("b", b);
		return "result2"; 
	}
}
