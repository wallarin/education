package com.test.java.question.overloading;

public class Q01 {

	public static void main(String[] args) {

		/*
		요구사항] 인자로 받은 숫자들의 합을 구하는 메소드를 선언하시오.
		
		조건..
		void sum(int)
		void sum(int, int)
		void sum(int, int, int)
		void sum(int, int, int, int)
		void sum(int, int, int, int, int)
		
		호출..
		sum(10);
		sum(10, 20);
		sum(10, 20, 30);
		sum(10, 20, 30, 40);
		sum(10, 20, 30, 40, 50);
		
		출력..
		10 = 10
		10 + 20 = 30
		10 + 20 + 30 = 60
		10 + 20 + 30 + 40 = 100
		10 + 20 + 30 + 40 + 50 = 150
		*/

		sum(10);
		sum(10, 20);
		sum(10, 20, 30);
		sum(10, 20, 30, 40);
		sum(10, 20, 30, 40, 50);

	}

	public static void sum(int i, int j, int k, int l, int m) {
		System.out.printf("%d + %d + %d + %d + %d = %d\n", i, j, k, l, m, i + j + k + l + m);
	}

	public static void sum(int i, int j, int k, int l) {
		System.out.printf("%d + %d + %d + %d = %d\n", i, j, k, l, i + j + k + l);
	}

	public static void sum(int i, int j, int k) {
		System.out.printf("%d + %d + %d = %d\n", i, j, k, i + j + k);
	}

	public static void sum(int i, int j) {
		System.out.printf("%d + %d = %d\n", i, j, i + j);
	}

	public static void sum(int i) {
		System.out.printf("%d = %d\n", i, i);
	}

}
