package com.test.java.question.String;

public class Q05 {
//XXX 다시풀기
	public static void main(String[] args) {

		String content = "안녕~ 길동아~ 잘가~ 길동아~";
		String word = "길동";

		int sum = 0;
		
		int index = -1;
		
		index += content.indexOf(word);
		
		//do while 문을 사용하는 방법이 있을듯?
		
		
		for (int i = 0; i < content.length(); i++) {
			index = content.indexOf(word, index + word.length());
			
			sum++;
			
		}
		
		System.out.printf("'%s'을 총 %d회 발견했습니다.",word, sum);
	}//main

}
