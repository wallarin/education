package com.test.java.question.datetime;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Q05 {
	
	public static void main(String[] args) throws Exception {
		
		/*

		요구사항] 아빠와 딸의 생일을 입력받아 아빠가 딸보다 며칠을 더 살았는지 출력하시오.

		입력..
		아빠 생일(년) : 1969 

		아빠 생일(월) : 5 

		아빠 생일(일) : 10 

		딸 생일(년) : 1997 

		딸 생일(월) : 7 

		딸 생일(일) : 22 

		출력..
		아빠는 딸보다 총 10,300일을 더 살았습니다.

		*/
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("아빠 생일(년) : ");
		int dad_year = Integer.parseInt(reader.readLine());
		
		System.out.print("아빠 생일(월) : ");
		int dad_month = Integer.parseInt(reader.readLine());
		
		System.out.print("아빠 생일(일) : ");
		int dad_date = Integer.parseInt(reader.readLine());
		
		System.out.print("딸 생일(년) : ");
		int daughter_year = Integer.parseInt(reader.readLine());
		
		System.out.print("딸 생일(월) : ");
		int daughter_month = Integer.parseInt(reader.readLine());
		
		System.out.print("딸 생일(일) : ");
		int daughter_date = Integer.parseInt(reader.readLine());
		
		
		old(dad_year, dad_month, dad_date, daughter_year, daughter_month, daughter_date);
		
	}

	private static void old(int dad_year, int dad_month, int dad_date, int daughter_year,
			int daughter_month, int daughter_date) {
		
		Calendar dad = Calendar.getInstance();
		dad.set(dad_year, dad_month, dad_date);
		dad.getTimeInMillis();
		
		
		Calendar daughter = Calendar.getInstance();
		daughter.set(daughter_year, daughter_month, daughter_date);
		daughter.getTimeInMillis();
		
		long dayTick = (daughter.getTimeInMillis() - dad.getTimeInMillis()) / 1000 / 60 / 60 / 24;
		
		System.out.printf("아빠는 딸보다 총 %,d일을 더 살았습니다.", dayTick);
		
	}

}
