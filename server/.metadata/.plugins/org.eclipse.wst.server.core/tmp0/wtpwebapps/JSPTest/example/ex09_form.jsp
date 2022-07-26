<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	form > div {
		margin-bottom: 5px;
	}
</style>
</head>
<body>

	<h1>데이터 보내기</h1>
	
	<h2>폼태그 + POST 방식으로 보내기</h2>
	<!-- 보내주는 값의 길이가 크면 POST로 쓰는게 아주 좋다. -->
	<form method="POST" action="ex09_ok.jsp">
		
		<div>
			문자: <input type="text" name="txt">
		</div>
		<div>
			숫자: <input type="number" name="num">
		</div>
		<div>
			<input type="submit" value="보내기">
		</div>
		
	</form>
	
	<h2>폼태그 + GET 방식으로 보내기</h2>
	<!-- 장점이 없음에도 불구하고 쓰는데에는 이유가 있다.! -->
	<form method="GET" action="ex09_ok.jsp">
		
		<div>
			문자: <input type="text" name="txt">
		</div>
		<div>
			숫자: <input type="number" name="num">
		</div>
		<div>
			<input type="submit" value="보내기">
		</div>
		
	</form>
	
	
	<h2>GET 방식으로 데이터 전달하기</h2>
	
	<a href="ex09_ok.jsp?txt=홍길동&num=123">페이지 이동하기</a>
	
	<input type="button" value="페이지 이동하기" onclick="test();">
	
	<script>
	
		function test() {
			//Get 방식으로 넘긴걸로 인식한다.
			location.href = "ex09_ok.jsp?txt=호호호&num=222";
		}
	
	</script>

</body>
</html>
























