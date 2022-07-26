package com.test.java.question.conditional;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q09 {
	
	public static void main(String[] args) throws Exception {
		
		/*

		요구사항] 년도를 입력받아 해당 년도가 '평년' 인지 '윤년' 인지 출력하시오.

		조건..
		a. 년도를 4로 나눈다.
		떨어지면 b 검사
		떨어지지 않으면 "평년"
		b. 년도를 100으로 나눈다.
		떨어지면 c 검사
		떨어지지 않으면 "윤년"
		c. 년도를 400으로 나눈다.
		떨어지면 "윤년"
		떨어지지 않으면 "평년"
		
		Calendar 클래스 사용 금지
		입력..
		년도 입력 : 2019 

		출력..
		2019년은 '평년'입니다.
		입력..
		년도 입력 : 2020 

		출력..
		2020년은 '윤년'입니다.

		*/
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));		
		System.out.print("년도 입력 : ");
		int input_Year = Integer.parseInt(reader.readLine());
		
		if (input_Year % 4 == 0) {
			if (input_Year % 100 == 0) {
				if (input_Year % 400 == 0) {
					System.out.printf("%d년은 '윤년'입니다.", input_Year);
				} else {
					System.out.printf("%d년은 '평년'입니다.", input_Year);
				}
			} else {
				System.out.printf("%d년은 '윤년'입니다.", input_Year);
			}
		} else {
			System.out.printf("%d년은 '평년'입니다.", input_Year);
		}
		
	}

}
