package com.test.java.question.conditional;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q07 {
	
	public static void main(String[] args) throws Exception {
		
		/*

		요구사항] 숫자 5개를 입력받아 짝수와 홀수의 개수를 출력하시오.

		조건..
		1 ~ 10 사이의 정수만 입력받으시오.
		입력..
		숫자 입력 : 3 

		숫자 입력 : 2 

		숫자 입력 : 7 

		숫자 입력 : 1 

		숫자 입력 : 8 

		출력..
		짝수는 2개 홀수는 3개 입력했습니다.
		홀수가 짝수보다 1개 더 많습니다.
		
		*/
		
		int odd_Num = 0, even_Num = 0;
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));		
		System.out.print("숫자 입력 : ");
		int num_1 = Integer.parseInt(reader.readLine());
		
		System.out.print("숫자 입력 : ");
		int num_2 = Integer.parseInt(reader.readLine());
		
		System.out.print("숫자 입력 : ");
		int num_3 = Integer.parseInt(reader.readLine());
		
		System.out.print("숫자 입력 : ");
		int num_4 = Integer.parseInt(reader.readLine());
		
		System.out.print("숫자 입력 : ");
		int num_5 = Integer.parseInt(reader.readLine());
		
		if (num_1 >= 1 && num_1 <= 10) {
			if (num_1 % 2 == 0) {
				even_Num += 1;
			} else {
				odd_Num += 1;
			}
		} else {
			System.out.println("첫번째 입력값이 1 ~ 10의 사이의 정수가 아닙니다.");
		}
		
		if (num_2 >= 1 && num_2 <= 10) {
			if (num_2 % 2 == 0) {
				even_Num += 1;
			} else {
				odd_Num += 1;
			}
		} else {
			System.out.println("두번째 입력값이 1 ~ 10의 사이의 정수가 아닙니다.");
		}
		
		if (num_3 >= 1 && num_3 <= 10) {
			if (num_3 % 2 == 0) {
				even_Num += 1;
			} else {
				odd_Num += 1;
			}
		} else {
			System.out.println("세번째 입력값이 1 ~ 10의 사이의 정수가 아닙니다.");
		}
		
		if (num_4 >= 1 && num_4 <= 10) {
			if (num_4 % 2 == 0) {
				even_Num += 1;
			} else {
				odd_Num += 1;
			}
		} else {
			System.out.println("네번째 입력값이 1 ~ 10의 사이의 정수가 아닙니다.");
		}
		
		if (num_5 >= 1 && num_5 <= 10) {
			if (num_5 % 2 == 0) {
				even_Num += 1;
			} else {
				odd_Num += 1;
			}
		} else {
			System.out.println("다섯번째 입력값이 1 ~ 10의 사이의 정수가 아닙니다.");
		}
		
		System.out.printf("짝수는 %d개 홀수는 %d개 입력했습니다.\n", even_Num, odd_Num);
		
		if (odd_Num >= even_Num) {
			if (odd_Num > even_Num) {
			System.out.printf("홀수가 짝수보다 %d개 더 많습니다.\n", odd_Num - even_Num);
			} else {
				System.out.println("홀수와 짝수의 개수가 같습니다.");
			}
		} else {
			System.out.printf("짝수가 홀수보다 %d개 더 많습니다.\n", even_Num - odd_Num);
		}
		
		
	}

}
