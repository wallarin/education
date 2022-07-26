package com.test.java.question.method;

public class Q02 {
	
	public static void main(String[] args) {
		
		/*
		요구사항] 이름을 전달하면 이름뒤에 '님'을 붙여서 반환하는 메소드를 선언하시오.

		조건..
		String getName(String name)
		name: OOO(이름)
		return: OOO(이름)님
		
		호출..
		result = getName("홍길동");
		System.out.printf("고객: %s\n", result);

		result = getName("아무개");
		System.out.printf("고객: %s\n", result);
		출력..
		고객: 홍길동님
		고객: 아무개님
		
		-- 프로세스
		1.String 값을 입력받는 getName 메소드를 생성
		2.String 변수에 입력받는 "이름" + 님을 붙인 후 값이 리턴되도록 만든다
		2.main 메소드에서 getName 메소드를 호출해 String result에 대입한 뒤 출력한다.
		*/
		
		String result = getName("홍길동");
		System.out.printf("고객: %s\n", result);
		
		result = getName("아무개");
		System.out.printf("고객: %s\n", result);
		
	}
	
	public static String getName(String name) {
		
		String result = name + "님";
		
		return result;
		
	}

}
