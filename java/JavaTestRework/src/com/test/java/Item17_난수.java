package com.test.java;

public class Item17_난수 {
	
	public static void main(String[] args) {
		
		//[SUMMARY] 난수 (2022. 3. 23. 오후 10:37:41)
		
		/*
				Math.random() > 소수 값이 나온다
		*/
		
			int num = (int)(Math.random() * 10)  +1;
			// * 내가 원하는 수까지 / +1 < 하지 않으면 0 ~ 9까지의 값이 나오지 않는다.
			
	}

}
