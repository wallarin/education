package com.test.java.question.repeatwhile;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q01 {

	public static void main(String[] args) throws Exception {

		/*
		
		요구사항] 숫자를 N개 입력받아 아래와 같이 출력하시오.
		
		조건..
		누적값이 100을 넘어가는 순간 루프를 종료하시오.
		짝수는 더하고 홀수는 빼시오.
		입력..
		숫자 : 12 
		
		숫자 : 28 
		
		숫자 : 39 
		
		숫자 : 15 
		
		숫자 : 38 
		
		숫자 : 24 
		
		숫자 : 78 
		
		출력..
		12 + 28 - 39 - 15 + 38 + 24 + 78 = 126
		
		*/

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int sum = 0;

		String n = "";

		boolean loop = true;

		while (loop) {

			System.out.print("숫자 : ");

			int input = Integer.parseInt(reader.readLine());

			if (input % 2 == 0) {

				n += " + " + input;
				sum += input;

			} else if (input % 2 == 1) {

				n += " - " + input;
				sum -= input;

			}

			if (sum >= 100) {
				loop = false;
			}
			// else {
			// System.out.println(n);
			// }
		}

		System.out.printf("%s = %d\n", n, sum);
	}

}
