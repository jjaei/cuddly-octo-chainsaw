package day02;

public class Ex03_Operator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		p("Operation Example");
		
		// 1. 대입연산
		int num = 10;
		p("1. num = " + num);
		p(num);
		
		// 2. 대입연산2
		num += 10;
		p("2-1. num = " +num);
		num -= 10;
		p("2-2. num = " +num);
		
		// 3. 산술연산
		num = 5 + 5 * 2;
		p("3-1. num = " +num);
		num = 5 * ( 5 + 2 );
		p("3-2. num = " +num);
		
		// 4. 산술연산2
		int num_of_grp = 3;
		num = 35 % num_of_grp;
		p("4. 현재 데이터는 " + num + "그룹");
		
		// 5. 산술연산3
		float numf = 10f / 4;
		p("5-1. numf = " +numf);
		double numd = 10 / 4f; // float보다 double이 크므로 Casting 없이 저장됨.
		num = (int)numd;
		p("5-2. num(Casting) = " + num);
		
		// 6. 0으로 나누기
		//num = 10 / 0; → 현재는 예외발생, 추후 예외처리를 통해 처리 가능
		
		// 7. 증감연산
		int a = 10, b = 10;
		p("7-1. a = " + a + ", b = " + b);
		a++; // a = a + 1, a += 1과 동일
		++b;
		p("7-2. a = " + a + ", b = " + b);
		
		int x = a++; // → int x = a; a++;이 더 좋은 코딩 , a를 x에 대입 후 증가
		int y = ++b; // b 증가 후 y에 대입
		p("7-3. x = " + x + ", y = " + y);
		
		// 8. 비교연산
		a = 10; b = 5;
		p("8-1. a == b : " + (a==b));
		int c = 7;
		//boolean result = (a > b > c); // 에러 → (a > b) && (b > c);
		
		// 9. 논리연산
		p("9-1. true && false => " + (true && false)); // AND
		p("9-2. true || false => " + (true || false)); // OR
		p("9-3. true ^ true => " + (true ^ true)); // XOR
		p("9-4. !true => " + !true); // not true
	
		// 10. 삼항연산 A ? B : C
		int score = 80;
		String dad1 = (score > 60) ? "잘했어" : "분노@#$#$";
		String dad2 = (score > 99) ? "잘했어" : "분노@#$#$";
		String host1 = (score > 30) ? "간식" : "돌아가";
		
		p("10-1. dad1 = " + dad1);
		p("10-2. dad2 = " + dad2);
		p("10-3. host1 = " + host1);
	
	}
	
	public static void p(String str) {
		System.out.println(str); // System.out.println 메서드를 계속 적지 않아도 p로 불러올 수 있음.
	}
	
	public static void p(int num) {
		System.out.println(num); // 이름이 같아도 중복설정 가능. → 다형성
		
	}
}
