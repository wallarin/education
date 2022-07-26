package com.test.java.question.operator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q06 {
	
	public static void main(String[] args) throws Exception {
		
		//요구사항] 사용자의 한달 수입을 입력받아 세후 금액을 출력하시오.
		//세금 : 수입의 3.3%
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("한달 수입을 입력하세요.(원): ");
		
		String Input = reader.readLine();
		
		int money = Integer.parseInt(Input);
		
		double I_result = money - (money * 0.033);
		double I_tax = money * 0.033 * Math.PI;
		
		int result = (int)I_result;
		int tax = (int)I_tax;
		
		System.out.println("========변환 결과==========");
		
		System.out.printf("세후 금액(원): %,d원\n", result);
		System.out.printf("세금(원): %,d원", tax);
		
	}

}
