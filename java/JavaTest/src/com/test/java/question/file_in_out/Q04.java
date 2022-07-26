package com.test.java.question.file_in_out;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Q04 {
	
	public static void main(String[] args) {
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("C:\\class\\파일_입출력_문제\\단일검색.dat"));
			
			System.out.print("이름: ");
			Scanner scanner = new Scanner(System.in);
			String search = scanner.nextLine();
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				String[] parsing = line.split(",");
				String num = parsing[0];
				String name = parsing [1];
				String address = parsing[2];
				String tel = parsing[3];
				
				if (search.equals(name)) {
					System.out.printf("[%s]\n번호: %s\n주소: %s\n전화: %s\n", name, num, address, tel);
				}

			}
			
			reader.close();
			scanner.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}//main

}
