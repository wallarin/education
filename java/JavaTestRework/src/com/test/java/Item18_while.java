package com.test.java;

public class Item18_while {
	
	public static void main(String[] args) {
		
		//[SUMMARY] while문 (2022. 3. 23. 오후 10:41:06)
		
		/*
		
			for문과 달리 
			
			초기식 은 외부에 생성된다.
			
			while(조건문/boolean) {
				실행문;
				증감식;
			}
		
		
		*/
		
		int num = 1;
		
		while (num < 11) {
			System.out.println(num);
			num++;
		}
	
	}

}
