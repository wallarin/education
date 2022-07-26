package com.test.java.auth;

import java.util.Scanner;
import com.test.java.Data;
import com.test.java.User;

public class 로그인 {
	
	public static User auth;

	public void begin() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println();
		System.out.println("==================");
		System.out.println("1. 로그인");
		System.out.println("2. 로그아웃");
		System.out.println("==================");
		System.out.print("선택: ");
		
		String input = scan.nextLine();
		
		if (input.equals("1")) {
			login();
		} else {
			logout();
		}
		
		System.out.println("엔터 > 진행");
		scan.nextLine();		
		
	}

	private void login() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println();
		
		System.out.print("아이디: ");
		String id = scan.nextLine();
		System.out.print("암호: ");
		String pw = scan.nextLine();
		
		for (User u : Data.list) {
			if (u.getId().equals(id) && u.getPw().equals(pw)) {
				
				//로그인 처리
				//> 로그인을 했다라는 표시를 남기기 위해 static 변수를 사용
				//> 어느 상황에서든 로그인.auth를 확인하면 로그인 한 자신의 정보를 확인 가능
				auth = u;
				break;
				
			}
		}
		
		System.out.println();
		
		if (auth != null) {
			System.out.println("로그인 성공");
		} else {
			System.out.println("로그인 실패");
		}
		
	}

	private void logout() {
		
		//auth를 비운다는것 로그인 하기 전 상태로 돌아간다는 뜻
		로그인.auth = null;
		
		System.out.println();
		System.out.println("로그아웃 성공");
		System.out.println();
		
	}

}


































