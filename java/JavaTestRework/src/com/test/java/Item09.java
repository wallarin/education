package com.test.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Item09 {
	
	public static void main(String[] args) throws Exception {
		
		//[SUMMARY] 사용자에게 콘솔 입력받기 (2022. 3. 23. 오후 9:30:59)
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		//Ctrl + Shift + O 를 이용해 사용 선언 후 main 메소드 옆에 throws Exception 필히 적기
		
		System.out.print("이곳에서 입력할 정보를 미리 공지");
		
		//적힌 내용을 String 타입인 input에 저장해준다
		String input = reader.readLine();
		
		//입력 받았던 String형을 Integer로 형변환 하는 방법
		// 타입.parse타입(변환할 값)
		int num1 = Integer.parseInt(input);
		
		//문자열로 바꾸는 법
		//String.valueOf(100) -> "100"
		
		//바로 int형에 저장도 가능!!
		int inpu1 = Integer.parseInt(reader.readLine());
		
		
		
	}

}
