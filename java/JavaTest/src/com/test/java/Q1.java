package com.test.java;

public class Q1 {

	public static void main(String[] args) {
		
		//byte 예제
		
		//1번
		byte age = 28;
		System.out.println("현재 나이는? : " + age + " 입니다.");
		
		//2번
		byte MIN = -128;
		System.out.println("byte의 최솟값은 " + MIN + "입니다.");
		
		//3번
		byte MAX = 127;
		System.out.println("byte의 최댓값은 " + MAX + "입니다.");
		
		//4번
		byte kor_score = 98;
		System.out.println("국어점수는 " + kor_score + "점 입니다.");
		
		//5번
		byte math_score = 88;
		System.out.println("수학점수는 " + math_score + "점 입니다.");
		
		//6번
		byte english_score = 92;
		System.out.println("영어점수는 " + english_score + "점 입니다.");
		
		//7번
		byte zero = 0;
		System.out.println("1 - 1 = " + zero);
		
		//8번
		byte num_1 = 22, num_2 = 3;
		System.out.println(num_1 + " * " + num_2 + " = " + (num_1 * num_2));
		
		//9번
		byte teeth = 32;
		System.out.println("사람의 치아의 개수는 총 " + teeth + "개 입니다.");
		
		//10번
		byte eyes = 2, nose = 1, ears = 2, mouth = 1;
		System.out.println("사람의 눈은 " + eyes + "개, 코는 " + nose + "개, 귀는 " + ears + "개, 입은 " + mouth + "개 입니다.");
		
		
		System.out.println("-----------------------------------------------------------------------");
		
		
		//short 예제 32767
		
		//1번
		short sNUM = 29956;
		System.out.println(sNUM);
		
		//2번
		short sNUM1 = -30994;
		System.out.println(sNUM1);
		
		//3번
		short city = 162;
		System.out.println("우리나라의 시/도의 개수는 " + city + "개 이다.");
		
		//4번
		short snum_1 = 12333, snum_2 = 29574;
		System.out.println(snum_1 + " + " + snum_2 + " = " + (snum_1 + snum_2));
		
		//5번
		System.out.println(snum_1 + " - " + snum_2 + " = " + (snum_1 - snum_2));
		
		//6번
		short snum_3 = 33, snum_4 = 55;
		System.out.println(snum_3 + " * " + snum_4 + " = " + (snum_3 * snum_4));
		
		//7번
		System.out.println("시험 점수의 총 합은 : " + (kor_score + math_score + english_score) + "점 입니다.");
		
		//8번
		short sMIN = -32768;
		System.out.println("short의 최솟값은 " + sMIN + "입니다.");
		
		//9번
		short sMAX = 32767;
		System.out.println("short의 최댓값은 " + sMAX + "입니다.");

		//10번
		System.out.println((snum_1 + snum_2) + (snum_1 - snum_2));
		
		
		System.out.println("-----------------------------------------------------------------------");
		
		//int 예제
		
		//1번
		int iNUM = 3276448;
		System.out.println(iNUM);
		
		//2번
		int iNUM1 = -5993352;
		System.out.println(iNUM1);

		//3번
		System.out.println(iNUM + iNUM1);

		//4번
		System.out.println(iNUM - iNUM1);
		
		//5번
		System.out.println(iNUM1 - iNUM);

		//6번
		System.out.println(iNUM1 * (-2));
		
		//7번
		int iMIN = -2147483648;
		System.out.println("int의 최솟값은 : " + iMIN + "입니다.");
		
		//8번
		int iMAX = 2147483647;
		System.out.println("int의 최댓값은 : " + iMAX + "입니다.");
		
		//9번
		int covid = 4666977;
		System.out.println("2022년 3월 7일 기준 코로나 누적 확진자 수는 " + covid + "명 입니다.");
		
		//10번
		int population = 51780000;
		System.out.println("우리나라의 2020년 기준 인구수는 약 " + population + "명 입니다.");
		
		
		System.out.println("-----------------------------------------------------------------------");
		
		
		//long 예제
		//1번
		long lNUM1 = 1000L;
		System.out.println(lNUM1);
		
		//2번
		long lNUM2 = 1000445555L;
		System.out.println(lNUM2);
		
		//3번
		long lNUM3 = 100043432211L;
		System.out.println(lNUM3);
		
		//4번
		long lNUM4 = 1000858585858999L;
		System.out.println(lNUM4);
		
		//5번
		long lNUM5 = 1000543333337777899L;
		System.out.println(lNUM5);
		
		//6번
		long lNUM6 = 9004466686868787770L;
		System.out.println(lNUM6);
		
		//7번
		System.out.println(lNUM1 + lNUM2);
		
		//8번
		System.out.println(lNUM6 - lNUM5);
		
		//9번
		System.out.println(lNUM2 * 4);
		
		//10번
		long lMIN = -9223372036854775808L, lMAX = 9223372036854775807L;
		System.out.println("long의 최솟값은 : " + lMIN + "이고, 최댓값은 : " + lMAX + "입니다.");
		
		
		System.out.println("-----------------------------------------------------------------------");
		//float 예제
		
		//1번
		float fNUM = 4.22F;
		System.out.println(fNUM);
		
		//2번
		float fNUM1 = 98.6655664F;
		System.out.println(fNUM1);
		
		//3번
		System.out.println(fNUM + fNUM1);
		
		//4번
		System.out.println(fNUM1 + fNUM);
		
		//5번
		System.out.println(fNUM * fNUM1);

		//6번
		float fNUM2 = -3399.22003040F;
		System.out.println(fNUM2);
		
		//7번
		System.out.println(fNUM2 * 3 - fNUM1);
		
		//8번
		System.out.println(3433.495950F);		
		
		//9번
		System.out.println(-499.303040F);
		
		//10번
		float earth_population = 77.53F;
		System.out.println("2020년 기준 지구의 인구수는 : " + earth_population + "억 명입니다.");
		
		System.out.println("-----------------------------------------------------------------------");
		//double 예제
		
		//1번
		double dNUM = 4554.2434342232D;
		System.out.println(dNUM);
				
		//2번
		double dNUM1 = 98.665564466464D;
		System.out.println(dNUM1);
		
		//3번
		System.out.println(dNUM + dNUM1);
				
		//4번
		System.out.println(dNUM1 + dNUM);
				
		//5번
		System.out.println(dNUM * dNUM1);

		//6번
		double dNUM2 = -3399.22003040D;
		System.out.println(dNUM2);
				
		//7번
		System.out.println(dNUM2 * 3 - dNUM1);
				
		//8번
		System.out.println(3433.4959584850D);		
			
		//9번
		System.out.println(-499.30304055558D);
				
		//10번
		double earth_population_D = 77.53D;
		System.out.println("2020년 기준 지구의 인구수는 : " + earth_population_D + "억 명입니다.");
		
				
		System.out.println("-----------------------------------------------------------------------");
		
		//char 예제
		char eng1 = 'A';
		System.out.println(eng1);
		char eng2 = 'B';
		System.out.println(eng2);
		char eng3 = 'C';
		System.out.println(eng3);
		char eng4 = 'D';
		System.out.println(eng4);
		char eng5 = 'E';
		System.out.println(eng5);
		char kor1 = '가';
		System.out.println(kor1);
		char kor2 = '나';
		System.out.println(kor2);
		char kor3 = '다';
		System.out.println(kor3);
		char kor4 = '라';
		System.out.println(kor4);
		char kor5 = '마';
		System.out.println(kor5);
		
		System.out.println("-----------------------------------------------------------------------");
		
		//boolean
		
		//1번
		System.out.println(true);
		
		//2번
		System.out.println(false);
		
		//3번
		boolean btrue = true;
		System.out.println(btrue);
		
		//4번
		System.out.println(!btrue);
		
		//5번
		System.out.println(139 > 39);
		
		//6번
		System.out.println(139 < 39);
		
		//7번
		char bchar = 'g';
		System.out.println(bchar == 'g');
		
		//8번
		System.out.println(bchar == 'G');
		
		//9번
		boolean bfalse = false;
		System.out.println(bfalse);
		
		//10번
		System.out.println(!bfalse);
		
		System.out.println("-----------------------------------------------------------------------");
		
		
		//String 예제
		
		//1번
		String addressNo = "04001";
		System.out.println("서교동의 우편번호는 " + addressNo + "입니다.");
		
		//2번
		String phoneNo 	 = "010 - 9999 - 2222";
		System.out.println("가상의 전화번호 : " + phoneNo);
		
		//3번
		String email_id = "string";
		System.out.println(email_id);
		
		//4번
		String email = "@gmail.com";
		System.out.println(email);
		
		//5번
		System.out.println(email_id + email);
		
		//6번
		System.out.println("자바는 객체지향 언어이다.");
		
		//7번
		String eng_sum = "ABC " + " DEF";
		System.out.println(eng_sum);
		
		//8번
		String add_1 = "서울특별시 마포구 서교동";
		System.out.println(add_1);
		
		//9번
		String add_2 = "풍성빌딩 2,3,4층";
		System.out.println(add_2);
		
		//10번
		System.out.println("쌍용강북교육센터의 우편번호는 " + addressNo + "이며, 주소는 " + add_1 + add_2 + " 입니다.");
	}

}
