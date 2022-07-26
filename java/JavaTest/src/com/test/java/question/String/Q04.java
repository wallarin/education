package com.test.java.question.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q04 {
	
	public static void main(String[] args) throws Exception {
		
		//1. BufferedReader를 생성한다
		//2. 10개의 파일이름을 담을 배열을 생성한다.
		//3. 파일을 10개 입력받는다.
		//4. 각 배열마다 .이후의 확장자명을 문자열 추출한다.
		//5. 추출된 확장자명을 각각 누적합산 해준다.
		//6. 각각의 파일명마다 누적된 값을 출력해준다.
		
		int mp3sum = 0;
		int jpgsum = 0;
		int javasum = 0;
		int hwpsum = 0;
		int docsum = 0;
		//int etc = 0;
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String[] file = new String[10];
		
		for(int i=0; i<10; i++) {
			System.out.print("파일명 : ");
			String input = reader.readLine();
			
			file[i] = input;
			
			//if문을 이용해 끝 글자가 확장자가 맞으면 증감시켜준다.
			if (file[i].toLowerCase().endsWith("mp3")) {
				mp3sum++;
			} else if (file[i].toLowerCase().endsWith("jpg")) {
				jpgsum++;
			} else if (file[i].toLowerCase().endsWith("java")) {
				javasum++;
			} else if (file[i].toLowerCase().endsWith("hwp")) {
				hwpsum++;
			} else if (file[i].toLowerCase().endsWith("doc")) {
				docsum++;
			} 
//			else {
//				etc++;
//			}
		}
		
		System.out.printf("mp3 : %d개\n", mp3sum);
		System.out.printf("jpg : %d개\n", jpgsum);
		System.out.printf("java : %d개\n", javasum);
		System.out.printf("hwp : %d개\n", hwpsum);
		System.out.printf("doc : %d개\n", docsum);
		//System.out.printf("etc : %d개", etc);
		
	} //main

}
