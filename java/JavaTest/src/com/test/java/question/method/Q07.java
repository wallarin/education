package com.test.java.question.method;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q07 {
	
	public static void main(String[] args) throws Exception {
		
		/*
		요구사항] 지하철 탑승 소요 시간을 구하시오. 지나가는 역의 개수, 환승역의 횟수, 시간대를 전달 받아 총 걸리는 시간을 반환하는 메소드를 선언하시오.
		
		조건..
		int getTime(int station, int change, int time)
		각 역간 소요 시간 : 2분 소요
		환승 소요 시간 : N분 소요
		시간대에 따라 환승 소요 시간이 다르다.
		평상시: 3분
		출근시: 4분
		퇴근시: 5분
		
		입력..
		역의 개수 : 15 
		
		환승역의 횟수 : 1 
		
		시간대(1.평상시, 2.출근시, 3.퇴근시): 1 
		
		출력..
		총 소요 시간은 33분입니다.
		
		입력..
		역의 개수 : 22 
		
		환승역의 횟수 : 2 
		
		시간대(1.평상시, 2.출근시, 3.퇴근시): 3 
		
		출력..
		총 소요 시간은 54분입니다.
		
		--프로세스
		1. 3개의 정수값을 받는 getTime 메소드를 생성한다.
		2. 조건식을 이용해 시간대별 환승시간의 값을 구한 뒤 역의 이동간의 소요시간과 합해준다.
		3. main메소드에서 BufferedReader를 선언해 값을 입력받아 입력받은 값을 int형으로 변환한다.
		4. getTime 메소드를 호출해 입력받은 값을 전달하도록 설정 후 그 결과값을 출력한다.
		*/
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("역의 개수 : ");
		String input = reader.readLine();
		int station = Integer.parseInt(input);
		
		System.out.print("환승역의 횟수 : ");
		String input2 = reader.readLine();
		int change = Integer.parseInt(input2);
		
		System.out.print("시간대(1.평상시, 2.출근시, 3.퇴근시): ");
		String input3 = reader.readLine();
		int time = Integer.parseInt(input3);
		
		int subway = getTime(station, change, time);
		
		System.out.printf("총 소요 시간은 %d분입니다.", subway);
		
	}
	
	public static int getTime(int station, int change, int time) {
		
		int result = time > 0 && time < 4 ? 
				  time == 1 ? change * 3 
				: time == 2 ? change * 4 
				: time == 3 ? change * 5 
				: 99999 : 99999; // null 값을 넣을 수 있다.
		
		int result2 = (station * 2) + result;
		
		return result2;
		
	}

}
