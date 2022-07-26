package com.test.java.question.multiarray;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q07 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("국어 점수 : ");
		int kor = Integer.parseInt(reader.readLine());
		System.out.print("영어 점수 : ");
		int eng = Integer.parseInt(reader.readLine());
		System.out.print("수학 점수 : ");
		int math = Integer.parseInt(reader.readLine());
		
		int korscore = kor / 10;
		
		String[][] score = new String[10][3];
		int n = 0;
		
		for (int i = 9; i >= 0; i--) {
			for (int j = 0; j < 3; j++) {
				
				score[i][n] = "■";
				
			}
		}
		
//		for (int i = 0; i < 10; i++) {
//			if (kor - 10 * n >= 0) {
//				for (int j = 0; j < 1; j++) {
//					System.out.printf(" ■	",score[0][j]);
//					n++;
//				}
//			}System.out.println();
//		}	
//		n=1;
//		for (int i = 0; i < 10; i++) {
//			if (eng - 10 * n >= 0) {
//				for (int j = 1; j < 2; j++) {
//					 System.out.printf(" ■	\n",score[i][j]);
//					n++;
//				}
//			} 
//		}
			
		for (int i = 0; i<10; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.printf(" %s	", score[i][j]);
			}
			System.out.println();
		}

		System.out.println("===================");
		System.out.println("국어	영어	수학");
	}

}
