package com.test.java.question.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q02 {
	
	public static void main(String[] args) throws Exception {
		
		/*
		
			1. 이메일을 입력 받는다.
			2. 입력받은 이메일에서 @가 있는 부분을 찾는다
			3. 찾은 부분에서부터 좌측 우측으로 나누어서 값을 찾는다.
		
		*/
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("이메일 : ");
		String input = reader.readLine();
		
		//split 방식
		String[] email = input.split("@");
		
		System.out.printf("아이디 : %s\n", email[0]);
		System.out.printf("도메인 : %s\n", email[1]);
		//입력값을 split 메소드를 이용해 배열을 나누어 저장 
		//나누어진 두개의 배열을 출력한다.
		System.out.println("===============");
		
		//substring 방식
		int index = input.indexOf("@");
		System.out.printf("아이디 : %s\n", input.substring(0, index));
		System.out.printf("도메인 : %s\n", input.substring(index + 1)); //(index + 1 (, input.length() > 빠져도 상관없음))
		
		//indexOf 메소드를 이용해 @가 있는 위치를 찾아준다.
		//substring을 이용해 입력값의 시작인 0부터 찾아낸 @의 위치까지를 아이디로 출력
		//substring을 이용해 @의 위치의 +1 값부터 입력값의 길이만큼 출력한다.
		
	}

}
