package com.java.chapter3;

public class OperatorEx10 {
	
	public static void main(String[] args) {
		
		int a = 1000000;
		
		int result1 = a * a / a; // 1000000000000(X) > -727379968 오버플로우 발생!! / 1000000 = 1000000(X) > -727
		int result2 = a / a * a; // 1 * 100000 = 1000000
		
		System.out.printf("%d * %d / %d = %d\n", a, a, a, result1);
		System.out.printf("%d / %d * %d = %d\n", a, a, a, result2);
		
	}

}
