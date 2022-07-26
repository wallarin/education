package com.test.java.question.operator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q03 {
	
	public static void main(String[] args) throws Exception{
		
		//요구사항] 사각형의 너비와 높이를 입력받아 넓이와 둘레를 출력하시오.
		
		/*
		사각형 넓이 = 가로 * 높이
		사각형 둘레 = 가로 * 2 + 높이 * 2
		*/
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("넓이와 둘레를 구할 사각형의 가로와 높이를 순서대로 입력하세요.(단위 cm)");
		
		System.out.print("가로(cm): ");
		String Horizontal = reader.readLine();

		System.out.print("높이(cm): ");
		String Height = reader.readLine();
		
		int Ho = Integer.parseInt(Horizontal);
		int He = Integer.parseInt(Height);
		
		System.out.println("========계산 결과==========");
		
		System.out.printf("사각형의 넓이는 %d㎠입니다.\n", Ho * He);
		System.out.printf("사각형의 둘레는 %d㎠입니다.", Ho * 2 + He * 2);
		
		
	}

}
