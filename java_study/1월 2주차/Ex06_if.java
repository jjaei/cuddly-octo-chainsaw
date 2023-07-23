package day02;

import java.util.Random;

import Utils.MyUtil;

public class Ex06_if {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		MyUtil u = new MyUtil();
		u.p("If Example");
		
		int a = 1000;
		
		if(a > 100) {
			u.p("매우 큰 수");
		}
		else if(a > 0) {
			u.p("양수");
		}
		else if(a == 0) {
			u.p("Zero");
		}
		else {
			u.p("음수");
		}
		
		// nested
		
		// 영어와 수학 점수 모두 60점 이상이면 Pass, 아니면 Fail
		
		Random rd = new Random();
		int eng = rd.nextInt(101);
		int math = rd.nextInt(101);
		
		
		// 1. 
		if(eng >= 60) {
			if(math >= 60) {
				u.p("Success! Pass OK");
			}
			else {
				u.p("수학 : " + math + "점 -> Fail");
			}
		}
		else {
			u.p("영어 : " + eng + "점 -> Fail");
		}
		
		// 2. 
		if(eng >= 60) 
			if(math >= 60) 
				u.p("Success! Pass OK");
			
			else 
				u.p("수학 : " + math + "점 -> Fail");
		else 
			u.p("영어 : " + eng + "점 -> Fail");
	
		// 3.
		
		if(eng >= 60 && math >= 60) u.p("Success! Pass OK");
		else if (eng < 60) u.p("영어 : " + eng + "점 -> Fail"); 
		else u.p("수학 : " + math + "점 -> Fail");
		
	}

}
