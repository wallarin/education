package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//1. 서블릿 클래스 선언
//a. javax.servlet.Servlet 인터페이스를 구현한다. > 고비용(하는일이 많아짐), 복잡함
//a. javax.servlet.http.HttpServlet 클래스를 상속받는다. > 저비용, 간편함 > 대부분 이 방법을 선택

public class Ex02 extends HttpServlet { //extends HttpServlet으로 인해 알바생 자격을 취득했다!!
	
	//2. doGet or doPost 메소드 선언
	//	a. 매개 변수 작성
	//		1. java.servlet.http.HttpServletRequest
	//		2. java.servlet.http.HttpServletResponse
	//	b. 예외 미루기
	//		1. java.io.IOException
	//		2. java.servlet.ServletException
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
									throws IOException, ServletException {
		
		//한글 깨지는 것 방지 > UTF-8로 안되어있음
		response.setCharacterEncoding("UTF-8");
		
		//3. 동적 HTML 페이지 작성 구현
		PrintWriter writer = response.getWriter(); //BufferedWriter 라고 생각
		
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<meta charset='UTF-8'>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h1>서블릿</h1>");
		writer.println("<p>서블릿으로 만든 동적 웹페이지입니다.</p>");
		writer.println("</body>");
		writer.println("</html>");
		
		writer.close(); //이 작업을 안하면 페이지가 안만들어진다.
		
		
		//4. 브라우저가 자바 파일(서블릿(알바생))을 호출한다.
		//- http://localhost:8090/ServletTest/servlet/com.test.servlet.Ex02
		//- http://localhost:8090/ServletTest > 예약어처럼 반드시 들어간다.
		//- http://localhost:8090/ServletTest/aaa
		
		
		//이클립스
		//- 서블릿에서 Ctrl + F11을 누르면 이클립스가 해당 서블릿에 매핑되어 있는 가상 주소를 대신 브라우저를 통해서 호출해준다.
		
	}

}

























