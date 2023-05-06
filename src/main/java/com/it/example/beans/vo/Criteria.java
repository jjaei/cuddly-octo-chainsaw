package com.it.example.beans.vo;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component   
@Data    // getter, setter 관리
public class Criteria {  // 게시글 검색의 기준
	private int pageNum;   // 현재 몇 번째 페이지인가
	private int amount;  	// 한 페이지에 보여질 게시글의 수
	private int limit;
	private int offset;
	
	public Criteria() {
		this(0, 10);
//		pageNum = 0;
//		amount = 10;
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
		this.limit = pageNum * amount;
		this.offset = (pageNum - 1) * amount;
	}
}
