package com.test.java.question.iteration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q03 {

	public static void main(String[] args) throws Exception {
		
		/*

		요구사항] 숫자 1개를 입력받아 1부터 입력한 숫자까지의 합을 출력하시오.

		입력..
		숫자 : 5 

		출력..
		1 ~ 5 = 15
		입력..
		숫자 : 10 

		출력..
		1 ~ 10 = 55

		*/
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("숫자 : ");
		int num = Integer.parseInt(reader.readLine());
		
		int sum = 0;
		
		for (int i=1; i <= num; i++) {
			sum += i;
		}
		System.out.printf("1 ~ %d = %d", num, sum);
	}
	
}
