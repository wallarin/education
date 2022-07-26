package com.test.java.question.multifor;

public class Q12 {
	
	public static void main(String[] args) {
		
		/*
		  
		요구사항] 아래와 같이 출력하시오.

		조건..
		마지막 숫자가 100이 넘기 전까지 출력하시오.
		출력..
		1 + 1 + 2 + 3 + 5 + 8 + 13 + 21 + 34 + 55 + 89 = 232
		
		// sum <= 100;
		// for문 0+1
		// 더한 값이 for문의 int값
		// else 결과식과 합 출력
		
		*/
		
		int num1 = 1;
		int num2 = 1;
		int num3 = 0;
		int sum = 2;
		
		System.out.print(num1+" + "+num2);
		
		for (int i = 0; i < 9; i++ ) {
		num3 = num1 + num2; 
		sum += num3;
		System.out.print(" + "+num3); 
		num1 = num2;
		num2 = num3;
		}
		System.out.print(" = " + sum);
		
	}
	
}
