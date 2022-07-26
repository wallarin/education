package com.project.dentist;

import java.util.ArrayList;
import java.util.Scanner;
import com.project.dentist.admin.AdminMain;
import com.project.dentist.dataClass.Patient;

public class Main {

	public static int loginTry = 0;
	public static void main(String[] args) { //로고 및 회원가입 로그인 화면
		
		Data.load();
		Sign sign = new Sign();
		boolean loop = true;
		
		while (loop) {
			System.out.println("🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷");
			System.out.println("==================================================================================="); 
			System.out.println("\r\n"
                    + "                             ⣼⠗⠂⡤⢄⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
                    + "⠀⠀⠀⠀                     ⠀⠀ ⢠⣿⠁⢀⠃⠆⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
                    + "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⠀⠀⠀ ⠀⣼⡇⠀⡈⠐⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
                    + "⠀⠀⠀⠀⠀   ⣠⠤⠒⠒⠒⠒⠒⠤⠴⡒⠒⠒⠒⠢⡄⠀  ⢸⡏⠐⠲⠁⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
                    + "⠀⠀⠀⠀  ⢠⠊⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⠈⠳⡀⠀⢸⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
                    + "      ⡇ ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⢣⠀⢸⡇⠀		▄  ▄▄▄▄   ▄▄▄  ▄ ▄▄▄▄ ▄⠀⠀⠀⠀⠀⠀⠀\r\n"
                    + "⠀⠀⠀⠀  ⡇⠀⠀⠀⠀ ⢶⡦⠀⠀⠀⠀⣶⡦⠀⠀⠀  ⢸⣀⡼⠓⣦	   █  █ █  ▄▄▄█  ▄▄▄▄▄ █  ▄ █ █ ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠀\r\n"
                    + "     ⠀⢇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠀ ⡎ ⣤⠒⠁	   █▄▄█ █▄ █▄▄▄   ▄▀▄  █  █ ▀ █▄ ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
                    + "⠀⠀⠀⠀⠀⠀⢘⡄⠀⠀⠀⠀ ⠀⠂⠤⠤⠂⠀⠀⠀⠀ ⡰⠗ ⣹⡏⠀⠀	   █  █ █ ▄▄▄▄▄▄ ▀   ▀ █ ▀▀▀▀ █ ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
                    + "⠀⠀⠀  ⡼⠈⣤⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⠀⡜⠁⢰⣿⠁⠀	   ▀▀▀▀ █ ▄            █      █⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ \r\n"
                    + "   ⢠⠁ ⡰⠙⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠀ ⢸⠀⠀⣾  	          ▀▀▀▀▀▀⠀⠀                     \r\n"
                    + " ⠀⠀⣇⡔⠁⠀ ⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  ⠀⢸⠀⢰⡿⠀⠀⠀⠀  ╭────────────╮   ╭────────────╮   ╭─────────────╮⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
                    + "⠀⠀⠀⠀⠀⠀⠀  ⡇⠀⠀⠀⠀⡠⠊⠳⡄ ⠀⠀⠀⡼⠀⣾⠇⠀⠀⠀⠀⠀   1. 회원가입         2.로그인           0.프로그램종료⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
                    + "⠀⠀⠀⠀ ⠀⠀⠀ ⢣⠀⠀⠀⢠⠃⠀⠀⢸⠀⠀⠀⢀⡇⠼⡟⠀⠀⠀⠀⠀⠀⠀╰────────────╯   ╰────────────╯   ╰─────────────╯⠀⠀⠀⠀\r\n"
                    + "⠀⠀⠀⠀ ⠀⠀  ⠈⢆⠀⠀⡜⠀⠀⠀⠀⢇⠀⠀⡞⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
                    + "⠀⠀⠀⠀⠀⠀ ⠀⠀ ⠈⠓⠚⠀⠀⠀⠀⠀⠈⠓⠊⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
                    + "");
			System.out.println("==================================================================================="); 
			System.out.println("🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷");

			Scanner scan = new Scanner(System.in);
			System.out.print("번호✎ > ");
			String input = scan.nextLine();
			System.out.println();

			if (input.equals("1")) {
				sign.sign();
				
	         } else if (input.equals("2")) {
	        	 ArrayList<String> id = new ArrayList<String>();
	     		
	     		for(Patient p : Data.plist) {
	     			id.add(p.getId());
	     		}
	            System.out.print("아이디 입력 > ");
	            String log = scan.nextLine();
	           
	            if(id.contains(log)) {
	            	System.out.print("비밀번호 입력 > ");
	            	String pw = scan.nextLine();
	            	Login.login(log, pw);
	            } else if (log.equals("admin")) {
	            	System.out.println("🦷관리자 모드로 로그인 성공하였습니다!!🦷");
	            	System.out.println();
		            AdminMain.main();
		  	         
		  	    } 
	            else {
	            	System.out.println("아이디가 올바르지 않습니다.");
	            }
	            
	            
	            if (loginTry == 5) {
	            	resetPw.main();
	            
	            }
	         }  else if(input.equals("0")){
	            loop = false;
	         } else {
	        	 System.out.println("잘못된 번호입니다 다시 입력해주세요.");
	         }
			
			
		}

	}

}