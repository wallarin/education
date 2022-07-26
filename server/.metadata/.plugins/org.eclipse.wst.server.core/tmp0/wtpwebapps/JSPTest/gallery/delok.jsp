<%@page import="java.io.File"%>
<%@page import="com.test.jsp.DBUtil"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//폴더내 이미지 삭제
	request.setCharacterEncoding("UTF-8");
	String filename = request.getParameter("filename");

	String path = application.getRealPath("/gallery/images");
	
	File img = new File(path + "/" + filename);
	
	img.delete();
	
	
	//DB 삭제하기
	String seq = request.getParameter("seq");
	int result = 0;
	
	try {
		
		Connection conn = DBUtil.open();
		String sql = "delete from tblGallery where seq = ?";
		PreparedStatement pstat = conn.prepareStatement(sql);
		
		pstat.setString(1, seq);
		
		result = pstat.executeUpdate();
		
	} catch (Exception e) {
		System.out.println(e);
	}
	
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Image Gallery</title>
<%@ include file="/gallery/inc/asset.jsp" %>
</head>
<body>

	<script>
		<% if (result > 0) { %>
			location.href = 'list.jsp';
		<% } else { %>
			alert('삭제 실패!!');
			history.back();
		<% } %>
	</script>

</body>
</html>







