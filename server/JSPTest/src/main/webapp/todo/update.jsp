<%@page import="com.test.jsp.DBUtil"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	String seq = request.getParameter("seq");
	String complete = request.getParameter("complete");
	
	if (complete.equals("n")) {
		complete = "y";
	} else {
		complete = "n";
	}
	
	int result = 0;
	
	try {
	
		Connection conn = null;
		PreparedStatement pstat = null;
		
		conn = DBUtil.open();
		
		String sql = "update tblTodo set complete = ? where seq = ?";
		
		pstat = conn.prepareStatement(sql);
		
		pstat.setString(1, complete);
		pstat.setString(2, seq);
		
		result = pstat.executeUpdate();
	
	} catch (Exception e) {
		System.out.println(e);
	}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정하기</title>
<%@ include file="/todo/inc/asset.jsp" %>
<style>

</style>
</head>
<body>

	<div class="container">
	
	</div>
	
	<script>
		<% if (result > 0) { %>
			location.href='list.jsp';
		<% } else { %>
			alert('오류로 수정에 실패하였습니다.');
			history.back();
		<% } %>
	
	</script>

</body>
</html>




















