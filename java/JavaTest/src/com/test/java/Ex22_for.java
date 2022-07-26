package com.test.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Ex22_for {

	public static void main(String[] args) throws Exception {

		// Ex22_for.java

		/*
		
			반복문
			- 특정 코드를 개발자가 원하는 횟수만큼 반복 실행한다.
			- 생산성 향상 + 유지보수성 향상
			
			for (초기식; 조건식; 증감식) {
				실행문;
			}
		
		*/

		// m1();
		// m2();
		// m3();
		// m4();
		// m5();
		// m6();
		// m7();
		// m8();
		// m9();
		// m10();
		// m11();
		// m12();
		// m13();
		m14();


	} // main

	private static void m14() {

		// 달력 만들기

		// 1. 월의 마지막일
		// 2. 월의 1일의 요일

		int year = 2022;
		int month = 3;

		int lastDay = getLastDay(year, month);
		int dayOfWeek = getDayOfWeek(year, month);
		
		System.out.println("====================================================");
		System.out.printf("                     %d년 %d월\n", year, month);
		System.out.println("====================================================");
		System.out.println("[일]\t[월]\t[화]\t[수]\t[목]\t[금]\t[토]");
		System.out.println("====================================================");
		
		for (int i=0; i<dayOfWeek; i++) {
			System.out.print("\t");
		}
		
		for (int i=1; i<=lastDay; i++) {
			System.out.printf("%3d\t", i);
			
			//토요일 개행
			if ((i + dayOfWeek) % 7 == 0) {
				System.out.println();
			}
		}
	}

	private static int getDayOfWeek(int year, int month) {

		int total = 0;
		int date = 1;

		for (int i = 1; i < year; i++) {
			total += 365;

			if (isLeafYear(i)) { // 덩치가 크면 메소드를 따로 빼는게 좋다.
				total++;
			}
		}


		for (int i = 1; i < month; i++) {

			total += getLastDay(year, i);

		}

		total += date;

		return total % 7;
	}

	private static void m13() {

		// 서기 1년 1월 1일부터 오늘까지 며칠째인지 합을 구하시오.

		// 1년 = 365일

		int total = 0;
		int year = 2022;
		int month = 3;
		int date = 17;

		// 1년 1월 1일 ~ 2021년 12월 31일

		for (int i = 1; i < year; i++) {
			total += 365;

			if (isLeafYear(i)) { // 덩치가 크면 메소드를 따로 빼는게 좋다.
				total++;
			}
		}


		// 2022년 1월 1일 ~ 2022년 2월 28일
		for (int i = 1; i < month; i++) {

			total += getLastDay(year, i);

		}

		// 2022년 3월 1일 ~ 2022년 3월 17일
		total += date;

		// 특정 날짜의 요일? > 기준일 + 기준일 요일 + 기준일부터 특정 날짜의 날짜 합
		// System.out.println(total % 7);

		System.out.printf("%d년 %d월 %d일은 %,d일째 되는 날이고 %s요일입니다.\n", year, month, date, total,
				getDay(total));


	}

	private static int getLastDay(int year, int month) {

		switch (month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				return 31; // break 역할 겸함
			case 4:
			case 6:
			case 9:
			case 11:
				return 30;
			case 2:
				return isLeafYear(year) ? 29 : 28;
		}

		return 0;
	}

	public static boolean isLeafYear(int year) {

		if (year % 4 == 0) {

			if (year % 100 == 0) {

				if (year % 400 == 0) {
					return true;
				} else {
					return false;
				}

			} else {
				return true;
			}

		} else {
			return false;
		}

	}

	private static void m12() {

		// 수업은 들을만하고 이해는 되지만 문제는 어디서 감을 못잡는다. > 경험 부족..

		// 영어 공부 > 이해
		// 미국 사람.. > 대화X > 경험 부족..

		// 누적값이 1000을 넘어가는 순간 루프를 종료하시오.

		// 1. 누적 변수 생성
		// 2. 루프 생성
		// 2.1 값 누적
		// 2.2 값 출력
		// 2.3 조건 > 누적값 1000이상 > break
		// 3. 출력

		int sum = 0;

		for (int i = 1;; i++) {

			sum += i; // 2.1
			System.out.printf("%d + ", i); // 2.2

			if (sum > 1000) {
				break;
			}
		}

		System.out.printf("\b\b= %d\n", sum);
		// C:\class\java\JavaTest\bin>java.exe com.test.java.Ex22_for 콘솔창에서 출력하면 제대로 출력
	}

	private static void m11() {

		// 난수, Random
		// - 임의의 수
		// - 난수 생성기

		// 1. Math.random()
		// 2. Random 클래스

		// System.out.println(Math.random());

		// 1~10사이의 난수

		// A: 최소값
		// A+B-1 : 최대값
		// (int)(Math.random() * B) + A;

		for (int i = 0; i < 10; i++) {

			// int num = (int)(Math.random() * 10 + 1);

			int num = (int) (Math.random() * 7) + 3;

			System.out.println(num);

		}



	}

	private static void m10() {

		// 2022년 3월 1일 ~ 3월 31일까지 날짜 출력

		// 2022년 3월 1일 화요일 > 시작 날짜
		// 2022년 3월 2일 수요일
		// 2022년 3월 3일 목요일
		// ..
		// 2022년 3월 31일 목요일

		Calendar c1 = Calendar.getInstance();
		c1.set(2022, 1, 1); // 2022년 3월 1일

		// c1이 속하는 월의 최대값을 가져오라 > 마지막 날짜
		// System.out.println(c1.getActualMaximum(Calendar.DATE));

		int lastDay = c1.getActualMaximum(Calendar.DATE);

		for (int i = 1; i <= lastDay; i++) {

			System.out.printf("%d년 %02d월 %02d일 %tA\n", c1.get(Calendar.YEAR),
					c1.get(Calendar.MONTH) + 1, c1.get(Calendar.DATE), c1);

			c1.add(Calendar.DATE, 1);
		}

	}

	private static void m9() {

		// 2022년 3월 1일 ~ 3월 31일까지 날짜 출력
		// 2022년 3월 1일 화요일
		// 2022년 3월 2일 수요일
		// 2022년 3월 3일 목요일
		// ..
		// 2022년 3월 31일 목요일

		for (int date = 1; date <= 31; date++) {

			String day = getDay(date);

			System.out.printf("2022년 03월 %02d일 %s요일\n", date, day);
		}

	}

	// This method must return a result of type String > return문이 없음
	// 모든 경우에 return문이 존재해야 하는데 일부 경우에 return문이 존재하지 않는다.
	public static String getDay(int date) {

		if (date % 7 == 1) {
			return "월";
		} else if (date % 7 == 2) {
			return "화";
		} else if (date % 7 == 3) {
			return "수";
		} else if (date % 7 == 4) {
			return "목";
		} else if (date % 7 == 5) {
			return "금";
		} else if (date % 7 == 6) {
			return "토";
		} else {
			return "일";
		}

		// return X


		// return ""; //return null;

	}

	private static void m8() throws Exception {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int sum = 0;

		// 짝수만 누적

		for (;;) {

			System.out.print("숫자: ");

			int num = Integer.parseInt(reader.readLine());

			if (num == 0) {
				break;
			}

			// if (num % 2 == 1) {
			// continue;
			// }

			if (num % 2 == 0) {
				sum += num;
			}

		}

		System.out.println("최종 합: " + sum);

	}

	private static void m7() throws Exception {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		// 사용자 입력 숫자 > 누적 > 횟수 사용자 맘대로
		int sum = 0;

		for (;;) {

			System.out.print("숫자: ");

			int num = Integer.parseInt(reader.readLine());

			if (num == 0) {
				break;
			}

			sum += num;


		}

		System.out.println("최종 합: " + sum);

	}

	private static void m6() {

		// 무한 루프, Infinite Loop
		// for (int i=0; i<10; i--) { //21억 바퀴
		// System.out.println("안녕하세요." + 1);
		// }

		// 무한 루프 일부러 만들기
		// 무한 루프
		// for (;;) {
		// System.out.println("무한 루프");
		// }

		// 무한 루프 + 루프 변수 활용
		// for (int i=0; ; i++) {
		// System.out.println(i);
		// }

		for (int i = 0;; i++) {
			System.out.println(i);
			if (i > 100000) {
				break;
			}
		}


		// Unreachable code
		// 루프 탈출하는 방법
		for (int i = 1; i <= 10; i++) {

			System.out.println(i);

			if (i == 5) {
				break; // if문을 제외한 나머지 제어문을 탈출하는 역할
			}
		}

		System.out.println();

		for (int i = 1; i <= 10; i++) {

			if (i == 5) {
				continue; // 하던일을 멈추고 제어의 처음으로 돌아가세요.
			}
			System.out.println(i);
		}


	}

	private static void m5() throws Exception {

		// 구구단 출력

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("단 입력: ");
		int dan = Integer.parseInt(reader.readLine());

		// 5 x 1 = 5
		// 5 x 2 = 10
		// 5 x 3 = 15
		// ..
		// 5 x 9 = 45

		for (int i = 1; i <= 9; i++) {
			System.out.printf("%d x %d = %2d\n", dan, i, dan * i);
		}

	}

	private static void m4() throws Exception {

		// 요구사항] 사용자 숫자 입력 > x10번 입력 > 숫자의 합

		// 요구사항] 1~10까지의 합
		int sum = 0; // 누적 변수(반드시 0으로 초기화)


		for (int i = 1; i <= 10; i++) {
			sum = sum + i;
		}

		System.out.println(sum);
		System.out.println();

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		sum = 0;

		for (int i = 0; i < 10; i++) {
			System.out.print("숫자: ");
			int num = Integer.parseInt(reader.readLine());
			sum += num;
		}

		System.out.println("총합: " + sum);

	}

	private static void m3() {

		// 반복문 사용 이유
		// 1. 반복하기 위해서
		// 2. 루프 변수를 사용하기 위해서(*************) > 多연습 필요!!

		// 요구사항] 숫자 1~10까지 출력
		System.out.println("1");
		System.out.println("2");
		System.out.println("3");
		System.out.println("4");
		System.out.println("5");
		System.out.println("6");
		System.out.println("7");
		System.out.println("8");
		System.out.println("9");
		System.out.println("10");
		System.out.println();

		int num = 1;

		System.out.println(num);
		num++;
		System.out.println(num);
		num++;
		System.out.println(num);
		num++;
		System.out.println(num);
		num++;
		System.out.println(num);
		num++;
		System.out.println(num);
		num++;
		System.out.println(num);
		num++;
		System.out.println(num);
		num++;
		System.out.println(num);
		num++;
		System.out.println(num);
		num++;
		System.out.println();

		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
		}
		System.out.println();


		for (int i = 2; i <= 10; i += 2) {
			System.out.println(i);
		}
		System.out.println();


		for (int i = 2; i <= 10; i += 2) {
			System.out.println(i);
		}
		System.out.println();


		for (int i = 7; i <= 100; i += 7) {
			System.out.println(i);
		}
		System.out.println();

	}

	private static void m2() {

		// 반복문 > 몇회전?
		for (int i = 0; i < 5; i++) {
			System.out.println("실행문");
		}
		System.out.println();

		for (int i = 3; i <= 7; i++) {
			System.out.println("실행문");
		}
		System.out.println();

		for (int i = 10; i > 5; i--) {
			System.out.println("실행문");
		}

	}

	private static void m1() {

		// 요구사항] "안녕하세요" x 5 출력
		// hello();
		// hello();
		// hello();
		// hello();
		// hello();

		for (int i = 1; i <= 5; i++) {
			hello();
		}

		System.out.println();

		// int i = 1; > 초기식. for문에 처음 진입할 때 단 1회만 실행한다.
		// i <= 5; > 조건식. 반복 유무를 결정한다.
		// i++; > 증감식. 조건식의 변화를 유발한다.

		// 반복문 > loop(iteration) > i > 루프 변수
		for (int i = 0; i < 5; i++) {
			System.out.println("안녕하세요.");
		}

	}

	private static void hello() {
		System.out.println("안녕하세요.");
	}

}


