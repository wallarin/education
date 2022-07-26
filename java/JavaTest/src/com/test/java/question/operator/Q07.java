package com.test.java.question.operator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q07 {
	
	public static void main(String[] args) throws Exception {
		
		//코드 리뷰
		//- 현업
		//- 작성된 코드를 리뷰
		
		//코드 리뷰 형태
		//1. 상급자 > 하급자 코드 리뷰 > 검사
		//2. 동급자 > 브레인스토밍(코드를 이용한 토론)
		//3. 상급자 + 하급자 > 브레인스토밍
		
		//코드 리뷰 목적
		//1. 자신의 코드 상태 > 명확하게 인지
		//2. 다른 사람의 코드 상태 > 견문 확장
		
		//방식 > 
		//산출물 > 코드 리뷰 > 제출 > 형식 제출
		
		//요구사항] 영문 소문자를 1글자 입력받은 후 대문자로 변환해서 출력하시오.
		
		// +) 바로 코딩 (X)
		// 무조건 설계먼저!!!
		
		// 문제를 풀기 위한 프로세스..
		
		//1. 라벨을 출력한다. > "소문자 입력: "
		//2. BufferdReader를 생성한다. > throws Exception 을 적는다
		//3. 소문자를 입력받는다. > reader.readLine();
		//4. 3의 반환값(문자열)을 받아서 char형으로 바꾼다. 입력값.charAt(0)
		//5. 4의 char의 문자 코드값을 얻는다. > 형변환
		//6. 5의 문자 코드값에서 -32 > 대문자의 문자 코드값
		//7. 6의 문자 코드값을 char 형변환
		//8. 콘솔에 "소문자 'a'의 대문자는 'A'입니다." 출력한다.
		
		//코드 작성 > Rework 검색 (Ctrl + Shift + L)
		
		// Task Tags
		// TODO 나중에 해야할 일 > 기능 개선, 일부 수정..
		// FIXME 나중에 수정할 내용(버그 발생)
		// XXX 나머지..
		
		/*
		 	
		 	System.out.print("소문자 입력: ");
		 	
		 	BufferedReader reader = new BufferedReader(new InputStreamReader(Systme.in));
		 	
		 	String input = reader.readLine();
		 	
		 */
			
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("대문자로 변환할 소문자를 입력하세요(알파벳): ");
		
		String input = reader.readLine();
		
		char result = input.charAt(0);
		
		System.out.printf("결과: %c", result - 32);
		
		
	}

}
