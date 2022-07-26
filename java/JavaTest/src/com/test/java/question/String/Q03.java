package com.test.java.question.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q03 {
	
	public static void main(String[] args) throws Exception {
		
		//1.BufferedReader를 생성해 숫자로 변환할 값을 입력받는다
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("숫자 : ");
		String input = reader.readLine();
		
		//배열의 길이만큼 돌려야 해서 추출한 배열
		char[] nums = input.toCharArray();
		
		int sum = 0;
		
		for (int i = 0; i < nums.length; i++) {
			
			//if문은 표현식을 깔끔하게 하기위한 것
			if(i == nums.length-1) {
				System.out.printf("%s = ",input.charAt(i));
			} else {
				System.out.printf("%s + ",input.charAt(i));
			}
			
			//sum에 하나씩 추출해서 합산해 주는데 charAt으로 하나씩 추출 숫자 데이터는 -48 or '0'을 빼줘야 정확한 값이 들어간다.
			sum += input.charAt(i)-48;
			//sum += Character.getNumericValue(input.charAt(i));
		}
		
		System.out.println(sum);
		
		
	}

}
