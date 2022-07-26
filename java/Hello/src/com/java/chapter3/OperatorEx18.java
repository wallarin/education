package com.java.chapter3;

public class OperatorEx18 {
	
	public static void main(String[] args) {
		
		double pi = 3.141592;
		double shortPi = Math.round(pi * 1000) / 1000.0; //Math.round 는 소숫점 첫째자리에서 반올림 후 정수값으로 결과를 돌려준다.
		System.out.println(shortPi);
		
	}

}
