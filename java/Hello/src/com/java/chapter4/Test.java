package com.java.chapter4;

public class Test {
	
	public static void main(String[] args) {
		/*
		 내가 풀어본 방식
		int sum = 0;
		int result = 0;
		
		for(int i=1; sum<100; i++) {
			if (i%2==0) {
				result = -i;
				sum += result;
			} else {
				sum += i;
			}
			
			if (sum >= 100) {
				System.out.println(i);
			}
		}
		System.out.println(sum);
		*/
		
		int sum = 0;
		int s = 1;
		int num = 0;
		
		for(int i=1; true; i++, s=-s) {
			num = s * i;
			sum += num;
			
			if(sum >= 100)
				break;
		}
		
		System.out.println(num);
		System.out.println(sum);
	}

}
