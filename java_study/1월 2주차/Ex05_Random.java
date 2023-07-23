package day02;

import java.util.Random;

import Utils.MyUtil;

public class Ex05_Random {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//실습
		MyUtil u = new MyUtil();
		u.p("Random Example");
		
		Random rd = new Random();
		
		// Random Number
		u.p("" + rd.nextInt()); // "String" + rd.nextInt = String
		u.p("" + (rd.nextInt(100)+1));
		u.p("" + rd.nextFloat());
		u.p("" + rd.nextDouble());
		
		// Random Alphabet
		// 생각해볼 것, 'A' 0x41 65
		char random_char = (char)(rd.nextInt(26) + 65);
		u.p("Random Alphabet 1 : " + random_char);
		
		// 대소문자 중 Random Alphabet
		// 생각해볼 것, 'A' 65, 'a' 97
		// 26자 중 하나 선택 + 32 * (1 or 0)
		char random_char2 = (char)(rd.nextInt(26) + 65 + rd.nextInt(2)*32);
		u.p("Random Alphabet 2 : " + random_char2);
		
		
	}

}
