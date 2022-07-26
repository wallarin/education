package com.test.java.question.operator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q01 {
	
	public static void main(String[] args) throws Exception {
		
		//요구사항] 태어난 년도를 입력받아 나이를 출력하시오.
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("태어난 년도를 입력하세요(4자리): ");
		String Input_age = reader.readLine();
		
		int age = Integer.parseInt(Input_age);
		System.out.println();
		
		System.out.printf("현재 나이: %d", 2022 - age + 1);
		
	}

}
