package com.test.java.question.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q05 {

	public static void main(String[] args) throws Exception {

		/*
		
		요구사항] 난수를 담고 있는 배열을 생성한 뒤 아래와 같이 출력하시오.
		
		조건..
		난수를 20개 발생 후 배열에 넣는다.
		난수는 1 ~ 20 사이
		배열을 탐색하여 범위에 만족하는 숫자만 출력한다.
		입력..
		최대 범위 : 15 
		
		최소 범위 : 5 
		
		출력..
		원본 : 10, 2, 3, 20, 15, 9, 5, 1, 3, 11, 15, 18, 9, 14, 18, 5, 8, 2, 1, 17
		결과 : 10, 15, 9, 5, 11, 15, 9, 14, 5, 8
		
		*/

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int[] random = new int[20];

		// 난수 20개 생성 후 배열에 저장
		for (int i = 0; i < random.length; i++) {

			random[i] = (int) (Math.random() * 20) + 1;

		}

		System.out.print("최대 범위 : ");
		int maxInput = Integer.parseInt(reader.readLine());

		System.out.print("최소 범위 : ");
		int minInput = Integer.parseInt(reader.readLine());

		// 출력
		System.out.print("원본 : ");
		for (int i = 0; i < random.length; i++) {

			System.out.printf("%d, ", random[i]);

		}

		System.out.println();

		System.out.print("결과 : ");
		for (int i = minInput - 1; i < maxInput; i++) {

			System.out.printf("%d, ", random[i]);
		}


	}

}
