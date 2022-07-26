package com.test.java.question.method;

public class Q03 {
	
	public static void main(String[] args) {
		
		/*
		요구사항] 숫자 1개를 전달하면 4자리로 출력하는 메소드를 선언하시오.
		
		조건..
		void digit(int num)
		입력한 숫자가 4자리 이상이면 그대로 출력한다.
		
		호출..
		digit(1);
		digit(12);
		digit(321);
		digit(5678);
		digit(98765);
		
		출력..
		1 → 0001
		12 → 0012
		321 → 0321
		5678 → 5678
		98765 → 98765
		
		--프로세스
		1. digit 메소드 생성 후 입력받은 값 -> 4자리값 으로 만드는데 빈자리라면 0으로 채워넣는 출력라인 생성
		2. main 메소드에서 digit 메소드를 호출해 값을 입력후 출력
		
		*/
		
		digit(1);
		digit(12);
		digit(321);
		digit(5678);
		digit(98765);
		
	}
	
	public static void digit(int num) {
		
		System.out.printf("%d → %04d\n", num, num);
		
		//String result = num > 10 ? num > 100 ? num > 1000 ? "" + num : "0" + num : "00" + num : "000" + num;
		
		//System.out.printf("%d → %s\n", num, result);
		
	}

}
