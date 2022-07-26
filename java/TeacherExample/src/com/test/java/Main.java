package com.test.java;

import java.util.Scanner;
import com.test.java.auth.로그인;
import com.test.java.auth.본인정보;
import com.test.java.member1.회원;
import com.test.java.member2.관리자;

public class Main {

	public static void main(String[] args) {
		
		Data.load();
		
		boolean loop = true;
		
		Scanner scan = new Scanner(System.in);
		
		while (loop) {

			System.out.println("==================");
			System.out.println("1. 인증");
			System.out.println("2. 회원");
			System.out.println("3. 관리자");
			System.out.println("4. 본인 정보");
			System.out.println("5. 종료");
			System.out.println("==================");
			System.out.print("선택: ");
			
			String input = scan.nextLine();
			
			if (input.equals("1")) {
				로그인 a = new 로그인();
				a.begin();				
			} else if (input.equals("2")) {
				회원 a = new 회원();
				a.begin();
			} else if (input.equals("3")) {
				관리자 a = new 관리자();
				a.begin();
			} else if (input.equals("4")) {
				본인정보 a = new 본인정보();
				a.info();
			} else {
				loop = false;
			}
			
		}
		
	}
	
}

































