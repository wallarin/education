package com.test.java.question.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q01 {
	
	public static void main(String[] args) throws Exception {
		
		/*
		
			1. Bufferedreader 생성
			2. charAt을 이용해 마지막 문자부터 처음 문자까지 for문으로 추출해 빈 문자열에 값을 넣어준다
			3. 빈 문자열의 값 출력
		
		*/
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("문장 입력 : ");
		String input = reader.readLine();
		
		String result = "";
		
		//i의 길이를 입력한 문자열의 -1 부터 시작 > i가 0번째까지 돌 수 있도록 조건식 설정 > i의 값을 1씩 감소시킨다(-1)
		for (int i = input.length() - 1; i >= 0; i--) {
			//빈 문자열 += 마지막 글자, 마지막 글자 -1 순으로 넣어준다
			result += input.charAt(i);
		}
		
		System.out.printf("역순 결과 : \"%s\"", result);
				
	}

}
