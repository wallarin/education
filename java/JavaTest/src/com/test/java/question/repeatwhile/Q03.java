package com.test.java.question.repeatwhile;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q03 {
	
	public static void main(String[] args) throws Exception {
		
		/*

		요구사항] 사용자가 입력한 범위의 숫자까지 369 게임 과정을 출력하시오.

		조건..
		최대 3자리까지만 입력하시오.
		입력..
		최대 숫자 : 50 

		출력..
		1 2 짝 4 5 짝 7 8 짝 10 11 12 짝 14 15 짝 17 18 짝 20 
		21 22 짝 24 25 짝 27 28 짝 짝 짝 짝 짝 짝 짝 짝 짝 짝 짝 짝 짝 짝 40 
		41 42 짝 44 45 짝 47 48 짝 50
		
		-- 10으로 나눴을때 나머지 값이 3 || 6 || 9 라면 짝
		-- 10으로 나눴을 때 몫이 3 || 6 || 9 짝

		*/
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int i = 1;
		System.out.print("최대 숫자 : ");
		int input = Integer.parseInt(reader.readLine());

		while (i <= input) {
			//XXX 133은 미해결 ㅠ
			if (i / 100 == 3 || i / 100 == 6 || i / 100 == 9) {
				if (i % 10 == 3 || i % 10 == 6 || i % 10 == 9) {
					if (i % 10 == 3 || i % 10 == 6 || i % 10 == 9) {
						System.out.print("짝짝짝 ");
					}
					System.out.print("짝짝");
				}
				System.out.print("짝 ");
				i++;
			} else if (i / 10 == 3 || i / 10 == 6 || i / 10 == 9) {
				if (i % 10 == 3 || i % 10 == 6 || i % 10 == 9) {
					System.out.print("짝짝 ");
				}
				System.out.print("짝 ");
				i++;
			}

			else if (i % 10 == 3 || i % 10 == 6 || i % 10 == 9) {
				System.out.print("짝i ");
				i++;
			} else {
				System.out.print(i + " ");
				i++;
			}
		}

	}
	
}
