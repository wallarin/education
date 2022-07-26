<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%

	//클라이언트 -> (데이터 전송) -> 서버
	//1. GET
	//	- URL에 붙여서 전송 > 톰캣 관련
	//	- UTF-8로 동작해진다.
	//	- <form method="GET">	사용되는 경우가 적다.
	//	- 링크, location > URL을 사용하는 경우 이용된다.
	
	
	//ex09_ok.jsp?txt=홍길동&num=123
	//- ex09_ok.jsp > 페이지 주소
	//- ? > 이후부터 첨부 데이터입니다.(구분자로써의 기능을 수행한다.)
	//- txt=홍길동&num=123 > 전송 데이터
	//	- txt=홍길동 > key=value
	//	- & > 구분자
	//	- num=123
	
	
	//?txt=홍길동&num=123
	// > QueryString(***)이라고 불린다.
	
	
	//2. POST
	//	- 패킷 본문에서 전송
	//	- ISO-8859-1 동작
	//	- <form method="POST"> 
	//	- 보내는 방식이 무조건 form태그를 만들어서 보내야한다.
	
	
	//수신되는 데이터의 인코딩 처리하기
	// > 이후에 request.getParameter()가 UTF-8로 동작한다.
	request.setCharacterEncoding("UTF-8");
	
	
	

	//데이터 수신하기
	//- request가 하는 일 중 하나이다.
	//- String request.getParammeter(String key)
	//	클라이언트 > 서버로 전송된 모든 데이터를 수신한다.
	String txt = request.getParameter("txt");
	String num = request.getParameter("num");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	div {
		margin-bottom: 5px;
	}
</style>
</head>
<body>

	<h1>데이터 받기</h1>
	
	<div>
		문자: <%= txt %>	
	</div>
	<div>
		문자: <%-- <%= txt.length() %> --%>
	</div>
	<div>
		숫자: <%= num %>
	</div>

</body>
</html>




















