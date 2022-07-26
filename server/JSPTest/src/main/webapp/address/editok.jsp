<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.test.jsp.DBUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	//1. 인코딩
	request.setCharacterEncoding("UTF-8");

	//2.데이터 가져오기
	String name = request.getParameter("name");
	String age = request.getParameter("age");
	String gender = request.getParameter("gender");
	String tel = request.getParameter("tel");
	String address = request.getParameter("address");
	
	String seq = request.getParameter("seq");
	
	
	int result = 0;
	
	try {
		//3. DB 작업
		//	3.1 DB 연결
		DBUtil util = new DBUtil();
		
		Connection conn = null;
		Statement stat = null;
		PreparedStatement pstat = null;
		
		conn = util.open();
		
		//System.out.println(conn.isClosed()); //false가 나와야함 > 접속된 상태
		
		//	3.2 SQL
		String sql = "update tblAddress set name = ?, age = ?, address= ?, gender = ?, tel = ? where seq = ?";
		
		pstat = conn.prepareStatement(sql);
		
		pstat.setString(1, name);
		pstat.setString(2, age);
		pstat.setString(3, address);
		pstat.setString(4, gender);
		pstat.setString(5, tel);
		pstat.setString(6, seq);
		
		//	3.3 종료
		result = pstat.executeUpdate();
		
		
		//4. 마무리(feedback)
		if (result > 0) {
			//추가 성공
		} else {
			//추가 실패
		}
		
	} catch (Exception e) {
		System.out.println(e);
	}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소록</title>
<%@ include file="/address/inc/asset.jsp" %>
<style>

</style>
</head>
<body>

	<main>
		<header>
			<%@ include file="inc/header.jsp" %>
		</header>
		<section>
			<div class="section content">
				
				
				<!-- CASE 2. -->
				<%-- 
				<% if (result > 0) { %>
				
				<div>수정 성공!!</div>
				<a href="list.jsp">목록 보기</a>
				
				<% } else { %>
				
				<div>수정 실패;;</div>
				<!-- 페이지 이동을 안할때 # or #!를 붙이면 이동을 안한다 -->
				<a href="#!" onclick="history.back();">돌아가기</a>
				
				<% } %> 
				--%>
				
			</div>
		</section>
	</main>
	
	<script>
		
		<%-- 
		//CASE 1.
		<% if (result > 0) { %>
		
		alert('수정 성공');
		location.href = 'list.jsp';
		
		<% } else { %>
		
		alert('수정 실패');
		history.back();
		
		<% } %> 
		--%>
		
		//요즘에 많이 사용하는 방식
		//CASE 3.
		<% if (result > 0) { %>
		location.href = 'list.jsp';
		
		<% } else { %>
		
		alert('수정 실패');
		history.back();
		
		<% } %> 
	
	</script>

</body>
</html>




















