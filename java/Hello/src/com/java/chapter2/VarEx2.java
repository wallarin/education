package com.java.chapter2;

public class VarEx2 {
	
	public static void main(String[] args) {
		
		int x = 10, y = 20;
		int tmp = x;
		
		System.out.println("x:"+ x + " y:" + y);
		
		x = y;
		y = tmp;
		
		System.out.println("x:"+ x + " y:" + y);
		
		
	}

}
