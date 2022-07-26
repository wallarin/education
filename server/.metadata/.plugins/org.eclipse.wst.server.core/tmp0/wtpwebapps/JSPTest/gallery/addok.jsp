<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="com.test.jsp.DBUtil"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	request.setCharacterEncoding("UTF-8");

	String path = application.getRealPath("/gallery/images");
	
	int size = 1024 * 1024 * 500;
	
	String subject = "";
	String attach = "";
	
	int result = 0;
	
	try {
		
		MultipartRequest multi = new MultipartRequest (
										request,
										path,
										size,
										"UTF-8",
										new DefaultFileRenamePolicy());
				
		subject = multi.getParameter("subject");
		attach = multi.getFilesystemName("attach");
			
		Connection conn = null;
		Statement stat = null;
		PreparedStatement pstat = null;
		
		conn = DBUtil.open();
		
		String sql = "insert into tblGallery (seq, filename, subject) values (seqGallery.nextval, ?, ?)";
		
		pstat = conn.prepareStatement(sql);
		
		pstat.setString(1, attach);
		pstat.setString(2, subject);
		
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
			alert('업로드 실패!!');
			history.back();
		<% } %>
	</script>

</body>
</html>







