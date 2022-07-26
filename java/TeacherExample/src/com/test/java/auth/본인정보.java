package com.test.java.auth;

import java.util.Scanner;

public class 본인정보 {
	
	public void info() {
		
		Scanner scan = new Scanner(System.in);

		System.out.println();
		
		//로그인.auth안에 객체가 없다는건 로그인을 안했다는 뜻
		//> 너 로그인 한 상태냐? 라는 질문
		if (로그인.auth != null) {
		
			System.out.println();
			System.out.println("==================");
			System.out.println("본인정보");
			System.out.println("==================");
			
			System.out.println("아이디: " + 로그인.auth.getName());
			System.out.println("등급: " + (로그인.auth.getLevel().equals("1") ? "일반회원" : "관리자"));
			
			System.out.println();
			
		} else {
			
			System.out.println();
			System.out.println("로그인하지 않았습니다.");
		}
		
		System.out.println("엔터 > 진행");
		scan.nextLine();	
		
	}

}
