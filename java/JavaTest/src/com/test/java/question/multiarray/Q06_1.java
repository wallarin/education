package com.test.java.question.multiarray;

public class Q06_1 {

	public static void main(String[] args) {

		int[][] nums = new int[5][5];
		int n = 1;

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				nums[i][j] = n;
				n++;
				
				nums[i][4] += nums[i][j];
				nums[4][j] += nums[i][j];
				nums[4][4] += nums[i][j];
			}
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.printf("%5d", nums[i][j]);
			}
			System.out.println();
		}

	}

}
