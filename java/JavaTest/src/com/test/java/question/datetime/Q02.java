package com.test.java.question.datetime;

import java.util.Calendar;

public class Q02 {
	
	public static void main(String[] args) {
		
		/*

		요구사항] 오늘 태어난 아이의 백일과 첫돌을 출력하시오.

		출력..
		백일: 2022-06-23
		첫돌: 2023-03-15

		*/
		
		birthday();
		
	}

	private static void birthday() {
		
		Calendar birth = Calendar.getInstance();
		birth.add(Calendar.DATE, 100);
		
		System.out.printf("백일 : %tF\n", birth);
		
		birth = Calendar.getInstance();
		birth.add(Calendar.YEAR, 1);
		
		System.out.printf("첫돌 : %tF\n", birth);
		
	}

}
