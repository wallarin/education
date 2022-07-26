package com.java.chapter4;

import java.util.Scanner;

public class FlowEx28 {
	public static void main(String[] args) {
		int input = 0, answer = 0;
		
		answer = (int)(Math.random() * 100) + 1;
		Scanner scanner = new Scanner(System.in);
		
		do { //무조건 1번은 실행
			System.out.print("1과 100사이의 정수를 입력하세요.> ");
			input = scanner.nextInt();
			
			if (input > answer) {
				System.out.println("더 작은 수로 다시 시도해보세요.");
			} else if (input < answer) {
				System.out.println("더 큰 수로 다시 시도해보세요.");
			} 
				
		} while(input!=answer); //조건식의 조건이라면 다시 do문 실행
		
		System.out.println("정답입니다."); //while문의 조건식이 거짓일때 실행됨
		
	}

}
