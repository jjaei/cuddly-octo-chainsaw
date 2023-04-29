package com.it.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.it.example.beans.vo.BoardVO;
import com.it.example.services.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board/*")
@Slf4j
public class BoardController {
	private final BoardService service;
	
	@GetMapping("list")
	public void list(Model model) {
		log.info("----------------------------");
		log.info("[list()] ");
		log.info("----------------------------");
		model.addAttribute("list", service.getList());
	}
	
	@PostMapping("register")
	public RedirectView register(BoardVO board, RedirectAttributes rttr) {
		log.info("----------------------------------------");
		log.info("[BoardController] register : "  + board);
		log.info("----------------------------------------");

		service.register(board);
		// 새롭게 등록된 번호를 같이 전달하기 위해 RedirectAttributes를 이용한다.
		rttr.addFlashAttribute("bno",board.getBno());
		
		// RedirectView를 사용하면 redirect 방식으로 전송이 가능하다.
		return new RedirectView("list");
	}
}
