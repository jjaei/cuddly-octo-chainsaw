package com.it.example.controllers;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/upload/*")
public class UploadContoller {

	@GetMapping("uploadForm")
	public void uploadForm() {
		log.info("-------------------------------upload form");	
	}
	
	@GetMapping("uploadAjax")
	public void uploadAjax() {
		log.info("-------------------------------upload ajax");
	}
	
	@PostMapping("uploadFormAction")
	public String uploadFormPost(MultipartFile[] uploadFile, Model model) {
		String uploadFolder = "C:/upload";
		
		for(MultipartFile f : uploadFile) {
			// 받아온 f로 할 일
			log.info("file received ---------------------");
			log.info("File Name : " + f.getOriginalFilename());
			log.info("File Size : " + f.getSize());
			
			// File Creation(Empty)
			File saveFile = new File(uploadFolder, f.getOriginalFilename());
			
			// Contents Copy
			try {
				// 파일 업로드 transferTo() 사용
				f.transferTo(saveFile);
				
			} catch(Exception e) {
				log.error(e.getMessage());
			}
		}
		return "/upload/result";  // 임시 리턴 페이지
	}
	
	@PostMapping("uploadAjaxAction")
	public String uploadAjaxPost(MultipartFile[] uploadFile, Model model) {
		log.info("upload Ajax post! --------------------------------> ");
		
		return "/upload/result";  // 임시 리턴 페이지
	}
}
