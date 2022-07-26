package com.test.java.question.iteration;

public class Q08 {

	public static void main(String[] args) {

		/*
		 
		요구사항] 서기 1년 1월 1일부터 오늘까지 며칠째인지 합을 구하시오.
		
		조건..
		Calendar 클래스 사용 금지
		출력..
		2022년 3월 16일은 738,230일째 되는 날이고 수요일입니다.
		
		 */

		int year = 2022, month = 3, date = 16, sum = 0;

		for (int i = 1; i < year; i++) {
			if (i % 4 == 0) {
				if (i % 100 == 0) {
					if (i % 400 == 0) {
						sum += 366;
					} else {
						sum += 365;
					}
				} else {
					sum += 366;
				}
			} else {
				sum += 365;
			}
		}
		for (int i=1; i <= month-1; i++) {
			switch (month) {
				case 1:
				case 3:
				case 5:
				case 7:
				case 8:
				case 10:
				case 12:
					sum += 30;
					break;
				case 2:
					sum += 27;
					break;
				case 4:
				case 6:
				case 9:
				case 11:
					sum += 29;
					break;
			}
		}
		String day = getDay(date);
		System.out.printf("%d년 %d월 %d일은 %,d일째 되는 날이고 %s요일입니다.", year, month, date, sum + date -1, day);

	}//main
	
	public static String getDay (int date) {
			
			if (date % 7 == 1) {
				return "화";
			} else if (date % 7 == 2 ) {
				return "수";
			} else if (date % 7 == 3 ) {
				return "목";
			} else if (date % 7 == 4 ) {
				return "금";
			} else if (date % 7 == 5 ) {
				return "토";
			} else if (date % 7 == 6 ) {
				return "일";
			} else {
				return "월";
			}
	}
}
