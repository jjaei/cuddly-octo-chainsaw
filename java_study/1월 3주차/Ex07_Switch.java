package day03;

import java.util.Random;

import Utils.MyUtil;

public class Ex07_Switch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyUtil u = new MyUtil();
		
		u.p("\033[1mSwitch Test\033[0m"); // 굵은글씨
		u.p("\033[3mSwitch Test\033[0m"); // 기울임체
		u.p("Switch Test");
		
		Random r = new Random();
		int i = r.nextInt(4);
		
		switch(i) {
			case 0 : 
				u.p("0입니다.");
				break;
			case 1 :
				u.p("1입니다.");
				break;
			case 2 : 
				u.p("2입니다.");
				u.p("당첨입니다.");
				break;
			default : 
				u.p("오류발생");
		}
		
//		switch(작업단계) { → break 사용하지 않아도 되는 예시
//			case "시작":
//				시작단계에서 할 일;
//			case "기본완료":
//				기본단계 다음으로 할 일;
//			case "개발완료"
//				출시준비;
//			case "출시준비 완료";
//			
//		}
		
	}

}
