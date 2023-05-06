package com.it.example.beans.vo;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Component
@Data
@Slf4j
public class PageDTO {
	private int startPage;
	private int endPage;
	private int realEnd;
	private boolean prev, next;
	
	private int total;
	private Criteria criteria;
	
	public PageDTO() {}
	
	public PageDTO(Criteria cri, int total) {
		this.criteria = cri;
		this.total = total;
		
		endPage =cri.getPageNum();
		startPage = endPage - 9;
		
		realEnd = (int)(Math.ceil((total * 1.0)  / cri.getAmount()));
		log.info("-----------------endPage :  "  + endPage); 
		log.info("-----------------realEnd :  "  + realEnd); 
		
		if(realEnd < this.endPage) {
			endPage = (realEnd == 0 ? 1 : realEnd);
		}
		
		prev = startPage > 1;
		next = endPage < realEnd;
	}
}
