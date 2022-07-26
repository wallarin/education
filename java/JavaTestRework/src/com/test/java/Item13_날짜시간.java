package com.test.java;

import java.util.Calendar;

public class Item13_날짜시간 {
	
	public static void main(String[] args) {
		
		//[SUMMARY] 날짜 시간 (2022. 3. 23. 오후 10:12:50)
		
		/*
		
			Calendar 클래스
			
			Calendar c1 = Calendar.getInstance(); < 현재 시각을 얻어오기
			
			System.out.println(c1.get(Calendar.YEAR)); //2022. 년도
			System.out.println(c1.get(Calendar.MONTH)); //2. 월(0~11)
			> 현재 우리가 사용하는 월로 표시하려면 +1 해주어야 한다.
			System.out.println(c1.get(Calendar.DATE)); //14. 날짜(일)
			System.out.println(c1.get(Calendar.HOUR)); //5. 시(12H)
			System.out.println(c1.get(Calendar.HOUR_OF_DAY)); //17. 시(24H)
			System.out.println(c1.get(Calendar.MINUTE)); //23. 분
			System.out.println(c1.get(Calendar.SECOND)); //22. 초
			
			System.out.println(c1.get(Calendar.MILLISECOND)); //251. 밀리초(1/1000)
			System.out.println(c1.get(Calendar.AM_PM)); //1. 오전(0), 오후(1)
			
			System.out.println(c1.get(Calendar.DAY_OF_YEAR)); //73. 일(현재년도의 며칠)
			System.out.println(c1.get(Calendar.DAY_OF_MONTH)); //14. 일(현재 달의 일)
			System.out.println(c1.get(Calendar.DAY_OF_WEEK)); //2. 일(요일) 1(일요일) ~ 7(토요일)
			
			System.out.println(c1.get(Calendar.WEEK_OF_YEAR)); //12. 주
			System.out.println(c1.get(Calendar.WEEK_OF_MONTH)); //3. 주
			
		
		*/
	}

}
