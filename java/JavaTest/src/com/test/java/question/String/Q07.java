package com.test.java.question.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q07 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("숫자: ");
		int input = Integer.parseInt(reader.readLine());
		
		//substring
//		int index = input.indexOf("@");
//		System.out.printf("아이디 : %s\n", input.substring(0, index));
//		System.out.printf("도메인 : %s\n", input.substring(index + 1)); //(index + 1 (, input.length() > 빠져도 상관없음))
	}

}
