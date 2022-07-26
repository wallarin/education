package com.test.java.question.multiarray;

public class Q01 {

	public static void main(String[] args) {

		int[][] nums = new int[5][5];

		// 데이터 입력 > 문제의 요구사항에 따라 수정 > 문제 풀이
		int n = 1;

		for (int i = 0; i < 5; i++) {
			
			//대회전의 값을 2로 나눴을때 나머지가 0이면 정배열에 값 입력
			if (i % 2 == 0) {
				for (int j = 0; j < 5; j++) {
					nums[i][j] = n;
					n++;
				}
			} else { //대회전 값을 2로 나눴을때 나머지가 1이면 역배열에 값 입력
				for (int j = 4; j > -1; j--) {
					nums[i][j] = n;
					n++;
				}
			} //else 절
		} //대회전 for문

		// 데이터 출력 > 절대 수정 금지!!!!

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.printf("%5d", nums[i][j]);
			}
			System.out.println();
		}

	}// main

}
