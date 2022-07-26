package com.test.java.obj.constructor;

public class Ex38_Constructor {
	
	public static void main(String[] args) {
		
		//Ex38_Constructor.java
		
		Developer d1 = new Developer();
		d1.info();
		
		Developer d2 = new Developer("홍길동");
		d2.info();
		
		Developer d3 = new Developer("아무개", "Java");
		d3.info();
		
		
		Developer d4 = new Developer("익명");
		d4.info();

		
		
	}//main

}//Ex38


class Developer {
	
	private String name;
	private String language;
	
	//생성자를 여러개 생성(생성자 오버로딩)
	//- 대부분의 생성자가 비슷한 행동을 한다.
	//- 중복 코드 발생!!! > 줄이자!!!
	//- 다른 생성자 호출 형태 코드 개선 > this(); //생성자 호출하는 표현
	
	
	// A < B < C > C만 있어도 A,B를 모두 구현이 가능하다.
	//this. 으로 각각 설정해주면 유효성 검사도 다 각각 해줘야 하지만 C에게 일을 넘기도록 하면 C에서 유효성 검사를 할 수 있다.

	//A.
	public Developer() {
		//this.name = "익명";
		//this.language = "없음";
		
		//C를 호출
		this("익명", "없음");
	}
	
	//B.
	public Developer(String name) {
		//this.name = name;
		//this.language = "없음";

		//C를 호출
		this(name, "없음");
	}
	
	//C.
	public Developer(String name, String language) {
		//이름 유효성 검사
		this.name = name;
		//언어 유효성 검사
		this.language = language;
	}
	
	
	
	public void info() {
		System.out.println("이름: " + this.name);
		System.out.println("언어: " + this.language);
		System.out.println();
	}
	
	
}














