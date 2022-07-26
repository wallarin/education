package com.test.java.question.conditional;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q06 {
	
	public static void main(String[] args) throws Exception {
		
		/*

		요구사항] 영문자 1개를 입력받아 대/소문자 변환을 한 뒤 출력하시오.

		조건..
		유효성 검사를 하시오.(영문자만 입력 가능)
		입력..
		문자 : a 

		출력..
		'a'의 대문자는 'A'입니다.
		입력..
		문자 : F 

		출력..
		'F'의 소문자는 'f'입니다.
		입력..
		문자 : 가 

		출력..
		영문자만 입력하시오.

		--프로세스
		1. BufferedReader 생성
		2. 값을 입력받아 char 값으로 변환
		3. 입력값이 65이상 90이하 이거나 97이상 122이하 일때 실행되는 if문 생성
		4. if문 안에 이중 if문을 통해 65이상 90이하라면 대문자값을 32 더해 소문자로 변환 출력
		5. else if를 통해 97이상 122이하라면 소문자값을 32 빼 대문자로 변환 출력
		6. 입력값이 65이상 90이하 이거나 97이상 122이하가 아니라면 영문자만 입력하라는 메세지 출력 

		*/
		
		System.out.print("문자 : ");
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String input = reader.readLine();		
		char alpha = input.charAt(0);
		
		if (alpha >= 65 && alpha <= 90 || alpha >= 97 && alpha <= 122) {
			if (alpha >= 65 && alpha <= 90) {
				System.out.printf("'%c'의 소문자는 '%c'입니다.", alpha, alpha + 32);
			} else if (alpha >= 97 && alpha <= 122) {
				System.out.printf("'%c'의 대문자는 '%c'입니다.", alpha, alpha - 32);
			}
		} else {
			System.out.println("영문자만 입력하시오.");
		}
		
	}

}
