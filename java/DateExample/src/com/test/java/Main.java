package com.test.java;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Main {
		
	public static void main(String[] args) {
		
		
		//일정 데이터
		Data.load();
		
		
		//달력
		int year = 2022;
		int month = 4;
		int date = 1;
		
		Calendar c = Calendar.getInstance();
		c.set(year, month-1, date); //2022-04-01
		
		int lastDate = c.getActualMaximum(Calendar.DATE); //마지막 날짜
		int firstDay = c.get(Calendar.DAY_OF_WEEK); //1일의 요일
		
		System.out.println("[일]\t[월]\t[화]\t[수]\t[목]\t[금]\t[토]");
		
		for (int i=1; i<firstDay; i++) {
			System.out.print("\t");
		}
		
		//달력 출력(한 주)
		for (int i=1; i<=lastDate; i++) {
			System.out.printf("%3d\t", i);
			
			if ((i + firstDay) % 7 == 1) {
				System.out.println();
				
				//일정 출력(한 주)
				//- 위에 출력된 날짜와 동일한 날짜를 다시 루프
				//- 같은 날짜를 가지는 데이터가 있으면 항목 출력
				for (int j=i+1-7; j<i+8-7 && j<=lastDate; j++) {
					System.out.printf("%s\t", getItem(String.format("%d-%02d-%02d", year, month, j)));
				}
				System.out.println();
				System.out.println();
			}
		}
		
	}

	private static Object getItem(String date) {
		
		for (Item item : Data.list) {
			if (item.getDate().equals(date)) {
				return item.getItem();
			}
		}
		
		return "";
	}

}









































