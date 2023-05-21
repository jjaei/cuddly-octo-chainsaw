package com.it.example.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnailator;

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
		
		String uploadFolder = "C:/upload";
		
		// 1번 문제점 해결을 위해 /yyyy/mm/dd 경로를 생성
		File uploadPath = new File(uploadFolder, getFolder());
		log.info("upload path : " + uploadPath);
		if(!uploadPath.exists()) {
			uploadPath.mkdirs();
		}
		
			for(MultipartFile f : uploadFile) {
				// 받아온 f로 할 일
				log.info("file received ---------------------");
				log.info("File Name : " + f.getOriginalFilename());
				log.info("File Size : " + f.getSize());
				
				String uploadFileName = f.getOriginalFilename();
				
				// UUID 적용
				UUID uuid = UUID.randomUUID();
				// 파일 이름으로 조회 시에는 _를 기준으로 뒤의 문자열로 조회 가능
				uploadFileName = uuid.toString() + "_" + uploadFileName;
				log.info("file name(modified+uuid) : " + uploadFileName);
				
				// File Creation(Empty)
				File saveFile = new File(uploadPath, f.getOriginalFilename());
				
				// Contents Copy
				try {
					// 파일 업로드 transferTo() 사용
					f.transferTo(saveFile);
					if(checkImageType(saveFile)) {  // 파일이 이미지라면
						FileOutputStream tn = new FileOutputStream(new File(uploadPath, "s_" + uploadFileName));
						// inputstream을 통해 파일을 생성하고 가로, 세로 크기를 지정해준다.
						// 새로운 작은 파일은 s_ 가 해당 경로에 생성된다.
						Thumbnailator.createThumbnail(f.getInputStream(), tn, 100, 100);
						tn.close();
					} else {
						
					}
				} catch(Exception e) {
					log.error(e.getMessage());
				}
			}
		
		return "/upload/result";  // 임시 리턴 페이지
	}
	
	private String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String str = sdf.format(date);
		
		// 보통 2023-05-21 디렉토리보다는 2023/5/21로 생성
		
		return str.replace("-","/");
	}
	
	private boolean checkImageType(File file) {
		try {
			String contentType = Files.probeContentType(file.toPath());
			log.info(contentType);  // text/plain  , image/jpeg ... 
			return contentType.startsWith("image");	
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
