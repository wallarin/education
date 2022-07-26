package com.test.java.question.method;

public class Q01 {
	
	public static void main(String[] args) {
		
		/*
		요구사항] 인삿말을 출력하는 메소드 3개를 선언하시오.

		조건..
		void hello()
		void introduce()
		void bye()
		
		호출..
		hello();
		introduce();            
		bye();
		
		출력..
		안녕하세요.
		저는 홍길동입니다.
		안녕히가세요.
		
		-- 프로세스
		1.조건 메소드를 main메소드 바깥에 hello, introduce, bye 총 3개 생성한다.
		2.hello 메소드 안에 "안녕하세요"라는 값 출력라인 생성.
		3.introduce 메소드 안에 "저는 홍길동입니다."의 값 출력라인 생성.
		3.bye 메소드 안에 "안녕히가세요."값 출력라인 생성.
		4.생성한 메소드를 요구사항의 값 순서대로 메소드 출력
		*/
		
		hello();
		introduce();
		bye();
		
	}
	
	public static void hello() {
		
		System.out.println("안녕하세요.");
		
	}
	
	public static void introduce() {
		
		System.out.println("저는 홍길동입니다.");
		
	}
	
	public static void bye() {
		
		System.out.println("안녕히가세요.");
		
	}
	
}
