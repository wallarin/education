<%@page import="com.test.jsp.Util"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!

	//선언부 > 클래스 안 > 클래스 영역
	public int b = 20; //클래스 멤버 변수 > 쓸 일은 없다.
	
	public int sum(int a, int b) {
		
		return a + b;
		
	}

%>
<%
	//스크립틀릿 > 메소드 안 > 메소드 영역
	
	//자바 영역이지만 > 우리가 생각하는 평범한 자바 영역은 아니다..
	
	/* public int sum(int a, int b) {
	
		return a + b;
	
	} */
	
	//변수 종류? 클래스 멤버 변수 or 지역 변수
	int a = 10; //< 어떤 메소드의 지역변수이다.
	
	
	Util util = new Util();

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>선언부</h1>
	
	<div>sum(10, 20) = <%= sum(10, 20) %></div>
	<div>sum(100, 200) = <%= sum(100, 200) %></div>
	<hr>
	<div>util.sum(1000, 2000) = <%= util.sum(1000, 2000) %></div>

</body>
</html>





















