package day03;

import java.util.Random;

import Utils.MyUtil;

public class Ex10_Color {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyUtil u = new MyUtil();
		
		u.p("Color Test");
		u.p(u.BLACK + u.UNDERLINE+ "Color Test" + u.END);
		u.p(u.RED + "Color Test" + u.END);
		u.p(u.GREEN + "Color Test" + u.END);
		u.p(u.MAGENTA+ u.ITALIC+ u.DOUBLEUNDERLINE+ "Color Test" + u.END);
		u.p(u.YELLOW + "Color Test" + u.END);
		
		
		
		// Q. AA라는 글자를 8색으로 나타내시오.
		// 단, for문으로 구현할 것.
		// print 사용
		// AAAAAAAAAAAAAAAA
	
		for(int i=30; i<38; i++) {
			System.out.print("\033[" + i + "mAA" + u.END);
		}
		System.out.println();
		for(int i=90; i<98; i++) {
			System.out.print("\033[" + i + "mAA" + u.END);	
		}	
		System.out.println();
		for(int i=40; i<48; i++) {
			System.out.print("\033[" + i + "m  " + u.END);	
		}
		System.out.println();
		for(int i=100; i<108; i++) {
			System.out.print("\033[" + i + "m  " + u.END);	
		}
		System.out.println();
		
		
		// 확장 256색
		for(int i = 0; i<255; i++) {
			System.out.print("\033[48;5;" + i + "m  " + u.END);
		}
		System.out.println();
		for(int i = 0; i<255; i++) {
			System.out.print("\033[38;5;" + i + "m♥" + u.END);
		}
		
		System.out.println();
	
		
		//True Color
		Random rd = new Random();
		for(int i = 0; i<256; i++) {
			int r = rd.nextInt(255);
			int g = rd.nextInt(255);
			int b = rd.nextInt(255);
			
			// g = r; b = r; 흑백컬러로 나옴
			
			String str = r + ";" + g + ";" + b;
			System.out.printf("\033[48;2;" + str +"m  "+ u.END);	
			
			if(i%32==31) {
				System.out.println();
			}
		}
	}
		
}
	



