package com.test.java.question.method;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q08 {
	
	public static void main(String[] args) throws Exception {
		
		/*
		요구사항] 사과 나무가 있다. 사과 나무 씨앗을 심을 날로부터 특정 시간이 흘렀을 때 사과 총 몇개가 열리는지 구하는 메소드를 선언하시오.

		조건..
		int getApple(int sunny, int foggy)
		사과 나무를 처음 심었을 때 나무의 길이: 0m
		맑은 날 사과 나무의 성장률: 5㎝
		흐린 날 사과 나무의 성잘률: 2㎝
		사과 나무는 길이가 1m 넘는 시점부터 사과가 열린다.
		1m 넘는 시점부터 10㎝ 자랄 때마다 사과가 1개씩 열린다.
		입력..
		맑은 날 : 35 

		흐린 날 : 10 

		출력..
		사과가 총 9개 열렸습니다.
		
		--프로세스
		1.2개의 인자값을 받는 getApple 메소드를 생성한다.
		2.(sunny * 5) + (foggy * 2) > 100 조건식을 생성해 조건이 성립한다면
		3.((sunny * 5) + (foggy * 2) - 100) / 10 값을 출력 성립하지 않는다면 0값을 apple로 return한다.
		4.BufferedReader를 선언 후 값을 입력받고 입력받은 값을 int형으로 변환 후 값을 getApple 메소드로 전달
		5.결과값을 출력한다.
		*/
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("맑은 날 : ");
		String input = reader.readLine();
		int input_sunny = Integer.parseInt(input);
		
		System.out.print("흐린 날 : ");
		String input2 = reader.readLine();
		int input_foggy = Integer.parseInt(input2);
		
		int apple = getApple(input_sunny, input_foggy);
		System.out.printf("사과가 총 %d개 열렸습니다.", apple);
		
	}
	
	public static int getApple(int sunny, int foggy) {
		
		int apple = (sunny * 5) + (foggy * 2) > 100 ? ((sunny * 5) + (foggy * 2) - 100) / 10 : 0;
		
		return apple;
		
	}

}
