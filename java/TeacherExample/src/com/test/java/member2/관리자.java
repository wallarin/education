package com.test.java.member2;

import java.util.Scanner;
import com.test.java.auth.로그인;

public class 관리자 {
	
	public void begin() {
		
		//관리자 등급만 접근 가능
		//> 로그인을 했는지 검사
		if (로그인.auth == null || !로그인.auth.getLevel().equals("2")) {
			System.out.println();
			System.out.println("관리자만 접근 가능합니다.");
			System.out.println();
			return;
		}
		
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println();
		System.out.println("관리자 업무");
		
		System.out.println();
		System.out.println("엔터 > 진행");
		scan.nextLine();		
		
	}

}
