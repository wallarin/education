package com.test.java;

public class Item16_for {
	
	public static void main(String[] args) {
		
		//[SUMMARY] for문과 다중 for문 (2022. 3. 23. 오후 10:27:35)
		
		/*
		
			for 문은 반복문으로써 개발자가 원하는 만큼 설정해 반복실행이 가능하다.
			
			for (초기값; 조건값; 증감값) {
				원하는 실행문;
				
				if (조건문) {
					break; < if문을 빠져나오는 break가 아닌 for문을 빠져나오는 break이다.
				}
			}
			> 초기값이나 조건값이 없으면 무한 루프에 빠지게 된다. but 활용하는 경우도 있음
			Ex22_for Line 381
			
			for (int i = 0; i < 10; i++) {
				System.out.println("안녕하세요");
			} > i가 0으로 시작해 10보다 값이 작으므로 실행문을 실행한뒤 +1 증가
			  > i가 1로 값이 증가하고 10보다 작으므로 실행문을 실행한뒤 +1 증가
			  > ............
			  > i가 9로 값이 증가하고 10보다 작으므로 실행문을 실행한뒤 +1 증가
			  > i가 10으로 값이 증가하고 10보다 작지 않으므로 for문을 탈출한다.
			  > 결과는 "안녕하세요"라는 값이 10번 출력된다.
		
		
		*/
		
		
		/*
			다중 for문
			
			for (int i = 0; i < 3; i++) {
				//k 와 j는 사용이 불가능
				
				for (int j = 0; j < 3; i++) {
					for (int k = 0; k < 3; k++) {
					
						[i][j][k]
						[0][0][0]
						[0][0][1]
						[0][0][2] > k 2 바퀴 완
								  > j 0-0 바퀴 완
						[0][1][0] 
						[0][1][1]
						[0][1][2] > k 2 바퀴 완
								  > j 0-1 바퀴 완
						[0][2][0]
						[0][2][1]
						[0][2][2] > k 2 바퀴 완
								  > j 0-2 바퀴 완
						[1][0][0] 
						[1][0][1]
						[1][0][2]
						
						[1][1][0]
						[1][1][1]
						[1][1][2]
						
						[1][2][0]
						[1][2][1]
						[1][2][2]
								  > i 1바퀴 완
						[2][0][0]
						[2][0][1]
						[2][0][2]
						
						[2][1][0]
						[2][1][1]
						[2][1][2]
						
						[2][2][0]
						[2][2][1]
						[2][2][2]
						
						탈출
						
					
					
					}
				}	
			}
			
			
		 */
		
		System.out.println("[i][j][k]");
		
		for (int i = 0; i < 3; i++) {
			System.out.printf("|%d| i 시작\n", i);
			for (int j = 0; j < 3; j++) {
				System.out.printf("|%d| j 시작\n", j);
				for (int k = 0; k < 3; k++) {
					System.out.printf("[%d][%d][%d]\n", i, j, k);
				}
			}
		}
		
	}//main

} //class
