package com.test.java.question.overloading;

public class Q03 {
	
	public static void main(String[] args) {
		
		/*
		요구사항] 인자로 받은 숫자들 중 양수의 갯수를 반환하는 메소드를 선언하시오.

		조건..
		int positive(int)
		int positive(int, int)
		int positive(int, int, int)
		int positive(int, int, int, int)
		int positive(int, int, int, int, int)
		호출..
		count = positive(10);
		count = positive(10, 20);
		count = positive(10, 20, -30);
		count = positive(10, 20, -30, 40);
		count = positive(10, 20, -30, 40, 50);
		출력..
		양수 : 1개
		양수 : 2개
		양수 : 2개
		양수 : 3개
		양수 : 4개
		
		--프로세스
		
		*/
		
		int count;
		
		count = positive(10);
		System.out.printf("양수 : %d개\n", count);
		
		count = positive(10, 20);
		System.out.printf("양수 : %d개\n", count);
		
		count = positive(10, 20, -30);
		System.out.printf("양수 : %d개\n", count);
		
		
		count = positive(10, 20, -30, 40);
		System.out.printf("양수 : %d개\n", count);
		
		
		count = positive(10, 20, -30, 40, 50);
		System.out.printf("양수 : %d개\n", count);
		
	}
	
	public static int positive(int i) {

		int count = 0;

		count += i > 0 ? 1 : 0;
		//count = num > 0 ? ++count : count;

		return count;

	}

	public static int positive(int i, int i2) { 

		int count = 0;

		count += i > 0 ? 1 : 0;
		count += i2 > 0 ? 1 : 0;

		return count;

	}

	public static int positive(int i, int i2, int i3) {

		int count = 0;

		count += i > 0 ? 1 : 0;
		count += i2 > 0 ? 1 : 0;
		count += i3 > 0 ? 1 : 0;

		return count;

	}

	public static int positive(int i, int i2, int i3, int i4) {

		int count = 0;

		count += i > 0 ? 1 : 0;
		count += i2 > 0 ? 1 : 0;
		count += i3 > 0 ? 1 : 0;
		count += i4 > 0 ? 1 : 0;

		return count;

	}

	public static int positive(int i, int i2, int i3, int i4, int i5) {

		int count = 0;
		
		count += i > 0 ? 1 : 0;
		count += i2 > 0 ? 1 : 0;
		count += i3 > 0 ? 1 : 0;
		count += i4 > 0 ? 1 : 0;
		count += i5 > 0 ? 1 : 0;
		
		return count;

	}

}
