package com.test.java.question.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q07 {

	public static void main(String[] args) throws Exception {

		/*
		
		요구사항] 배열에 요소를 삽입하시오.
		
		조건..
		배열 길이: 10
		마지막 요소는 우측으로 옮겨질 공간이 없으면 삭제된다.
		입력..
		삽입 위치 : 2 
		
		값 : 100 
		
		출력..
		원본 : [5, 6, 1, 3, 2, 0, 0, 0, 0, 0]
		결과 : [5, 6, 100, 1, 3, 2, 0, 0, 0, 0]
		
		입력..
		삽입 위치 : 5 
		
		값 : 100 
		
		출력..
		원본 : [5, 6, 1, 3, 2, 8, 7, 4, 10, 9]
		결과 : [5, 6, 1, 3, 2, 100, 8, 7, 4, 10]
		
		*/
		int[] num = {5, 6, 1, 3, 2, 0, 0, 0, 0, 0};
		//int[] num = {5, 6, 1, 3, 2, 8, 7, 4, 10, 9};


		System.out.print("삽입 위치 : ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int insert = Integer.parseInt(reader.readLine());

		System.out.print("값 : ");
		int insertNum = Integer.parseInt(reader.readLine());

		//삽입전 원본
		System.out.println(Arrays.toString(num));

		//배열 길이부터 시작해 배열[0]이 아니면 [8]의 값을 [9]에 저장한다 배열[0]에 삽입될때에는 [0]에 삽입값을 넣어준다.
		for (int i = num.length-1; i >= 0; i--) { //i > insert; --> 기준값을 바꾸면 if 필요없을지도??
			if (i != 0) {
			num[i] = num[i - 1];
			} else if (i == 0) {
				num[0] = insertNum;
			}
			
			//넣으려는 위치에 i가 도달하면 값을 넣고 break를 통해 for문을 탈출한다.
			if (i == insert) {
				num[i] = insertNum;
				break;
			}
		}
		System.out.println(Arrays.toString(num));
	}//main


}


