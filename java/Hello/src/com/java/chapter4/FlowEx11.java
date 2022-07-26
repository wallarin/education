package com.java.chapter4;

import java.util.Scanner;

public class FlowEx11 {

	public static void main(String[] args) {

		System.out.print("당신의 주민번호를 입력하세요.(011231-1111222)>");

		Scanner scanner = new Scanner(System.in);
		String regNo = scanner.nextLine();
		char gender = regNo.charAt(7); // 성별을 나타내는 뒷자리 첫번째 숫자를 추출해 gender에 저장한다..


		switch (gender) {
			case '1':
			case '3':
				switch (gender) {
					case '1':
						System.out.println("당신은 2000년 이전에 출생한 남자입니다.");
						break;
					case '3':
						System.out.println("당신은 2000년 이후에 출생한 남자입니다.");
				}
				break;
			case '2':
			case '4':
				switch (gender) {
					case '2':
						System.out.println("당신은 2000년 이전에 출생한 여자입니다.");
						break;
					case '4':
						System.out.println("당신은 2000년 이후에 출생한 여자입니다.");
				}
				break;
			default:
				System.out.println("유효하지 않은 주민번호입니다.");
		}

	}// main

}
