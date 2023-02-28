package day03;

import Utils.MyUtil;

public class Ex09_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyUtil u = new MyUtil();
		
		u.p("Array Test");
		
		String[] str;
		str = new String[5];
		
		str[0] = "AAA";
	
		String[] student1 = new String[5];
		String[] student2 = {"A", "B", "C", "D", "E"};
		int[] score1 = new int[5];
		int[] score2 = {10, 20, 10, 20, 30};
		
		
		
		// 모든 학생들의 이름과 점수를 출력하시오.
		// Student[학생이름] : **점
		// for문 사용
		
		for(int i=0; i < student2.length; i++) {
			u.p("Student[" + student2[i]+ "] : " + score2[i] + "점");
		}
		
		String[][] school = {{"A", "B"},{"C", "D"}};
		u.p(school[0][0]); // A 학생
		u.p(school[1][0]); // C학생
		
		// String[][][] : 지역 + 학교 + 반 → 3차원 배열도 가능은 하나 잘 사용하지 않음.
		
		// Enhanced for 배열을 위한 for문
		for(String name : student2) {
			u.p("[Enhanced For] " + name);
		}
		
		// Enhanced for를 이용하여 school의 모든 학생의 이름을 출력하시오.
		for(String[] sclass : school) {
			for(String sname : sclass) {
				u.p("[Enhanced For2] " + sname);
			}
		}
	
		for(int i=0; i<2; i++) {
			for(int j=0; j<2; j++) {
				u.p("[Normal For]" + school[i][j]);
			}
		}
		
	}

}
