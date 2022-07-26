<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 

	물리 경로(실제 서버의 상태)
	- C:\class\server\JSPTest\src\main\webapp(공유 폴더) > ex01.jsp
	
	외부 환경 > 경로(다른 사람(브라우저)가 보는 상태
	- http://localhost:8090/JSPTest/ex01.jsp
	
	
	"http://localhost:8090/JSPTest" == "webapp"
	
	
	

	JSP 페이지 + HTML 태그 > 자원 경로(URL)
	1. 상대경로
	2. 절대경로
		- '/' > 'http://localhost:8090'

 -->

<!-- <link rel="stylesheet" href="../css/bootstrap.css" /> --> <!-- 상대경로 방식 -->
<link rel="stylesheet" href="<%= request.getContextPath() %>/example/css/bootstrap.css" /> <!-- 절대경로 방식 -->
<script src="<%= request.getContextPath() %>/example/js/jquery-1.12.4.js"></script>
<script src="<%= request.getContextPath() %>/example/js/bootstrap.js"></script>
<!-- 
컨텍스트 경로를 수정할 수도 있는 가능성이 있기 때문에 컨텍스트 경로 작성시 기본 경로 대신
//request.getContextPath()를 사용해서 변경하면 나중에 컨텍스트 경로 이름을 수정해도 정상적으로 작동한다. 
-->


























