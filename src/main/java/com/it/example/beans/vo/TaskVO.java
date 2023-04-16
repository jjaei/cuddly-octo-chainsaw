package com.it.example.beans.vo;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class TaskVO {
	private int kor;
	private int eng;
	private int math;
}
