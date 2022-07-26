package com.java.chapter4;

public class Q5 {
	
	public static void main(String[] args) {
//		for(int i=0; i<=10; i++) {
//			for(int j=0; j<=i; j++)
//			System.out.print("*");
//			System.out.println();
//			}
		
		int i = 0;
		
		
		while (i <= 10) {
			int j = 0; //j를 안에서 초기화해야 이중 for문과 같은 역할을 한다.
			while (j <= i) {
				System.out.print("*");
				j++;
			}
			System.out.println();
			i++;
		}
	}

}
