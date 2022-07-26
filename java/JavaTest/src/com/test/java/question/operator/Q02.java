package com.test.java.question.operator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q02 {
	
	public static void main(String[] args) throws Exception {
		
		//요구사항] 숫자 2개를 입력받아 아래의 연산식을 출력하시오.
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("첫번째 숫자를 입력하세요.: ");
		String Input_num1 = reader.readLine();
		
		System.out.print("두번째 숫자를 입력하세요.: ");
		String Input_num2 = reader.readLine();
		
		int num1 = Integer.parseInt(Input_num1);
		int num2 = Integer.parseInt(Input_num2);
		
		Double dnum1 = Double.parseDouble(Input_num1);
		Double dnum2 = Double.parseDouble(Input_num2);
		
		
		System.out.println("\n==========연산 결과===========\n");
		
		System.out.printf("%,d + %,d = %,d\n", num1, num2, num1 + num2);
		System.out.printf("%,d - %,d = %,d\n", num1, num2, num1 - num2);
		System.out.printf("%,d * %,d = %,d\n", num1, num2, num1 * num2);
		System.out.printf("%,d / %,d = %,,.1f\n", num1, num2, dnum1 / dnum2);
		System.out.printf("%,d %% %,d = %,d\n", num1, num2, num1 % num2);
		
		
		
		
	}

}
