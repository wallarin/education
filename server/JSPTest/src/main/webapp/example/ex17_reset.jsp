<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/example/inc/asset.jsp" %>
<style>

</style>
</head>
<body>

	<div class="container">
		<h1>세션 초기화하기</h1>
		<%
			//세션 자체를 처음 모습으로 초기화
			session.invalidate(); //여태까지 저장되어있던 모든 데이터가 삭제된다.
		%>
		<a href="ex17_session.jsp">시작 페이지</a>
	</div>
	
	<script>
	
	</script>

</body>
</html>




















