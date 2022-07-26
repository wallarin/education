package com.test.java.question.datetime;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q06 {

	public static void main(String[] args) throws Exception {

		/*
		
		요구사항] 여러 배달 음식을 같은 시간에 받기를 원하는 고객이 있다. 고객이 각각의 매장에 몇시에 전화를 해야 모든 음식을 같은 시간에 받을 수 있는지 알려주시오.
		
		조건..
		전화를 걸면 짜장면은 10분 뒤에 도착합니다.
		전화를 걸면 치킨은 18분 뒤 도착합니다.
		전화를 걸면 피자는 25분 뒤 도착합니다.
		음식을 받기 원하는 시간은 오후 11시 이전에만 가능합니다.(날짜 변경 금지)
		입력..
		음식을 받기 원하는 시각
		
		시 : 14 
		
		분 : 1 
		
		출력..
		짜장면 : 13시 51분
		치킨 : 13시 43분
		피자 : 13시 36분
		
		*/
		System.out.println("음식을 받기 원하는 시각\n");

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("시 : ");
		int hour = Integer.parseInt(reader.readLine());

		System.out.print("\n분 : ");
		int min = Integer.parseInt(reader.readLine());

		delivery(hour, min);

	}

	private static void delivery(int hour, int min) {

		int d_Min = min;
		d_Min -= 10;
		
		int d_Hour = hour < 23 ? hour - (d_Min / 60 < 1 ? hour - (hour - 1) : 0) : 'N';
		d_Min = d_Min % 60 + 60;
		System.out.printf("짜장면 : %d시 %d분\n", d_Hour, d_Min);

		d_Min = min;
		d_Min -= 18;

		d_Hour = hour < 23 ? hour - (d_Min / 60 < 1 ? hour - (hour - 1) : 0) : -1;
		d_Min = d_Min % 60 + 60;
		System.out.printf("치킨 : %d시 %d분\n", d_Hour, d_Min);

		d_Min = min;
		d_Min -= 25;

		d_Hour = hour < 23 ? hour - (d_Min / 60 < 1 ? hour - (hour - 1) : 0) : -1;
		d_Min = d_Min % 60 + 60;
		System.out.printf("피자 : %d시 %d분\n", d_Hour, d_Min);

	}

}
