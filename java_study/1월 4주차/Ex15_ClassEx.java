package day04;

import java.util.Random;

public class Ex15_ClassEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Department d1 = new Department("강남점");
		Department d2 = new Department("본점");
		
		d1.setOpen(true);
		d1.setPranOpen(true);
		
		d2.setOpen(false);
		d2.setPranOpen(false); // static
		
		System.out.println(d1.name + " open? " + (d1.getOpenStatus() ? "YES" : "NO"));
		System.out.println(d2.name + " open? " + (d2.getOpenStatus() ? "YES" : "NO"));
		// d2가 static 변수인 pran_open_ind를 false로 바꿨기 때문에
		// 전체 지점이 문을 닫은 것으로 나옴.
	
		Random rd = new Random();
		int today_amt;
		
		for(int i = 0; i<5; i++) {
			// 임의의 금액을 얻은 후 -> 1000단위 절사
			today_amt = rd.nextInt(100_000_000)/1000 * 1000;
			d1.addAmt(today_amt);
			today_amt = rd.nextInt(100_000_000)/1000 * 1000;
			d2.addAmt(today_amt);
		}
		
		// 더 매출이 높은 지점의 이름과 금액을 출력하시오.
		
		if(d1.getAmt() > d2.getAmt()) 
			System.out.println("Name : " + d1.name + "  Amt : " + d1.getAmt());
		else
			System.out.println("Name : " + d2.name + "  Amt : " + d2.getAmt());
		} 
		
	}


class Department {
	// 1. name : 지점의 이름, 생성할 때 지정 가능
	// 2. pran_name : 브랜드 이름, 수정 불가능, 최초에 SSG로 셋팅
	// 3. amt : 지점의 매출액, 초기값은 0, "직접" 수정 불가능
	// 4. open_ind : 현재 지점의 오픈 가능 상태(true, false)
	// 5. pran_open_ind : 전체 백화점의 오픈 가능 상태(true, false)
	
	// Step 1. Field 5개 정의
	String name;
	static final String pran_name = "SSG";
	private int amt = 0;
	private boolean open_ind;
	private static boolean pran_open_ind;
	
	// Step 2. Constructor 정의
	
	Department() {
		name = "미정";
	}
	
	Department(String name) {
		this.name = name;
	}
	
	// Step 3. Getter, Setter
	public void setOpen(boolean status) {
		this.open_ind = status;
	}
	
	public static void setPranOpen(boolean status) {
		pran_open_ind = status;
	}
	
	public int getAmt() {
		return amt;
	}
	
	// Step 4. Method
	// amt를 더하는 method
	
	public void addAmt(int amt) {
		this.amt += amt; 
	}
	
	// 지점의 최종 오픈 가능 상태를 돌려주는 method
	
	public boolean getOpenStatus() {
		//pran_open_ind가 true이고, open_ind가 true이면 true
		//그 외에는 false
	
		if(pran_open_ind  && open_ind) 
			return true;
			else 
			return false;
			
	}
}