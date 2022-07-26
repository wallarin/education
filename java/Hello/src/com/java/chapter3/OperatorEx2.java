package com.java.chapter3;

public class OperatorEx2 {

	public static void main(String[] args) {
		
		int i = 5, j = 0;
		
		j = i++; //i의 값을 저장 후 증가시킨다.
		System.out.println("j=i++; 실행 후, i=" + i + ", j=" + j);
		
		i=5;
		j=0;
		
		j=++i; //i의 값을 먼저 증가 시킨 후 저장한다.
		System.out.println("j=++i; 실행 후, i=" + i + ", j="+ j);
		
	}
	
}
