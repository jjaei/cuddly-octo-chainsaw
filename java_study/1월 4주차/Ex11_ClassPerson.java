package day04;

public class Ex11_ClassPerson {

	// Field
	public int age;
	String name;
	
	// Method
	public static void hit() {
		System.out.println("주인님 좀 때려도 되겠습니까?");
	}
	
	public void eat() {
		System.out.println("저 " + name + "은 소갈비 1.4kg을 먹고 있습니다.");
	}
	
	// Constructor
	
	Ex11_ClassPerson() {
		System.out.println("Person Created");
	}
	
	Ex11_ClassPerson(String n){
		name = n;
		System.out.println("Person [" + name + "] Created");
	}
}
