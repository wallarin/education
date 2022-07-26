<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	int dan = 2;

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
	
		<h1>out</h1>
		
		<h2>구구단 - 스트립틀릿 + 표현식 사용</h2>
		
		<!-- 스파게티 코드에 익숙해지는게 좋을 수도 있다. -->
		<% for (int i=1; i<=9; i++) { %>
		<div><%= dan %> x <%= i %> = <%= dan*i %></div>
		<% } %>
		
		<h2>구구단 - 스트립틀릿 + out 객체 사용</h2>
		<%
			for (int i=1; i<=9; i++) {
				out.println(String.format("<div>%d x %d = %d</div>", dan, i, dan * i));
			}
		%>
		
	</div>
	
	<script>
	
	</script>

</body>
</html>




















