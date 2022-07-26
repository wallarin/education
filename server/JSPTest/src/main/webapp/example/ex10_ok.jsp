<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	//한글 인코딩
	request.setCharacterEncoding("UTF-8");

	//텍스트 박스의 값 받아오기
	//1. 입력하면 > 입력값 반환
	//2. 입력 안하면 > 빈 문자열("") 반환
	String txt1 = request.getParameter("txt1");
	
	//암호 박스 값 받아오기
	String txt2 = request.getParameter("txt2");
	
	//다중 텍스트
	String txt3 = request.getParameter("txt3");
	txt3 = txt3.replace("\r\n", "<br>");
	
	
	//체크 박스
	//1. value에 값이 지정되어 있을 때 (권장)
	//	- 체크했을때에는 > value 값을 반환
	//	- 체크를 안했을 떄 > null 반환
	
	//2. value에 값이 지정되어 있지 않을 때(비권장)
	//	- 체크O > "on"반환
	//	- 체크X > "null"반환
	String cb1 = request.getParameter("cb1");
	String cb2 = request.getParameter("cb2");
	
	
	//체크박스들
	String cb3 = request.getParameter("cb3");
	String cb4 = request.getParameter("cb4");
	String cb5 = request.getParameter("cb5");
	
	String temp = cb3 + ", " + cb4 + ", " + cb5;
	
	temp = "";
	
	for (int i=6; i<=8; i++) {
		temp += request.getParameter("cb" + i) + ",";
	}
	
	
	//같은 name을 여러개 가져올 때
	//request.getParameterValues로 값을 가져온다.
	//가져와진 값은 배열로 이루어져 있다.
	String[] cb9 = request.getParameterValues("cb9");
	
	
	//라디오 버튼
	String rb = request.getParameter("rb");
	
	//셀렉트 박스
	String sel1 = request.getParameter("sel1");
	
	//셀렉트 박스
	String[] sel2 = request.getParameterValues("sel2");
	
	//히든 태그
	String id = request.getParameter("id");
	
	//color 태그
	String color = request.getParameter("color");
	
	
	//좌표
	String left = request.getParameter("left");
	String top = request.getParameter("top");
	

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	<%-- body {
		background-color: <%= color %>;
	} --%>
</style>
</head>
<body>

	<h1>결과</h1>
	
	<h3>텍스트 박스</h3>
	<div><%= txt1 %></div>
	
	<h3>암호 박스</h3>
	<div><%= txt2 %></div>
	
	<h3>다중 텍스트</h3>
	<div><%= txt3 %></div>
	
	
	<h3>체크 박스</h3>
	<div><%= cb1 %>, <%= cb2 %></div>
	
	<h3>체크 박스들</h3>
	<div><%= temp %></div>
	
	<h3>체크 박스들</h3>
	<div><%= Arrays.toString(cb9) %></div>
	
	
	<h3>라디오 버튼</h3>
	<div><%= rb %></div>
	
	<h3>셀렉트 박스</h3>
	<div><%= sel1 %></div>
	
	<h3>셀렉트 박스</h3>
	<div><%= Arrays.toString(sel2) %></div>
	
	<h3>히든 태그</h3>
	<div><%= id %></div>
	
	<h3>색상값</h3>
	<div><%= color %></div>
	
	<h3>좌표</h3>
	<div><%= left %>, <%= top %></div>
	

</body>
</html>











