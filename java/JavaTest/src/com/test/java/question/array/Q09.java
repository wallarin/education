package com.test.java.question.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q09 {

	public static void main(String[] args) throws Exception {

		/*
		
		요구사항] 배열의 요소를 순차적으로 2개씩 더한 결과를 배열로 생성한 뒤 출력하시오.
		
		조건..
		원본 배열 길이: 사용자 입력
		원본 배열 요소: 난수(1~9)
		결과 배열 길이: 사용자 입력 / 2
		입력..
		배열 길이: 10 
		
		출력..
		원본 : [ 1, 5, 3, 6, 2, 7, 8, 2, 2, 9 ]
		결과 : [ 6, 9, 9, 10, 11 ]
		입력..
		배열 길이: 4 
		
		출력..
		원본 : [ 5, 3, 9, 1 ]
		결과 : [ 8, 10 ]
		입력..
		배열 길이: 5 
		
		출력..
		원본 : [ 1, 5, 3, 2, 7 ]
		결과 : [ 6, 5, 7 ]
		
		*/
		int n = 1;

		System.out.print("배열 길이 : ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(reader.readLine());

		int[] random = new int[input];
		
		
		//난수 1~9 생성 후 원본 출력
		for (int i = 0; i < random.length; i++) {
			random[i] = (int) (Math.random() * 9) + 1;
		}
		System.out.println(Arrays.toString(random));

		//Math.round 함수를 이용해 소수점을 반올림 해주고 새로운 배열을 생성한다.
		//double num = Math.round(input / 2.0);

		double oo = Math.round(5 / 2);
		System.out.println(oo);
		
		int[] result = new int[(int)Math.round(input / 2.0)]; //int로 형변환이 되어야 새로운 배열이 생성된다.

		//배열 길이가 짝수일때
		if (input % 2 == 0) {

			for (int i = 0; i < result.length; i++) {
				
				//i가 0일때 먼저 절반값인 배열에 값을 넣어준다.
				if (i == 0) {
					result[i] = random[i] + random[i + 1];
				} else {
					//절반 배열값에 제대로 된 값을 넣기 위해 i는 건드릴 수 없어 정수를 생성해 i값에 정수 n을 더해주고 완료후 n을 증가시켜준다.
					result[i] = random[i + n] + random[i + n + 1];
					n++;

				}
			}
		}
		//배열 길이가 홀수일때
		if (input % 2 == 1) {
			//배열의 마지막값을 제외하고 짝수일때와 같이 값을 넣어준다.
			for (int i = 0; i < result.length-1; i++) {

				if (i == 0) {
					result[i] = random[i] + random[i + 1];
				} else {
					result[i] = random[i + n] + random[i + n + 1];
					n++;
				}
			
			}
			//마지막 배열 값은 원형 배열 마지막값을 절반 배열 마지막값에 넣어준다.
			result[result.length-1] = random[random.length-1];
			
		}
		System.out.println(Arrays.toString(result));

	}

}
