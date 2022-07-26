package com.test.java.question.overloading;

public class Q02 {

	public static void main(String[] args) {

		/*
		요구사항] 인자로 받은 이름들을 직급 순으로 출력하는 메소드를 선언하시오.
		
		조건..
		사원 → 대리 → 과장 → 부장
		void position(String)
		void position(String, String)
		void position(String, String, String)
		void position(String, String, String, String)
		호출..
		position("홍길동");
		position("홍길동", "유재석");
		position("홍길동", "유재석", "박명수");
		position("홍길동", "유재석", "박명수", "정형돈");
		출력..
		사원 : 홍길동
		         
		사원 : 홍길동
		대리 : 유재석
		
		사원 : 홍길동
		대리 : 유재석
		과장 : 박명수
		
		사원 : 홍길동
		대리 : 유재석
		과장 : 박명수
		부장 : 정형돈
		*/

		position("홍길동");
		position("홍길동", "유재석");
		position("홍길동", "유재석", "박명수");
		position("홍길동", "유재석", "박명수", "정형돈");
	}

	public static void position(String string) {

		System.out.printf("사원 : %s\n\n", string);

	}

	public static void position(String string, String string2) {
		System.out.printf("사원 : %s\n"
						+ "대리 : %s\n\n", string, string2);
	}

	public static void position(String string, String string2, String string3) {
		System.out.printf("사원 : %s\n"
						+ "대리 : %s\n"
						+ "과장 : %s\n\n", string, string2, string3);
	}

	public static void position(String string, String string2, String string3, String string4) {
		System.out.printf("사원 : %s\n"
						+ "대리 : %s\n"
						+ "과장 : %s\n"
						+ "부장 : %s\n\n", string, string2, string3,
				string4);
	}

}
