package com.it.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.it.example.beans.vo.ExampleVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/ex/*")
@Slf4j
public class ExampleController {
	
	@RequestMapping(value="/example", method= {RequestMethod.GET, RequestMethod.POST})
	public void example01() {
		log.info("example01 get or post");
	}
	
	@RequestMapping("")
	public void example02() {
		log.info("example02 get or post");
	}
	
	@GetMapping("")
	public void example03() {
		log.info("example03 only get");
	}
	
	@GetMapping("/ex04")
	public String example04(@ModelAttribute("vo") ExampleVO vo) {
		log.info("------------------------------");
		log.info(vo.toString());
		log.info("------------------------------");
		vo.setName("Jam");
		vo.setAge(10);
		return "example04";
	}
}
