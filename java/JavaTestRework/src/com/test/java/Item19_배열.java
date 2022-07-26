package com.test.java;

import java.util.Arrays;

public class Item19_배열 {
	
	public static void main(String[] args) {
		
		//[SUMMARY] array (2022. 3. 23. 오후 10:58:36)
		
		/*
			배열
			- 같은 자료형을 여러개 저장할 수 있다.
			
			
			name[0].charAt(0) > name[0]의 첫번째 글자 추출
			System.out.println(Arrays.toString(값)); > 배열의 상태를 확인한다.
			
			
			변수명.length > 변수의 길이를 알려준다.
			
			int[] 변수이름 = new int[원하는 변수의 길이]
			
			int [][] 변수이름 = new int [][] < 2차원 배열 생성
		
		*/
		
		//버블 정렬!!
		
		int[] nums = {5, 3, 1, 4, 2};

		System.out.println(Arrays.toString(nums)); // 정렬 전

		for (int i = 0; i < nums.length - 1; i++) { // N Cycle

			for (int j = 0; j < nums.length - i - 1; j++) { // N step

				if (nums[j] > nums[j + 1]) { // 오름차순 정렬
					// if (nums[j] < nums[j+1]) { //내림차순 정렬
					int temp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = temp;

				}

			}

		}

		System.out.println(Arrays.toString(nums)); // 정렬 후
		
		//Arrays.sort(name); < 손쉬운 정렬이 가능하지만 때로는 버블 정렬이 더 빠를 때도 있다.
	}

}
