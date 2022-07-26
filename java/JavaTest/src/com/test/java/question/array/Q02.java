package com.test.java.question.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q02 {

	public static void main(String[] args) throws Exception {

		/*
		
		요구사항] 학생의 이름을 N개 입력받아 아래와 같이 출력하시오.
		
		조건..
		이름을 오름차순 정렬하시오.
		입력..
		학생 수 : 6 
		
		학생명 : 홍길동 
		
		학생명 : 아무개 
		
		학생명 : 하하하 
		
		학생명 : 호호호 
		
		학생명 : 후후후 
		
		학생명 : 헤헤헤 
		
		출력..
		입력한 학생은 총 6명입니다.
		1. 아무개
		2. 하하하
		3. 헤헤헤
		4. 호호호
		5. 홍길동
		6. 후후후
		
		*/

		// 학생 수를 입력받음
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.printf("학생 수 : ");
		int input = Integer.parseInt(reader.readLine());

		// 입력받은 학생 수의 배열을 생성
		String[] student = new String[input];

		// 학생의 이름을 입력받아 학생 수만큼의 생성한 배열 안에 누적
		for (int i = 0; i < student.length; i++) {
			System.out.print("학생명 : ");
			String stuName = reader.readLine();

			student[i] = stuName;

		}

		// 이름 오름차순
		for (int i = 0; i < student.length - 1; i++) {

			for (int j = 0; j < student.length - i - 1; j++) {

				if (student[j].compareTo(student[j + 1]) > 0) { //.charAt(k) //else if(student[j].charAt(k) < student[j + 1].charAt(k)) {break;} 있어야 실행가능

					String temp = student[j];
					student[j] = student[j + 1];
					student[j + 1] = temp;

				}

			}
		}

		// 학생 수, 학생명 출력
		System.out.printf("입력한 학생은 총 %d명입니다.\n", input);

		for (int j = 0; j < student.length; j++) {

			System.out.printf("%d. %s\n", j + 1, student[j]);

		}

	}

}


