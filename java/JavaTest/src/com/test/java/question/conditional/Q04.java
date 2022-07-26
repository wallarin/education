package com.test.java.question.conditional;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q04 {

	public static void main(String[] args) throws Exception {

		/*
		
		요구사항] 근무 년수를 입력받아 아래와 같이 출력하시오.
		
		조건..
		1 ~ 4년차 : 초급 개발자
		5 ~ 9년차 : 중급 개발자
		10년차 이상 : 고급 개발자
		유효성 검사를 하시오.(1 미만 입력 예외 처리)
		입력..
		근무 년수 : 2 
		
		출력..
		2년차 초급 개발자입니다.
		앞으로 3년 더 근무를 하면 중급 개발자가 됩니다. 
		입력..
		근무 년수 : 5 
		
		출력..
		5년차 중급 개발자입니다.
		당신은 1년전까지 초급 개발자였습니다.
		앞으로 5년 더 근무를 하면 고급 개발자가 됩니다.
		입력..
		근무 년수 : 11 
		
		출력..
		11년차 고급 개발자입니다.
		당신은 2년전까지 중급 개발자였습니다.
		입력..
		근무 년수 : -5 
		
		출력..
		입력한 값이 올바르지 않습니다. 1이상의 값을 입력하시오.
		
		1. BufferedReader 생성
		2. 입력받은 값을 int형으로 변환
		3. if (입력값 >= 1) {
			if (입력값 >= 1 && 입력값 <= 4) {
				%d년차 초급 개발자입니다.
				앞으로 %d년 더 근무를 하면 중급 개발자가 됩니다. 
			} else if (입력값 >= 5 && 입력값 <= 9)
			 	%d년차 중급 개발자입니다.
			 	당신은 %d년전까지 초급 개발자였습니다.
				앞으로 %d년 더 근무를 하면 고급 개발자가 됩니다. 
			} else if (입력값 >= 10) {
				%d년차 고급 개발자입니다.
				당신은 %d년전까지 중급 개발자였습니다.
			} else {
				올바르지 않다는 메세지 출력
			}
		
		*/
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("근무 년수: ");
		int developer = Integer.parseInt(reader.readLine());
		
		if (developer >= 1) {
			if (developer >= 1 && developer <= 4) {
				System.out.printf("%d년차 초급 개발자입니다. \n"
						+ "앞으로 %d년 더 근무를 하면 중급 개발자가 됩니다.", developer, 5 - developer);
			} else if (developer <= 9) {
				System.out.printf("%d년차 중급 개발자입니다. \n"
						+ "당신은 %d년전까지 초급 개발자였습니다.\n"
						+ "앞으로 %d년 더 근무를 하면 고급 개발자가 됩니다.", developer, developer - 4, 10 - developer);
			} else if (developer >= 10) {
				System.out.printf("%d년차 고급 개발자입니다.\n"
						+ "당신은 %d년전까지 중급 개발자였습니다.", developer, developer - 9);
			}
		} else {
			System.out.println("입력한 값이 올바르지 않습니다. 1이상의 값을 입력하시오.");
		}
	}
}
