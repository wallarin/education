package com.test.java.question.array;

public class Q04 {

	public static void main(String[] args) {

		/*
		
		요구사항] 1~20 사이의 난수를 담고 있는 배열을 생성하고 최대값과 최소값을 출력하시오.
		
		조건..
		난수를 20개 발생 후 배열에 넣는다.
		난수는 1 ~ 20 사이
		출력..
		원본 : 10, 9, 3, 18, 15, 9, 5, 4, 3, 11, 15, 18, 9, 14, 18, 5, 8, 7, 9, 17
		최대값 : 18
		최소값 : 3
		
		*/

		int[] random = new int[20];
		int max = 0;
		int min = 20;

		// 난수 20개 생성 후 배열에 저장
		for (int i = 0; i < random.length; i++) {

			random[i] = (int) (Math.random() * 20) + 1;

		}

		// 배열안에 0보다 큰 값중 제일 큰 값을 저장
		for (int i = 0; i < random.length; i++) {
			if (random[i] > max) {
				max = random[i];
			}
		}

		// 배열안에 20보다 작은 값중 제일 작은 값을 저장
		for (int i = 0; i < random.length; i++) {
			if (random[i] < min) {
				min = random[i];
			}
		}

		// 출력
		System.out.print("원본 : ");
		for (int i = 0; i < random.length; i++) {

			System.out.printf("%d, ", random[i]);

		}
		System.out.println();

		System.out.printf("최대값 : %d\n", max);
		System.out.printf("최소값 : %d\n", min);

	}// main

}
