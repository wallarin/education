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

	form {
		display: flex;
	}
	
	form input[name=query] {
		width: 300px;
		margin-right: 5px;
	}

	.table th, .table td { text-align: center; }
	.table th:nth:child(1) { width: 120px; }
	.table th:nth:child(2) { width: auto; }
	.table th:nth:child(3) { width: 120px; }
	.table th:nth:child(4) { width: 100px; }
	.table th:nth:child(5) { width: 120px; }
	.table th:nth:child(6) { width: 120px; }

</style>
</head>
<body>

	<main>
		<%@ include file="/WEB-INF/views/inc/header.jsp" %>
		<section>
			<h2>Naver Books</h2>
			
			<div class="well well-sm">
				<form method="GET" action="/toy/etc/openapi02.do">
					<input type="text" name="query" class="form-control" placeholder="검색어를 입력하세요." required value="${rdto.query}">
					<input type="submit" value="검색하기" class="btn btn-primary">
				</form>
			</div>
			
			<hr>
			
			<table class="table table-bordered">
				<tr>
					<th>표지</th>
					<th>제목</th>
					<th>저자</th>
					<th>가격</th>
					<th>출판사</th>
					<th>출간일</th>
				</tr>
				<c:forEach items="${rdto.list}" var="dto">
				<tr>
					<td><img src="${dto.image}"></td>
					<td><a href="${dto.link}" target="_blank">${dto.title}</a></td>
					<td>${dto.author}</td>
					<td>
						<div>${dto.discount}원</div>
						<div style="text-decoration: line-through;">${dto.price}원</div>
					</td>
					<td>${dto.publisher}</td>
					<td>${dto.pubdate}</td>
				</tr>
				</c:forEach>
				<c:if test="${rdto.list.size() == 0 }">
				<tr>
					<td colspan="6">검색 결과가 존재하지 않습니다.</td>
				</tr>
				</c:if>
			</table>
			
			<hr>
			
			
			<c:forEach var="i" begin="1" end="${rdto.totalPage}">
			<%-- <c:forEach var="i" begin="1" end="${Math.ceil(rdto.total/10)}"> --%>
				<a href="/toy/etc/openapi02.do?page=${i}&query=${rdto.query}">${i}</a>
			</c:forEach>
			
		</section>
	</main>
		
	<script>
	
	</script>

</body>
</html>




















