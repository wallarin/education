package com.test.java.question.multiarray;

public class Q08 {

	public static void main(String[] args) {


		// [1] 준비
		int[][] nums = new int[5][5];
		int n = 1; // 1씩 증가되는 숫자가 저장되는 변수

		// [2] 처리
		for (int SPIN = 0; SPIN < 9; SPIN++) { // 0~8 : 9회전 : 대각선
			for (int i = 0; i < 5; i++) { // 0~4 : 5회전 : 행

				int j = SPIN - i; // 열
				if (j >= 0 && j < 5) { // 0보다 크거나 같고 5보다 작은 경우에
					nums[i][j] = n;
					n++;
				}
			}
		}


		// [3] 출력
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(nums[i][j] + "\t");
			}
			System.out.println();
		}

	}

}
