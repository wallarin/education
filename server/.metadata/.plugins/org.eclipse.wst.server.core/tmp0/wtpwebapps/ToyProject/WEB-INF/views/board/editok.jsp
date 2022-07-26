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
			콘텐츠
		</section>
	</main>
		
	<script>
	
		<c:if test="${result == 1}">
		location.href = '/toy/board/view.do?seq=${seq}&isSearch=${isSearch}&column=${column}&word=${word}';
		</c:if>
		
		<c:if test="${result == 0}">
		alert('failed');
		history.back();
		</c:if>
	</script>

</body>
</html>




















