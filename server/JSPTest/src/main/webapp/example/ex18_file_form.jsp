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
	
		<h1>파일 업로드</h1>
		
		<!-- 첨부파일 크기가 크기때문에 GET방식은 사용할 수 없다. 보낼 수 있는 크기가 작아서.. -->
		
		<!-- 
		
			파일 업로드
			1. <form method="POST">
			2. <form enctype="">
				a. application/x-www-form-urlencoded > 문자열 전송
				b. multipart/form-data > 문자열 + 비문자열 전송
		
		 -->
		<form method="POST" action="ex18_file_ok.jsp"
			enctype="multipart/form-data">
			
			<table class="table">
				<tr>
					<th>문자열</th>
					<td><input type="text" name="txt"></td>
				</tr>
				<tr>
					<th>숫자</th>
					<td><input type="number" name="num"></td>
				</tr>
				<tr>
					<th>파일</th>
					<td><input type="file" name="attach"></td>
				</tr>
			</table>
			
			<div>
				<input type="submit" value="등록하기"
					class="btn btn-primary">
			</div>
			
		</form>
	
	</div>
	
	<script>
	
	</script>

</body>
</html>




















