package com.test.servlet;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Calendar;

public class Ex01 {

	public static void main(String[] args) {
		
		System.out.println("Hello World");
		
		//알바생
		//- 브라우저가 요청하면 > 동적으로 웹페이지 제작(= 요청할때 만들어지는 페이지이다.)
		
		//요청 발생!
		//- 자바 프로그램이 HTML, CSS, JavaScript 언어를 사용해서 페이지를 제작
		//- 자바 파일에서는 HTML, CSS, JavaScript 등 다른 언어들을 읽지 못해서 문자열로 받아들인다..
		
		//우리가 하는일
		//1. 페이지가 될 자바 파일을 생성한다.
		
		//브라우저는 요청한다. > 자바파일을 호출한다 > html파일을 만든다 > 브라우저에게 돌려준다.
		
		Calendar now = Calendar.getInstance();
		
		String html = "";
		
		html += "<html>";
		html += "<head>";
		html += "<meta charset='UTF-8'>";
		html += "</head>";
		html += "<body>";
		html += "<h1>동적 페이지</h1>";
		html += "<p>이 페이지는 동적으로 생성되었습니다.</p>";
		html += String.format("<p>현재 시간: %tF %tT</p>", now, now);
		html += "</body>";
		html += "</html>";
		
		System.out.println(html);
		
		
		try {
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(".\\src\\main\\webapp\\ex01.html"));
			writer.write(html);
			writer.close();
			
		} catch (Exception e) {
			
		}
		
	}

}


















































