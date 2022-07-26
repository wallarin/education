<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	request.setCharacterEncoding("UTF-8");

	String width = request.getParameter("width");
	String height = request.getParameter("height");
	String text = request.getParameter("text");
	String backgroundcolor = request.getParameter("backgroundcolor");
	String fontcolor = request.getParameter("fontcolor");
	String fontsize = request.getParameter("fontsize");
	int ea = Integer.parseInt(request.getParameter("ea"));
	String leftran = request.getParameter("leftran");
	String topran = request.getParameter("topran");
	String rb = request.getParameter("rb");
	String borderwidth = request.getParameter("borderwidth");
	String bordercolor = request.getParameter("bordercolor");
	String borderstyle = request.getParameter("borderstyle");
	String borderradius = request.getParameter("borderradius");
	
	

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터 전송받기 실습페이지</title>
<style>
	#content, #topcon {
		border: 1px solid #ddd;
		
	}

	#topcon {
		text-align: center;
		font-weight: bold;
		padding: 5px 0;
		width: 700px;
	}
	
	#content {
		padding: 40px 50px;
		text-align: center;
		width: 600px;
	}
	
	.btn {
		width: <%= width %>px;
		height: <%= height %>px;
		background-color: <%= backgroundcolor %>;
		color: <%= fontcolor %>;
		font-size: <%= fontsize %>px;
		margin: <%= topran %>px <%= leftran %>px;
		border-width: <%= borderwidth %>px;
		border-color: <%= bordercolor %>;
		border-style: <%= borderstyle %>;
		border-radius: <%= borderradius %>px;
	}
	
	.btn:hover {
		cursor: pointer;
	}
</style>
<script src="https://kit.fontawesome.com/e4f03f4c6c.js" crossorigin="anonymous"></script>
</head>
<body>

	<h1>결과</h1>
	
	<div id="topcon">버튼</div>
	<div id="content">
		<% for (int i=1; i<=ea; i++) { %>
			<button class="btn">
				<% if (!rb.equals("nope")) { %>
					
					<i class="fa-solid fa-<%= rb %>"></i>
					
				<% } %>
				<%= text %>
			</button>
		<% } %> 
	</div>

</body>
</html>








