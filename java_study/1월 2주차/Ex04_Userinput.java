package day02;

import java.util.Scanner;

import Utils.MyUtil;

public class Ex04_Userinput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 1. 실행 시 입력하기
		System.out.println("작업일자 파라미터 = " + args[0]);
		
		//2. Scanner 사용하기
		Scanner sc = new Scanner(System.in);
		
		MyUtil u = new MyUtil();
		u.p("이름을 입력하세요. : ");
		String name = sc.next();
		u.p("당신의 이름은 " + name + "입니다.");
		
		u.p(name+ "님, 점수를 입력하세요. : ");
		float score = sc.nextFloat();
		String str = (score > 60) ? "합격입니다." : "불합격입니다.";
		u.p("뭐? " + score + "점? " + str);
		
	}

}
