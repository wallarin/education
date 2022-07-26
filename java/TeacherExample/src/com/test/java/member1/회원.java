package com.test.java.member1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import com.test.java.auth.로그인;

public class 회원 {

	public void begin() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println();
		System.out.println("==================");
		System.out.println("1. 게시판");
		System.out.println("2. 작성한 글");
		System.out.println("3. 돌아가기");
		System.out.println("==================");
		System.out.print("선택: ");
		
		String input = scan.nextLine();
		
		System.out.println();
		
		if (input.equals("1")) {
			list();
		} else {
			mylist();
		}
		
		System.out.println();
		System.out.println("엔터 > 진행");
		scan.nextLine();		
		
	}

	private void list() {
		
		//게시판 열람은 회원만 가능
		//> 로그인을 했는지 검사
		if (로그인.auth == null) {
			System.out.println("회원만 접근 가능합니다.");
			return;
		}
		
		try {
			
			System.out.println("[번호]\t[제목]");
			
			BufferedReader reader = new BufferedReader(new FileReader("data\\board.txt"));
			
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				System.out.printf("%s\t%s\n", temp[0], temp[1]);
				
			}
			
			reader.close();
			
		} catch (Exception e) {
			System.out.println("회원.list");
			e.printStackTrace();
		}
		
	}

	private void mylist() {
		
		//게시판 열람은 회원만 가능
		//> 로그인을 했는지 검사
		if (로그인.auth == null) {
			System.out.println("회원만 접근 가능합니다.");
			return;
		}
		
		try {
			
			System.out.println("[번호]\t[제목]");
			
			BufferedReader reader = new BufferedReader(new FileReader("data\\board.txt"));
			
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				//본인이 작성한 글만 출력
				//> 로그인한 계정과 게시판 작성자를 비교
				if (temp[2].equals(로그인.auth.getSeq())) {				
					System.out.printf("%s\t%s\n", temp[0], temp[1]);
				}
				
			}
			
			reader.close();
			
		} catch (Exception e) {
			System.out.println("회원.list");
			e.printStackTrace();
		}
		
	}

}
