package com.test.java.question.operator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q04 {
	
	public static void main(String[] args) throws Exception{
		
		//요구사항] 섭씨 온도를 입력받아서 화씨 온도로 변환하시오.
		
		//℉ = ℃ × 1.8 + 32
		//소수 이하 1자리까지 출력하시오.
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("섭씨 온도를 입력하세요.(단위 ℃): ");
		String Input = reader.readLine();
		
		int temp = Integer.parseInt(Input);
		
		System.out.println("========변환 결과==========");
		
		double result = temp * 1.8 + 32;
		
		System.out.printf("섭씨 %d℃는 화씨 %.1f℉입니다.", temp, result);
		
		
	}

}
