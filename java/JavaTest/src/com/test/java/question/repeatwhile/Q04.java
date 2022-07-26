package com.test.java.question.repeatwhile;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q04 {
	
	public static void main(String[] args) throws Exception {
		
		/*

		요구사항
		최대 9자리 정수를 입력받아 각자리의 홀수 숫자합과 짝수 숫자합을 구하시오.

		조건..
		9자리 이하 숫자만 입력하시오.
		Math.pow() 메소드 사용(제곱값 구하는 메소드)
		Math.pow(10, 2) → 100
		Math.pow(10, 3) → 1000
		Math.pow(10, 4) → 10000
		입력..
		숫자 입력 : 273645281 

		출력..
		짝수의 합 : 22
		홀수의 합 : 16

		*/
		Math.pow(10, 8);
		
		int evenSum = 0; //짝수 합
		int oddSum = 0; //홀수 합
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.printf("숫자 입력 : ");
		
		int input = Integer.parseInt(reader.readLine());
		
		for (int i = 0; i < 9; i++) {
			
			int pow = (int)(input / Math.pow(10, i)) % 10;
			//넣은 데이터 값에서 / 10 , / 100 , / 1000 ... 을 순차적으로 한 후 그 나눈 자릿수의 나머지를 구한다.
			// 나누면 소수점으로 값이 내려감으로 나머지의 값인 한자리수를 다 뽑을 수 있다.
			
			if (pow % 2 == 0) {
				evenSum += pow;
			} else {
				oddSum += pow;
			}
			
			
		}
		
		System.out.printf("짝수의 합: %d\n", evenSum);
		System.out.printf("홀수의 합: %d\n", oddSum);
		
		
	} //main
	

}
