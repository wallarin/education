package com.test.java.question.conditional;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q03 {
	
	public static void main(String[] args) throws Exception {
		
		/*

		요구사항] 문자 1개를 입력받아 아래와 같이 출력하시오.

		조건..
		f, F → Father
		m, M → Mother
		s, S → Sister
		b, B → Brother
		유효성 검사를 하시오.(위의 문자가 아닌 문자는 예외 처리)
		
		입력..
		문자 : f 
		출력..
		Father
		
		입력..
		문자 : F 
		출력..
		Father
		
		입력..
		문자 : s 
		출력..
		Sister
		
		입력..
		문자 : a 
		출력..
		입력한 문자가 올바르지 않습니다.
		
		1. BufferedReader 생성
		2. 입력받은 값 String 변수에 저장
		3. 	f, F → Father
			m, M → Mother
			s, S → Sister
			b, B → Brother -- if문과 else if문을 이용해 해당 값이 출력하도록 설정
		4. 위의 값이 아니라면 올바르지 않다는 출력문을 if문을 이용해 출력

		*/
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("문자: ");
		String family = reader.readLine();
		
		if (family.equals("f") || family.equals("F")) {
			System.out.println("Father");
		} else if (family.equals("m") || family.equals("M")) {
			System.out.println("Mother");
		} else if (family.equals("s") || family.equals("S")) {
			System.out.println("Sister");
		} else if (family.equals("b") || family.equals("B")) {
			System.out.println("Brother");
		} else {
			System.out.println("입력한 문자가 올바르지 않습니다.");
		}
		
	}

}




