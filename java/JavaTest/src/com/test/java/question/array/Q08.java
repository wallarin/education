package com.test.java.question.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q08 {
	
	public static void main(String[] args) throws Exception {
		
		/*

		요구사항] 배열의 요소를 삭제하시오.

		조건..
		배열 길이: 10
		마지막 요소는 0으로 채우시오.
		입력..
		삭제 위치 : 2 

		출력..
		원본 : [5, 6, 1, 3, 2, 0, 0, 0, 0, 0]
		결과 : [5, 6, 3, 2, 0, 0, 0, 0, 0, 0]
		입력..
		삭제 위치 : 5 

		출력..
		원본 : [5, 6, 1, 3, 2, 8, 7, 4, 10, 9]
		결과 : [5, 6, 1, 3, 2, 7, 4, 10, 9, 0]

		*/
		
		
		//int[] num = {5, 6, 1, 3, 2, 0, 0, 0, 0, 0};
		int[] num = {5, 6, 1, 3, 2, 8, 7, 4, 10, 9};
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


		System.out.print("삭제 위치 : ");
		int delete = Integer.parseInt(reader.readLine());

		//삭제전 원본
		System.out.println(Arrays.toString(num));
		
//		if (delete != num.length) {
//			//num[delete] = num[delete + 1];
//		} else if (delete == num.length) {
//			//num[num.length] = 0;
//		}
		if (delete < 10 && delete >= 0) {
		
		for (int i=delete; i<=num.length; i++) { //길이에서 -1을 하지 않아서 <= 사용 i<num.length - 1 로 교체가능
			if (i<num.length-1) { //i<num.length - 1 바뀌면 해당 구문 필요 X
			num[i] = num[i + 1];
			} 
		}
		
		num[num.length-1] = 0;
		
		System.out.println(Arrays.toString(num));
		} else {
			System.out.println("삭제 위치가 올바르지 않습니다. (0~9입력)");
		}
		
		
	}

}
