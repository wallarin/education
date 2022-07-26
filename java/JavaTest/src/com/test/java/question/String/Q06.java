package com.test.java.question.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q06 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.printf("주민등록번호: ");
		String input = reader.readLine();
		
		char[] jumin = input.toCharArray();
		
		int num = 2;
		int result = 0;
		
		for (int i = 0; i < jumin.length-1; i++) {
			if (jumin[i] == '-') {
			} else {
				if (num == 10) {
					num = 2;
					i--;
				} else {
					result += (jumin[i] - 48) * num;
					num++;
				}
			}
		
		}
		
		int check = 11 - (result % 11);
		
			if (check == jumin[13]-48) {
				System.out.println("올바른 주민번호 입니다.");
			} else if (check % 10 == jumin[13]-48) {
				System.out.println("올바른 주민번호 입니다.");
			} else {
				System.out.println("올바르지 않은 주민번호 입니다.");
			}
		
		
	}

}
