package com.test.java.question.multiarray;

public class Q05 {
	
	public static void main(String[] args) {
		
		int[][] nums = new int[5][5];
		
		//데이터 입력 > 문제의 요구사항에 따라 수정 > 문제 풀이
		int n = 1;
		
//		for (int i = 0; i<1; i++) {
//			for (int j = 2; j < 3; j++) {
//				nums[i][j] = n;
//				n++;
//			}
//		}	
//		for (int i = 1; i<2; i++) {
//			for (int j = 1; j < 4; j++) {
//				nums[i][j] = n;
//				n++;
//			}
//		}
//		
//		for (int i = 2; i<3; i++) {
//			for (int j = 0; j < 5; j++) {
//				nums[i][j] = n;
//				n++;
//			}
//		}
		
		for (int i = 0; i < 5; i++) {
			if (i <= 2) {
				for (int j = 5-i-3; j < i + 3; j++) {
					nums[i][j] = n;
					n++;
				}
			}}
		
		
		for (int i = 3; i<4; i++) {
			for (int j = 1; j < 4; j++) {
				nums[i][j] = n;
				n++;
			}
		}
		
		for (int i = 4; i<5; i++) {
			for (int j = 2; j < 3; j++) {
				nums[i][j] = n;
				n++;
			}
		}
		
		
		//데이터 출력 > 절대 수정 금지!!!!
		
		for (int i = 0; i<5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.printf("%5d", nums[i][j]);
			}
			System.out.println();
		}
		
		
		
	}

}
