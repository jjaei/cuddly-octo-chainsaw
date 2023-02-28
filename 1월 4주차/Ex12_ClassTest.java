package day04;

import Utils.MyUtil;

public class Ex12_ClassTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyUtil u = new MyUtil();
		u.p(u.BLUE + "Class Test" + MyUtil.END);
	
		Ex11_ClassPerson person1 = new Ex11_ClassPerson(); // 생성자가 호출됨
		person1.age = 900;
		person1.name = "Adam";
		
		//Ex07_Switch ss = new Ex07_Switch();
		//ss.main(null);
		
		//Ex07_Switch.main(null);
		
		Ex11_ClassPerson person2 = new Ex11_ClassPerson("Poiret");
		person1.eat();
		person2.eat();
		
		person1.hit();
		person2.hit();
		Ex11_ClassPerson.hit();
		
		
		Car car1 = new Car();
		Car car2 = new Car("Black", "Maserati", "Luxury");
		
		MyUtil.BLUE = MyUtil.RED; // final 변수는 수정할 수 없음.
		MyUtil.GREEN = MyUtil.RED;
		MyUtil u2 = new MyUtil();
		u2.p(u2.BLUE + "세계적인 팝 그룹 u2 콘서트" +u2.END); //static은 이후에 생성해도 기존에 있는 것들 외에도 속성이 바뀜 // static 앞에 final 붙이면 안 바뀜
		u2.p(u2.GREEN + "세계적인 팝 그룹 u2 콘서트" +u2.END); 
		
	}

}

class Car {
	String color;
	String name;
	String type;
	
	Car() { //생성자
		color = "미정";
		name = "비밀";
		type = "기본형";
		
		System.out.println("Car() Called");
	}
	
	Car(String color, String name, String type) {
		this.color = color;
		this.name = name;
		this.type = type;
		System.out.println("Car(...) Called");
	}
	
	// Code Block
	static { // 생성자가 호출될 때 한 번만 불림. 객체가 최초로 생성될 때 해야할 일.
		System.out.println("static code block Called");
	}
	
	{ //생성자가 호출될 때마다 불림
		System.out.println("empty code block Called");
	}
}