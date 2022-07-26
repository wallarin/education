package com.test.java.question.conditional;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q08 {

	public static void main(String[] args) throws Exception {
		
		/*
		 
		 캘린더 or int(** 더 쉬움)
	
		요구사항] 주차 요금을 계산하시오.
	
		조건..
		무료 주차 : 30분
		초과 10분당 : 2,000원
		입력..
		[들어온 시간]
	
		시 : 13 
	
		분 : 30 
	
	
		[나간 시간]
	
		시 : 14 
	
		분 : 20 
	
		출력..
		주차 요금은 4,000원입니다.
	
		*/
		
		System.out.println("[들어온 시간(24H)]");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));		
		System.out.print("시 : ");
		int come_Hour = Integer.parseInt(reader.readLine());
		
		System.out.print("분 : ");
		int come_Min = Integer.parseInt(reader.readLine());
		
		System.out.println("[나간 시간(24H)]");
		System.out.print("시 : ");
		int out_Hour = Integer.parseInt(reader.readLine());
		
		System.out.print("분 : ");
		int out_Min = Integer.parseInt(reader.readLine());
		
		if (come_Hour >= 0 && come_Hour <= 24) {
			if (out_Hour >= 0 && out_Hour <= 24) {
				if (come_Min >= 0 && come_Min <= 60) {
					if(out_Min >= 0 && out_Min <= 60) { // 1분 초과시 2000원 부과
						int pee = (((out_Hour - come_Hour) * 60) - (come_Min - out_Min) - 30) / 10 * 2000;
						System.out.printf("주차 요금은 %,d원 입니다.", pee);
					} else {
						System.out.println("나간 시간중 (분)을 잘못 입력했습니다.");
					}
				} else {
					System.out.println("들어온 시간중 (분)을 잘못 입력했습니다.");
				}
				
			} else {
				System.out.println("나간 시간을 잘못 입력했습니다.");
			}			
		} else {
			System.out.println("들어온 시간을 잘못 입력했습니다.");
		}
	}

}
