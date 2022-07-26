<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	String name = "홍길동";
	String age = "20";
	String color = "cornflowerblue";
	String txt = "<input type='text'>";
	String title = "<h2>제목입니다.</h2>";

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>표현식</h1>
	<!--
	
		표현식의 용도
		- 돌려줄 임시 페이지에 값을 출력한다.(HTML의 소스 일부가 된다.)
		- 자바의 값을 HTML 소스에 출력한다.
		1. 동적으로 PCDATA로 사용한다.
		2. css의 일부로 사용한다.
		3. JavaScript의 일부로 사용한다.

	-->
	
	<%= title %>
	<p>이름: <%= name %></p>
	<p>나이: <%= age %></p>
	<p style="color:<%= color %>">색상: <%= color %></p>
	<p><%= txt %></p>
	
	<script>
	
		alert('<%= name %>');	
	
	</script>

</body>
</html>
















