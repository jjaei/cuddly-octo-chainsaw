package com.it.example.controllers;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.it.example.beans.vo.TaskVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/ex/*")
@Slf4j
public class TaskController {
	
	@GetMapping("/ex05")
	public String example05(@ModelAttribute("task") TaskVO vo) {
		Random rd = new Random();
		vo.setKor(rd.nextInt(100));
		vo.setEng(rd.nextInt(100));
		vo.setMath(rd.nextInt(100));
		return "example05";
	}
}
