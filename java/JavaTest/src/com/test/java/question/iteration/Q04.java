package com.test.java.question.iteration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q04 {

	public static void main(String[] args) throws Exception {
		
		/*

		요구사항] 입력 횟수(N)와 숫자 N개를 입력받아 짝수의 합과 홀수의 합을 각각 출력하시오.

		입력..
		입력 횟수 : 10 

		숫자 : 5 
		숫자 : 2 
		숫자 : 12 
		숫자 : 3 
		숫자 : 11 
		숫자 : 8 
		숫자 : 1 
		숫자 : 7 
		숫자 : 23 
		숫자 : 10 

		출력..
		짝수 4개의 합 : 32
		홀수 6개의 합 : 50
		입력..
		입력 횟수 : 3 

		숫자 : 1 

		숫자 : 2 

		숫자 : 3 

		출력..
		짝수 1개의 합 : 2
		홀수 2개의 합 : 4

		*/
		int odd = 0, even = 0;
		int oddCount = 0, evenCount = 0;
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("입력 횟수 : ");
		int loopTime = Integer.parseInt(reader.readLine());
		
		for (int i=0; i<loopTime; i++) {
			
			System.out.print("숫자 : ");
			int num = Integer.parseInt(reader.readLine());
			
			if (num % 2 == 0) {
				even += num;
				evenCount++;
			} else {
				odd += num;
				oddCount++;
			}
			
		}
		
		System.out.printf("짝수 %d개의 합 : %d\n", evenCount, even);
		System.out.printf("홀수 %d개의 합 : %d\n", oddCount, odd);
		
	}
	
}
