package com.test.java.question.multifor;

public class Q07 {
	
	public static void main(String[] args) {
		
		/*

			요구사항] 1부터 100사이의 완전수를 구하시오.

			조건..
			완전수: 자기 자신을 제외한 나머지 약수들의 합이 자신과 동일한 수
			약수: 어떤 수나 식을 나누어 나머지가 없이 떨어지는 수
			출력..
			6 = [1, 2, 3]
			28 = [1, 2, 4, 7, 14]
	
		*/
		
		String result = "";//최종결과를 담을 문자열 생성
		for(int i=1; i<=100; i++) {
			String tmp = "";//식을 담을 문자열 생성
			int sum = 0; //돌때마다 합을 초기화하기위해 for문 안에 생성
			
			for(int j=1; j<i; j++) {
				if(i % j == 0) { //약수 구하기
					sum += j; //자기 자신을 뺀 나머지 수를 더한다
					tmp += j + " "; //약수마다 식에 저장한다.
				}
			}
			if(i == sum) {
				result += i + " = [" + tmp + "]\n";
			}
		}
		System.out.println(result);
	}//main
}
