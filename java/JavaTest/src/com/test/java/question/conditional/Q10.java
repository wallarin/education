package com.test.java.question.conditional;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Q10 {
	
	public static void main(String[] args) throws Exception {
		
		/*
		 캘린더 사용

		요구사항] 날짜를 입력받아 아래의 조건에 맞게 결과를 출력하시오.

		조건..
		입력받은 날짜가 평일이면 해당 주의 토요일을 알아낸다.
		입력받은 날짜가 일요일이면 아무것도 안한다.
		입력..
		년 : 2022 

		월 : 3 

		일 : 14 

		출력..
		입력하신 날짜는 '평일'입니다.
		해당 주의 토요일로 이동합니다.
		이동한 날짜는 '2022-03-19' 입니다.
		
		입력..
		년 : 2022 

		월 : 3 

		일 : 6 

		출력..
		입력하신 날짜는 '휴일'입니다.
		결과가 없습니다.

		*/
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("년 : ");
		int input_Year = Integer.parseInt(reader.readLine());
		
		System.out.print("월 : ");
		int input_Month = Integer.parseInt(reader.readLine());
		
		System.out.print("일 : ");
		int input_Date = Integer.parseInt(reader.readLine());
		
		Calendar hollyday = Calendar.getInstance();
		hollyday.set(input_Year, input_Month - 1, input_Date);
		
		if (hollyday.get(Calendar.DAY_OF_WEEK) > 1 && hollyday.get(Calendar.DAY_OF_WEEK) < 7) {
			System.out.println("입력하신 날짜는 '평일'입니다.");
			System.out.println("해당 주의 토요일로 이동합니다.");
			
			input_Date += 7 - hollyday.get(Calendar.DAY_OF_WEEK);
			//hollyday.set(input_Year, input_Month - 1, input_Date);
			hollyday.add(Calendar.DATE, input_Date);
			System.out.printf("이동한 날짜는 '%tF' 입니다.\n", hollyday);
			
		} else if (hollyday.get(Calendar.DAY_OF_WEEK) == 7) {
			System.out.println("입력하신 날짜는 토요일입니다.");
		} else {
			System.out.println("입력하신 날짜는 일요일입니다.");
			System.out.println("결과가 없습니다.");
		}
		
	}

}
