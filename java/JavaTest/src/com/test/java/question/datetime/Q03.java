package com.test.java.question.datetime;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Q03 {
	
	public static void main(String[] args) throws Exception {
		
		/*

		요구사항] 태어난 년도를 입력하면 나이를 출력하시오.

		조건..
		올해를 기준으로 나이를 계산하시오.
		내년, 내후년에 실행해도 그때에 맞는 나이가 출력되야합니다.
		우리나라 나이로 출력하시오.
		입력..
		태어난 년도: 1995 

		출력..
		나이 : 28세

		*/
		System.out.print("태어난 년도: ");
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(reader.readLine());
		
		nowage(input);
		
	}

	private static void nowage(int input) {
		
		Calendar birth = Calendar.getInstance();
		birth.add(Calendar.YEAR, -input + 1);
		
		System.out.printf("나이 : %d세\n", birth.get(Calendar.YEAR));
		
		
	}

}
