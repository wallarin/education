package com.test.java.question.multiarray;

import java.util.Arrays;

public class Q06 {
	
	public static void main(String[] args) {
		
		int[][] nums = new int[5][5];
		int n = 1;
		int sum = 0;
		int result = 0;
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				nums[i][j] = n;
				sum += n;
				n++;
				
			}
		
			for (int j = 4; j < 5; j++) {
				nums[i][j] = sum;
				result += sum;
				sum = 0;
			}
		}
		
		//열의 합 해보는중
		for (int i = 0; i < 5; i++) {
			nums[4][4] += nums[i][0];
			System.out.printf("%s",nums[i][0]);
			for (int j = 0; j < 5; j++) {
				
			}
		}
		
		
		//열의 합은 어떻게 구해야하나?
		
		nums[4][4] = result;
		
		//출력
		for (int i = 0; i<5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.printf("%5d", nums[i][j]);
			}
			System.out.println();
		}
		
	}

}
