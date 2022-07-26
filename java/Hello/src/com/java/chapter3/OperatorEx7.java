package com.java.chapter3;

public class OperatorEx7 {
	
	public static void main(String[] args) {
		
		byte a = 10;
		byte b = 30;
		byte c = (byte)(a * b); //원래 300이지만 byte의 표현 범위를 넘어서서 값이 달라졌다.
		System.out.println(c);
		
	}

}
