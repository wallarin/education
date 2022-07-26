package com.test.java.question.multifor;

public class Q11 {
	
	public static void main(String[] args) {
		
		/*
		
		요구사항] 아래와 같이 출력하시오.

		조건..
		마지막 숫자가 100이 넘기 전까지 출력하시오.
		출력..
		1 + 2 + 4 + 7 + 11 + 16 + 22 + 29 + 37 + 46 + 56 + 67 + 79 + 92 = 469
		
		*/
		int num = 1;
		int n = 1;
		int sum = 0;
		String result = "";
		
		for(int i=1; num < 100; i++) {
			result += num + " + ";
			sum += num;
			num += i;
		}
	
		
		System.out.printf("%s = %d", result + "\b\b", sum);
	}

}
