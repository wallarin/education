package com.test.java.question.multiarray;

public class Q04 {
	
	public static void main(String[] args) {
		
		int[][] nums = new int[5][5];
		
		//데이터 입력 > 문제의 요구사항에 따라 수정 > 문제 풀이
		int n = 1;
		
		//정배열로 출력하되 이중 for문에 조건식이 최대값 - i 값을 하면 해결
		for (int i = 0; i<5; i++) {
			for (int j = 0; j < 5-i; j++) {
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
