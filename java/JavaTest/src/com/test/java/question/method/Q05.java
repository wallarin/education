package com.test.java.question.method;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q05 {
	
	public static void main(String[] args) throws Exception {
		
		/*
		요구사항] 숫자를 전달하면 '짝수' 혹은 '홀수' 라는 단어를 반환하는 메소드를 선언하시오.
		
		조건..
		String getNumber(int)
		입력..
		숫자 : 5

		호출..
		result = getNumber(n); 
		System.out.printf("입력하신 숫자 '%d'는(은) '%s'입니다.\n", n, result);
		출력..
		입력하신 숫자 '5'는(은) '홀수'입니다.
		입력..
		숫자 : 2 

		호출..
		result = getNumber(n); 
		System.out.printf("입력하신 숫자 '%d'는(은) '%s'입니다.\n", n, result);
		출력..
		입력하신 숫자 '2'는(은) '짝수'입니다.
		
		--프로세스
		1. getNumber 메소드를 생성해 인자값을 2로 나눠 나머지 값이 0이라면 "짝수" 나머지 값이 1이라면 "홀수"를 출력하는 조건식을 생성한다.
		2. main 메소드에 BufferedReader를 선언하고 입력받은 값을 int 형으로 변환해준다.
		3. 입력받은 숫자의 결과값을 String으로 출력해준다.
		*/
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("숫자를 입력하세요.: ");
		String input = reader.readLine();
		int n = Integer.parseInt(input);
		
		String result = getNumber(n);
		System.out.printf("입력하신 숫자 '%d'는(은) '%s'입니다.\n", n, result);
		
		
	}
	
	public static String getNumber(int num) {
		
		//String result = num == 0 ? "0" : num % 2 == 0 ? "짝수" : "홀수";
		String result = num % 2 == 0 ? "짝수" : "홀수";
		
		return result;
	}

}
