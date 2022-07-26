package com.test.java.question.conditional;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q05 {
	
	public static void main(String[] args) throws Exception {
		
		/*

		요구사항] 숫자 2개와 연산자 1개를 입력받아 연산 과정과 결과를 출력하시오.

		조건..
		정수만 입력하시오.(유효성 검사 필요없음)
		나머지 연산 결과는 소수이하 첫째자리까지 출력 하시오.
		연산자는 산술 연산자(+, -, *, /, %)만 입력하시오.
		
		입력..
		첫번째 숫자 : 5 

		두번째 숫자 : 3 

		연산자 : * 

		출력..
		5 * 3 = 15
		입력..
		첫번째 숫자 : 10 

		두번째 숫자 : 3 

		연산자 : / 

		출력..
		10 / 3 = 3.3
		입력..
		첫번째 숫자 : 3 

		두번째 숫자 : 2 

		연산자 : >= 

		출력..
		연산이 불가능합니다.
		
		--프로세스
		1. BufferedReader를 생성해 첫번째와 두번째 입력값은 int로 형변환 세번째 입력값은 String으로 변수에 저장한다.
		2. 세번째 입력값에 산술 연산자(+, -, *, /, %)를 조건으로 가지는 if문을 생성한다.
		3. if문 안에서 각각의 산술 연산자의 값을 가지는 if, else if문을 생성한다.
		4. 산술 연산자(+, -, *, /, %)를 제외한 나머지 입력값을 입력하면 "연산이 불가능합니다."을 출력한다.

		*/
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("첫번째 숫자 : ");
		int firstNum = Integer.parseInt(reader.readLine());
		
		System.out.print("두번째 숫자 : ");
		int secondNum = Integer.parseInt(reader.readLine());
		
		System.out.print("연산자 : ");
		String operator = reader.readLine();
		
		if (operator.equals("+")) {
			System.out.printf("%,d + %,d = %,d\n", firstNum, secondNum, firstNum + secondNum);
		} else if (operator.equals("-")) {
			System.out.printf("%,d - %,d = %,d\n", firstNum, secondNum, firstNum - secondNum);
		} else if (operator.equals("*")) {
			System.out.printf("%,d * %,d = %,d\n", firstNum, secondNum, firstNum * secondNum);
		} else if (operator.equals("/")) {
			System.out.printf("%,d / %,d = %,.1f\n", firstNum, secondNum, (double)firstNum / secondNum);
		} else if (operator.equals("%")) {
			System.out.printf("%,d %% %,d = %,d\n", firstNum, secondNum, firstNum % secondNum);
		} else {
			System.out.println("연산이 불가능합니다.");
		}
		
	}

}
