<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Toy Project</title>
<%@ include file="/WEB-INF/views/inc/asset.jsp" %>
<style>

</style>
</head>
<body>

	<main>
		<%@ include file="/WEB-INF/views/inc/header.jsp" %>
		<section>
			<h2>기존방식</h2>
			
			<div>
				<input type="text" id="text1" value="${cnt}" readonly>
				<input type="button" value="확인" id="btn1" onclick="location.href='/toy/ajax/ex02data.do';">
			</div>
			<div>
				<input type="text">
			</div>
			
			<h2>Ajax 방식</h2>
			<!--  -->
			<div>
				<input type="text" id="txt2" readonly>
				<input type="button" value="확인" id="btn2" onclick="test();">
			</div>
			<div>
				<input type="text">
			</div>
			
			<h3>Ajax 방식</h3>
			<input type="button" value="확인" id="btn3" onclick="test2();">
			<span id="txt3"></span>
			
		</section>
	</main>
		
	<script>
	
		function test() {
		
			//Ajax 통신을 지원하는 자바스크립트 객체
			ajax = new XMLHttpRequest();
			
			//alert(ajax);
			if (ajax != null) {
				
				//서버에게 데이터 요청
				ajax.onreadystatechange = m1;
				ajax.open('GET', '/toy/ajax/ex02data2.do');
				ajax.send(); //<input type="submit">
				
			} else {
				alert('접속한 브라우저가 XMLHttpRequest를 지원하지 않습니다.');
			}
			
		}
		
		function m1() {

			if (ajax.readyState == 4 && ajax.status == 200) {
				//서버에게 요청한 뒤 돌려받은 데이터
				//alert(ajax.responseText);
				$('#txt2').val(ajax.responseText);
			} 
			
		}
		
		
		
		function test2() {
			
			ajax = new XMLHttpRequest();
			
			ajax.onreadystatechange = m2;
			
			//ajax.open('GET', '/toy/data.txt');
			//ajax.open('GET', '/toy/data.xml');
			//ajax.open('GET', '/toy/data.json');
			//ajax.open('GET', '/toy/data.do');
			
			ajax.open('GET', '/toy/data.txt');
			
			ajax.send();
			
		}
		
		function m2() {
			
			console.log('ajax.readyState', ajax.readyState);
			console.log('ajax.status', ajax.status);
			
			//데이터를 받아오는 시점 && 200(성공) 상태인지 확인후
			if (ajax.readyState == 4 && ajax.status == 200) {
				console.log(ajax.responseText);
				
				//ajax.responseText > 단일 데이터를 가져올 때 사용
				//ajax.responseXML > 다중 데이터를 가져올 때 사용
				
				$('#txt3').text(ajax.responseText);
			}
			
			console.log('');
			//http state code
			
		}
		
	</script>

</body>
</html>




















