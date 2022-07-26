package com.test.java.question.conditional;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q02 {
	
	public static void main(String[] args) throws Exception {
		
		/*

		요구사항] 학생의 국어 점수를 입력받아 성적을 출력하시오.

		조건..
		90 ~ 100 : A
		80 ~  89 : B
		70 ~  79 : C
		60 ~  69 : D
		 0 ~   59 : F
		유효성 검사를 하시오.(점수 : 0 ~ 100점 이내)
		
		입력..
		점수 : 85 
		출력..
		입력한 85점은 성적 B입니다.
		
		입력..
		점수 : 55 
		출력..
		입력한 55점은 성적 F입니다.
		
		입력..
		점수 : 123 
		출력..
		점수가 올바르지 않습니다. 0~100사이의 값을 입력하시오.
		
		--프로세스
		1. BufferedReader 생성
		2. 입력받은 값을 int형으로 변환
		3. if문을 이용해 0이상 100이하 값이 입력됬을때 실행 아니라면 올바른 값을 입력하라는 메세지 출력
		4. 0이상 100이하의 if 문 안에 각각의 점수만큼 성적을 출력하도록 else if문 구성
		5. 입력 점수와 성적을 화면에 출력한다.

		*/
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("점수: ");
		int kor_score = Integer.parseInt(reader.readLine());
		
		if (kor_score >= 0 && kor_score <= 100) {
			if (0 <= kor_score && kor_score <= 59) {
				System.out.printf("입력한 %d점은 성적 F입니다.\n", kor_score); 
			} else if (kor_score <= 69) {
				System.out.printf("입력한 %d점은 성적 D입니다.\n", kor_score); 
			} else if (70 <= kor_score && kor_score <= 79) {
				System.out.printf("입력한 %d점은 성적 C입니다.\n", kor_score);
			} else if (80 <= kor_score && kor_score <= 89) {
				System.out.printf("입력한 %d점은 성적 B입니다.\n", kor_score);
			} else if (90 <= kor_score && kor_score <= 100) {
				System.out.printf("입력한 %d점은 성적 A입니다.\n", kor_score);
			}
		} else {
			System.out.println("점수가 올바르지 않습니다. 0~100사이의 값을 입력하시오.");
		}
		
		/* 다중 if문 방식으로 하면 복잡해진다
		  
		  		if (kor_score >= 0 && kor_score <= 100) {
			if (kor_score >= 60) {
				if (kor_score >= 70) {
					if (kor_score >= 80) {
						if (kor_score >= 90) {
							System.out.printf("입력한 %d점은 성적 A입니다.\n", kor_score); 
						} else {
							System.out.printf("입력한 %d점은 성적 B입니다.\n", kor_score); 
						}
					} else {
						System.out.printf("입력한 %d점은 성적 C입니다.\n", kor_score); 
					}
				} else {
					System.out.printf("입력한 %d점은 성적 D입니다.\n", kor_score); 
				}
			} else {
				System.out.printf("입력한 %d점은 성적 F입니다.\n", kor_score); 
			}
			
		} else {
			System.out.println("점수가 올바르지 않습니다. 0~100사이의 값을 입력하시오.");
		}
		  
		 */
		
		
		
	}

}
