<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	request.setCharacterEncoding("UTF-8");
	
	String path = application.getRealPath("/example/images");
	
	int size = 1024 * 1024 * 100;
	
	String filename = "";
	
	try {
		
		MultipartRequest multi = new MultipartRequest(
											request,
											path,
											size,
											"UTF-8",
											new DefaultFileRenamePolicy());
		
		//업로드한 이미지명 > DB 저장
		//filename = multi.getFilesystemName("attach");
		
	} catch (Exception e) {
		System.out.println(e);
	}
	
	//사용자들은 어차피 다시 이전페이지로 돌아가서 업로드된 이미지를 보러 가기 때문에 현재 페이지는 업로드 처리만 하고 사용자에게 보여줄 필요성은 없다.
	response.sendRedirect("ex20_file_form.jsp");

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
		이미지 업로드를 완료했습니다.
	</div>
	
	<script>
	
	</script>

</body>
</html>




















