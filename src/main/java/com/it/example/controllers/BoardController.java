package com.it.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.it.example.beans.vo.BoardVO;
import com.it.example.beans.vo.Criteria;
import com.it.example.beans.vo.PageDTO;
import com.it.example.services.BoardService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board/*")
@Slf4j
public class BoardController {
	private final BoardService service;
	
	@GetMapping("list")
	public void list(Criteria cri, Model model) {
		log.info("----------------------------");
		log.info("[BoardController] list() : ");
		log.info("----------------------------");
		if(cri == null) {
			model.addAttribute("list", service.getList(new Criteria(1, 10)));
		} else {
			model.addAttribute("list", service.getList(cri));
		}
		
		model.addAttribute("pageMaker", new PageDTO(cri, 123));
	
//	public void list(Model model) {
//		log.info("----------------------------");
//		log.info("[BoardController] list() : ");
//		log.info("----------------------------");
//		model.addAttribute("list", service.getList());
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
	
	@GetMapping("register")
	public void register() {
		
	}
	
	@GetMapping({"get", "get2"})
	public void get(@RequestParam("bno") Long bno, HttpServletRequest request, Model model) {
		String reqURI = request.getRequestURI();
		String reqContextPath = request.getContextPath();
		String reqType = reqURI.substring(reqURI.indexOf(reqContextPath) + 7);
		log.info("----------------------------------------");
		log.info("[BoardController] get : "  + reqURI);
		log.info("[BoardController] get : "  + reqContextPath);
		log.info("[BoardController] get : "  + reqType);
		log.info("[BoardController] get : "  + bno);
		log.info("----------------------------------------");
		
		model.addAttribute("board", service.get(bno));
	}
	
	@PostMapping("modify")
	public RedirectView modify(BoardVO board, RedirectAttributes rttr) {
		log.info("----------------------------------------");
		log.info("[BoardController] modify : "  + board);
		log.info("----------------------------------------");
		if(service.modify(board) ){
			//addAttribute()는 get 방식으로 QueryString에 전달
			rttr.addFlashAttribute("result", "success");
		} else {
			rttr.addFlashAttribute("result", "failure");
		}
		
		return new RedirectView("list");
	}
	
	@GetMapping("modify")
	public void modify(@RequestParam("bno")  Long bno, Model model) {
		log.info("--------------------------------");
		log.info("[Modify] " + bno);
		log.info("--------------------------------");
		model.addAttribute("board", service.get(bno));
	}
	
	@PostMapping("remove")
	// 변수명이 같은 경우 @RequestParam를 쓸 필요는 없으나 
	// 명시적으로 지정할 경우 유지보수 중 파라미터 추가 시 발생할 수 있는 예외를 막아준다.
	public RedirectView remove(@RequestParam("bno") Long bno, RedirectAttributes rttr)  {
		log.info("----------------------------------------");
		log.info("[BoardController] modify : "  + bno);
		log.info("----------------------------------------");
		
		if(service.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		} else {
			rttr.addFlashAttribute("result", "failure");
		}
		
		return new RedirectView("list");
	}
	
	@GetMapping("error")
	public void error() throws Exception {
		log.info("----------------------------");
		log.info("[error()] ");
		log.info("----------------------------");
		throw new Exception("지울 자격도 없다.");
	}
}
