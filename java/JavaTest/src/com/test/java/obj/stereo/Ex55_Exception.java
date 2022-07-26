package com.test.java.obj.stereo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Ex55_Exception {

	public static void main(String[] args) {

		/*
		
			예외, Exception
			- 컴파일 발견 X > 실행 중 발견 O
			- 런타임 오류
			- 개발자 미리 예측 O or X
			
			카톡
			- 메시지 전송 기능
			
			
			
			
			예외 처리, Exception Handling
			1. 전통적인 방식
				- 제어문 사용(조건문)
				
			2. 전용 처리 방식(권장이지만 대부분은 혼용사용)
				- try catch (finally)문 사용
		
		*/

		// m1();//this가 생략 but static 메소드 안에서는 this. 사용 불가능


		// Ex55_Exception.m1(); //FM
		// m1();

		// Ex55_Exception ex = new Ex55_Exception(); > 필요성이 없음
		// ex.m1();

		// m2(10);
		// String result = m2();
		// int result1 = m3();

		// m1();
		// m2();
		//m3();
		try {
			m4();
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		m5();

	}// main

	private static void m5() {
		
		//예외 던지기
		
		//요구사항] 숫자 입력 > 처리
		//조건) 반드시 짝수만 입력
		//		홀수 > 에러
		
		int num = 11;
		
		if (num % 2 == 0) {
			System.out.println("업무 코드..");
		} else {
			System.out.println("예외 처리");
		}
		
		try {
			if (num % 2 == 1) {
				throw new Exception("홀수를 입력했습니다."); //throws Exception과 혼동 주의!! //강제 에러 발생!!
				//> 반드시 조건문에서 실행
			}
			System.out.println("업무 코드..");
		} catch (Exception e) {
			System.out.println("예외 처리");
			System.out.println(e.getMessage());
		}
		
	}

	private static void m4() throws Exception {
		
		//예외 미루기
		//- 해당 영역에서 예외 처리를 할만한 상황이 안되면 다른 곳으로 예외 처리의 책임을 떠 넘길 수 있다.
		//- throws Exception > 예외 미루기
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		//Unhandled exception type IOException
		//String input = reader.readLine();
			
		
	}

	private static void m3() {

		// Exception 객체의 역할

		try {
			
			int num = 10;
			System.out.println(100 / num); // A. ArithmeticException
			
			//throw new ArithmeticException();
	
			int[] nums = {10, 20, 30};
			System.out.println(nums[2]); // B. ArrayIndexOutOfBoundsException
			
			//throws new ArrayIndexOutOfBoundsException();
	
			Parent p = new Parent();
			Child c;
			
//			Child c = new Child();
//			Parent p;
	
			//c = (Child) p; // C. ClassCastException
			
			Parent p2 = null;
			System.out.println(p2.toString()); //NullReferenceException
//			p = c;
			
		} catch (ArithmeticException e) {
			//ArithmeticException e = new ArithmeticException();
			//ArithmeticException e = new ArrayIndexOutOfBoundsException;
			System.out.println("0으로 나누기");
			
		} catch (ArrayIndexOutOfBoundsException e) {
			//ArrayIndexOutOfBoundsException e = new ArrayIndexOutOfBoundsException();
			System.out.println("배열 첨자 오류");
			
		} catch (ClassCastException e) {
			System.out.println("형변환 오류");
		} catch (Exception e) {
			
			//Exception > 모든 OOOException의 부모 클래스
			System.out.println("예외 처리");
			//e.printStackTrace();
		}
		
		System.out.println("종료");
		
//		catch (Exception e) {
//			System.out.println("예외 처리");
//			System.out.println(e.getMessage());
//		}
	}

	private static void m2() {

		// Exception 객체의 역할

		int num = 0;

		try {
			System.out.println(100 / num); // A
		} catch (Exception e) {
			System.out.println("0으로 나누기");
		}

		int[] nums = {10, 20, 30};

		try {
			System.out.println(nums[4]); // B
		} catch (Exception e) {
			System.out.println("배열 첨자 오류");
		}

		Parent p = new Parent();
		Child c;

		try {
			c = (Child) p; // C
		} catch (Exception e) {
			System.out.println("형변환 오류");
		}



	}

	// private static int m3() {
	// return 0;
	// }
	//
	// private static String m2() {
	// return null;
	// }

	// private static void m2(int i) {
	//
	// }



	// 메소드 자동 생성 > 생각?
	// 1. why? private > 우리가 통제가 못해 사고가 터질까봐 미리 감춰놓는 것이다. > 안전성
	// 2. why? static > main에서 static 정적 변수라서 같이 정적 변수를 설정해야 해서
	// 3. why? void > 호출하는 쪽에서 매개변수를 정하지 않아서..
	// 4. why? () > 안에 인자를 넣지 않아서
	private static void m1() {
		// static이 없으면 객체 메소드
		// 요구사항] 숫자를 입력받아 연산을 하시오.

		Scanner scan = new Scanner(System.in);

		System.out.print("숫자: ");
		int num = scan.nextInt(); // Integer.parseInt(reader.readLine())


		// 전통적인 방식

		// 권장
		if (num != 0) {

			// 비즈니스 코드(= 업무 코드) > 주목적!!!
			System.out.printf("100 / %d = %d\n", num, 100 / num);

		} else {

			// 예외 처리 코드
			System.out.println("0을 입력하면 안됩니다.");
		}


		// 비권장 > 정상적인 실행했을때를 if에 else에는 예외상태일때를 출력... > 가독성이 낮음
		if (num == 0) {
			// 예외 처리 코드
			System.out.println("0을 입력하면 안됩니다.");
		} else {
			// 비즈니스 코드(= 업무 코드) > 주목적!!!
			System.out.printf("100 / %d = %d\n", num, 100 / num);
		}


		/*
		
			if (조건) {
				참 블럭 > 긍정적
			} else {
				거짓 블럭 > 부정적
			}
		
		*/

		// try문
		// - try: 비즈니스 코드 작성
		// - catch : 예외 처리 코드 작성
		// - 서로 바뀌면 원하는 결과가 나오지 않는다.


		// 조건?
		// 1. 일단 try내부의 코드를 실행한다. > 업무 코드라서..
		// 2. 아무 문제 없음
		// 3. 빠져나감 > catch 실행 안함

		// 1. 일단 try내부의 코드를 실행한다. > 업무 코드라서..
		// 2. 에러 발생!!!
		// 3. 남아있는 업무코드의 실행을 중단!!!
		// 4. 즉시, catch로 이동한다.
		// 5. catch 실행


		// if문 vs try문
		// - if문: 사전에 미리 검사를 해서 사고가 안나게 처리..
		// - try문: 일단 실행 > 감시!!! > 사고가 터지면 그때 처리..


		// try의 영역 > 예외가 발생할 것 같다고 예측 가능한 최소한의 영역에만 적용...
		try {

			// 비즈니스 코드(= 업무 코드) > 주목적!!!
			System.out.printf("100 / %d = %d\n", num, 100 / num);

		} catch (Exception e) {

			// 예외 처리 코드
			System.out.println("0을 입력하면 안됩니다.");

			// Exception e
			// - 예외 객체
			// - 예외가 발생한 상황에 대한 정보를 알려준다.
			System.out.println(e.getMessage());
			// e.printStackTrace();

		}

		System.out.println("종료");

	}

}// Ex55



class Parent {

}


class Child extends Parent {

}


