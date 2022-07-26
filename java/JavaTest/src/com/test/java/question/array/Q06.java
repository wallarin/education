package com.test.java.question.array;

import java.util.Arrays;

public class Q06 {

	public static void main(String[] args) {

		/*
		
		요구사항] 중복되지 않는 임의의 숫자 6개를 만드시오.(로또)
		
		조건..
		숫자의 범위 : 1 ~ 45
		오름차순 정렬
		출력..
		[1, 5, 23, 36, 37, 41]
		
		*/
		
		long begin = System.nanoTime();

		int[] lotto = new int[6];

		// 1부터 45까지의 랜덤수 배정
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = (int) (Math.random() * 45) + 1;

			// 난수 생성중에 1번째 배열값과 0번째 배열값이 같으면 1번째 배열값을 -1 해준뒤 for문을 빠져나가 +1이 돼 다시 1번째 배열값을
			// 생성한다.
			for (int j = 0; j < i; j++) {
				if (lotto[i] == lotto[j]) {
					i--;
				}
			}
		}

		// 배열 오름차순
		//Arrays.sort(lotto); //정렬 가능
		for (int i = 0; i < lotto.length - 1; i++) {

			for (int j = 0; j < lotto.length - i - 1; j++) {

				if (lotto[j] > lotto[j + 1]) {
					int temp = lotto[j];
					lotto[j] = lotto[j + 1];
					lotto[j + 1] = temp;
				}
			}
		}

		// 정렬 후
		System.out.println(Arrays.toString(lotto));
		
		long end = System.nanoTime();
		
		System.out.println(end - begin);

	}

}
