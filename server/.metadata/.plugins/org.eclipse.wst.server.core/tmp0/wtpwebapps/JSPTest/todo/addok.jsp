<%@page import="com.test.jsp.DBUtil"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	String todo = request.getParameter("todo");
	String priority = request.getParameter("priority");
	
	int result = 0;
	
	try {
		
		Connection conn = null;
		Statement stat = null;
		PreparedStatement pstat = null;
		
		conn = DBUtil.open();
		
		String sql = "insert into tblTodo (seq, todo, priority) values (seqTodo.nextVal, ?, ?)";
		
		pstat = conn.prepareStatement(sql);
		
		pstat.setString(1, todo);
		pstat.setString(2, priority);
		
		result = pstat.executeUpdate();
		
	} catch (Exception e) {
		System.out.println(e);
	}
	
	System.out.println(todo);
	System.out.println(priority);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>할일 등록하기</title>
<%@ include file="/todo/inc/asset.jsp" %>
</head>
<body>

	<script>
		<% if (result > 0) { %>
		location.href = 'list.jsp';
		
		<% } else { %>
		
		alert('할일 등록에 실패하셨습니다.');
		history.back();
		
		<% } %> 
	
	</script>

</body>
</html>