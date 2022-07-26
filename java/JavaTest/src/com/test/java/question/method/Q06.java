package com.test.java.question.method;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q06 {
	
	public static void main(String[] args) throws Exception {
		
		/*
		요구사항] 국어, 영어, 수학 점수를 전달하면 '합격' 혹은 '불합격'이라는 단어를 반환하는 메소드를 선언하시오.

		조건..
		String test(int kor, int eng, int math)
		평균 점수 60점 이상은 '합격'이다.
		평균 점수 60점 미만은 '불합격'이다.
		과락: 한 과목 이상 40점 미만이면 불합격이다.
		입력..
		국어 : 80 

		영어 : 75 

		수학 : 60 

		출력..
		합격입니다.
		입력..
		국어 : 55 

		영어 : 35 

		수학 : 60 

		출력..
		불합격입니다.
		
		--프로세스
		1.3개의 인자값을 받는 test 메소드를 생성후 조건식을 이용해 값이 40보다 큰지 확인 크지 않다면 "불합격"출력
		2.3개의 인자값이 모두 40보다 크다면 3개의 인자값을 더한 뒤 3으로 나눠 60이상의 값인지 확인 후 크다면 "합격" 작다면 "불합격" return
		3.BufferedReader를 생성해 국어, 영어, 수학 점수값을 입력받는다.
		4.입력받은 값을 test 메소드를 호출해 넣어준다.
		5.결과값을 출력한다.
		*/
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("국어 : ");
		String input = reader.readLine();
		int kor = Integer.parseInt(input);
		
		System.out.print("영어 : ");
		String input2 = reader.readLine();
		int eng = Integer.parseInt(input2);
		
		System.out.print("수학 : ");
		String input3 = reader.readLine();
		int math = Integer.parseInt(input3);
		
		String result = test(kor, eng, math);
		System.out.printf("%s입니다.\n", result);
		
	}

	public static String test(int kor, int eng, int math) {
		
		/*
		String result = kor > 40 ? 
							eng > 40 ? 
								math > 40 ? 
									(kor + eng + math) / 3 >= 60 ? "합격" : "불합격"
								: "불합격" 
							: "불합격"
						: "불합격";
						*/
											
		//더 간결하게 하는방법은?? &&(and) 을 사용하면 간결해진다
											
		//String result = kor > 40 && eng > 40 && math > 40 ? (kor + eng + math) / 3 >= 60 ? "합격" : "불합격" : "불합격";
		String result = kor > 40 || eng > 40 || math > 40 ? (kor + eng + math) / 3 >= 60 ? "합격" : "불합격" : "불합격";
		
		return result;
		
	}
	
}
