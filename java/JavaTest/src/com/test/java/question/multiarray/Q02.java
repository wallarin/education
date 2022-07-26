package com.test.java.question.multiarray;

public class Q02 {
	
	public static void main(String[] args) {

		int[][] nums = new int[5][5];

		// 데이터 입력 > 문제의 요구사항에 따라 수정 > 문제 풀이
		int n = 1;
		
		//두 for문 모드 배열끝에서부터 시작해 감소하면서 값을 채우도록 조건식 변경
		
		for (int i = 4; i > -1; i--) {
			for (int j = 4; j > -1; j--) {
				nums[i][j] = n;
				n++;
			}
		}

		// 데이터 출력 > 절대 수정 금지!!!!

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.printf("%5d", nums[i][j]);
			}
			System.out.println();
		}

	}// main

}
