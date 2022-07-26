package com.test.java.question.repeatwhile;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q05 {
	
	public static void main(String[] args) throws Exception {
		
		/*
		
		요구사항] 자판기 프로그램을 구현하시오..
		
		*/
	
	
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		boolean loop = true;
		
		while (loop) {
		//for (; loop;) {
			
			System.out.println("=================");
			System.out.println("      자판기");
			System.out.println("=================");
			System.out.println("1. 콜라");
			System.out.println("2. 사이다");
			System.out.println("3. 비타500");
			System.out.println("-----------------");
			System.out.print("금액 투입(원) : ");
			
			int won = Integer.parseInt(reader.readLine());
			
			choice(won);
			
		}//while
	}

	private static void choice(int won) throws Exception {
		
		System.out.println("-----------------");
		System.out.print("음료 선택(번호) : ");
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String sel = reader.readLine();
		
		if (sel.equals("1")) {			
			if (won > 700) {
			System.out.println("콜라를 제공합니다.");
			System.out.printf("잔돈 %,d원을 제공합니다.\n", won - 700);
			end();
			} else {
				System.out.println("금액을 다시 투입해 주세요.");
			}
		} else if (sel.equals("2")) {
			if (won > 600) {
			System.out.println("사이다를 제공합니다.");
			System.out.printf("잔돈 %,d원을 제공합니다.\n", won - 600);
			end();
			} else {
				System.out.println("금액을 다시 투입해 주세요.");
			}
		} else if (sel.equals("3")) {
			if (won > 700) {
			System.out.println("비타500을 제공합니다.");
			System.out.printf("잔돈 %,d원을 제공합니다.\n", won - 500);
			end();
			} else {
				System.out.println("금액을 다시 투입해 주세요.");
			}
		} else {
			System.out.println("음료를 잘못선택 하셨습니다. 숫자로 1,2,3 중에 하나를 선택해주세요");
		}
		
	}

	private static void end() throws Exception {
		System.out.println();
		System.out.print("계속하시려면 엔터를 입력하세요.");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String sel = reader.readLine();
	}
}
