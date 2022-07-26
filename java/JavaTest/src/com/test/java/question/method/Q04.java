package com.test.java.question.method;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q04 {

	public static void main(String[] args) throws Exception {

		/*
		 
		 요구사항] 숫자를 2개 입력받아 연산식을 반환하는 메소드를 선언하시오.
		
		 조건..
		 String add(int, int)
		 String subtract(int, int)
		 String multiply(int, int)
		 String divide(int, int)
		 String mod(int, int)
		 
		 입력..
		 첫번째 숫자 : 5 
		
		 두번째 숫자 : 3 
		
		 호출..
		 result = add(n1, n2); 
		 System.out.println(result);
		
		 result = subtract(n1, n2);
		 System.out.println(result);
		
		 result = multiply(n1, n2);
		 System.out.println(result);
		
		 result = divide(n1, n2);
		 System.out.println(result);
		
		 result = mod(n1, n2);
		 System.out.println(result);
		 
		 출력..
		 5 + 3 = 8
		 5 - 3 = 2
		 5 * 3 = 15
		 5 / 3 = 1.7
		 5 % 3 = 2
		 
		 -- 프로세스
		 1. 2가지 인자값을 넣으면 더한 값을 출력해주는 add 메소드를 생성한다
		 2. 2가지 인자값을 넣으면 뺀 값을 출력해주는 subtract 메소드를 생성한다
		 3. 2가지 인자값을 넣으면 곱한 값을 출력해주는 multiply 메소드를 생성한다
		 4. 2가지 인자값을 넣으면 나누기 소수값을 출력해주는 divide 메소드를 생성한다
		 5. 2가지 인자값을 넣으면 나머지 값을 출력해주는 mod 메소드를 생성한다
		 6. main 메소드에 BufferdReader를 생성해 두 값을 입력받도록 한다.
		 		 입력받은 두 인자의 결과값들을 출력하는 코드를 생성한다.
		*/

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("첫번째 숫자 : ");
		String input = reader.readLine();
		int n1 = Integer.parseInt(input);

		System.out.print("두번째 숫자 : ");
		String input2 = reader.readLine();
		int n2 = Integer.parseInt(input2);

		String result = add(n1, n2);
		System.out.println(result);

		result = subtract(n1, n2);
		System.out.println(result);

		result = multiply(n1, n2);
		System.out.println(result);

		result = divide(n1, n2);
		System.out.println(result);

		result = mod(n1, n2);
		System.out.println(result);
	}

	public static String add(int num1, int num2) {

		String result = num1 + " + " + num2 + " = " + (num1 + num2);

		return result;

	}

	public static String subtract(int num1, int num2) {

		String result = num1 + " - " + num2 + " = " + (num1 - num2);

		return result;

	}

	public static String multiply(int num1, int num2) {

		String result = num1 + " * " + num2 + " = " + (num1 * num2);

		return result;

	}

	public static String divide(int num1, int num2) { // 해결하지 못함..

		// String result = num1 + " / " + num2 + " = " + (double)(num1 / num2);
		String result = String.format("%d / %d = %.1f", num1, num2, (double)num1 / num2);

		return result;

	}

	public static String mod(int num1, int num2) {

		String result = num1 + " % " + num2 + " = " + (num1 % num2);

		return result;
		
		//return num1 + " % " + num2 + " = " + (num1 % num2); > 이것도 가능하다

	}

}
