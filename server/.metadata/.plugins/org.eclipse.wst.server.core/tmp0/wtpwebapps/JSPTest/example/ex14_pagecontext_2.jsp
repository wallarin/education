<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	int num = (int)request.getAttribute("num"); //에러가 발생된다.
	//int num = 100; //아래에 에러때문에 넣어놓음
	
	System.out.println(request.getAttribute("num"));

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
		<h1>2번 페이지</h1>
		<div>num: <%= num %></div>
	</div>
	
	<script>
	
	</script>

</body>
</html>




















