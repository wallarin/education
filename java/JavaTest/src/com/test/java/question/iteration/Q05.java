package com.test.java.question.iteration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q05 {
	
	public static void main(String[] args) throws Exception {
		
		/*

		요구사항] 아래와 같이 출력하시오.

		입력..
		시작 숫자 : 1 

		종료 숫자 : 10 

		출력..
		1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 = 55
		입력..
		시작 숫자 : 3 

		종료 숫자 : 5 

		출력..
		3 + 4 + 5 = 12

		*/
		int sum = 0;
		String n = "";
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("시작 숫자 : ");
		int start = Integer.parseInt(reader.readLine());
		
		System.out.print("종료 숫자 : ");
		int end = Integer.parseInt(reader.readLine());
		
		for (int i=start; i<=end; i++) {
			
			sum += i;
			
			if (i < end) {
				n += i + " + ";
			} else {
				n += i;
			}
			
		}
		System.out.printf("%s = %d",n, sum);
	}

}
