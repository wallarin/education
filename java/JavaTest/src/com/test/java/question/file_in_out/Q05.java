package com.test.java.question.file_in_out;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Q05 {
	
	public static void main(String[] args) {
		//TODO 수정필요
		try {
			BufferedReader readMember = new BufferedReader(new FileReader("C:\\class\\파일_입출력_문제\\검색_회원.dat"));
			BufferedReader readOrder = new BufferedReader(new FileReader("C:\\class\\파일_입출력_문제\\검색_주문.dat"));
			String[] result = new String[5];
			System.out.print("이름: ");
			Scanner scanner = new Scanner(System.in);
			String search = scanner.nextLine();
			
			String line = null;

			while ((line = readMember.readLine()) != null) {
				String[] memberInfo = line.split(",");

				if (search.equals(memberInfo[1])) {
					
					for(int i = 0; i < memberInfo.length; i++) {
						result[i] = memberInfo[i];
					}
				}

			}
			
			while((line = readOrder.readLine()) != null) {
				String[] orderInfo = line.split(",");
				
				if(result[0].equals(orderInfo[3])) {
					
					for(int i=3; i < result.length; i++) {
						result[i] = orderInfo[i-2];
					}
				}
			}
			System.out.println("==== 구매내역 ====");
			System.out.println("[번호]\t[이름]\t[상품명]\t[개수]\t[배송지]");
			System.out.printf("%3s\t%s\t%s\t%s\t%s\n",result[0],result[1],result[3],result[4],result[2]);
			
			readMember.close();
			readOrder.close();
			scanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
