package com.java.chapter3;

public class OperatorEx8 {
	
	public static void main(String[] args) {
		
		int a = 1_000_000;
		int b = 2_000_000;
		
		long c = a * b; // 이미 int형의 값으로 값을 곱한뒤라 long형에 담아도 예상한 값이 출력이 되지 않는다.
		
		System.out.println(c);
		
	}

}
