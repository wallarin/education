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

			<h2>Board</h2>
			
			<c:if test="${map.isSearch == 'y'}">
			<div style="text-align:center; margin-bottom: 5px; color: cornflowerblue;">
				'${map.word}'으로 검색한 결과 총 ${list.size()}개의 게시물이 발견되었습니다.
			</div>
			</c:if>
			
			<table class="table table-boarder horizontal">
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>글쓴이</th>
					<th>날짜</th>
					<th>조회수</th>
				</tr>
				<c:forEach items="${list}" var="dto">
				<%-- <c:if test="${dto.readcount < 10}">
				<tr>
				</c:if>
				<c:if test="${dto.readcount >= 10}">
				<tr style="background-color: gold;"> 
				</c:if> --%>
				<tr>
					<td>${dto.seq}</td>
					<td>
					
						<c:if test="${dto.depth > 0}">
						<i class="fa-solid fa-right-long" style="margin-left: ${dto.depth * 20}px;"></i>
						</c:if>
						<a href="/toy/board/view.do?seq=${dto.seq}&isSearch=${map.isSearch}&column=${map.column}&word=${map.word}">${dto.subject} 
						<c:if test="${dto.commentcount > 0}">
						<span class="badge badge-primary">${dto.commentcount}</span>
						</c:if></a>
						
						<c:if test="${not empty dto.filename}">
						<i class="fa-solid fa-floppy-disk"></i>
						</c:if>
						
						<c:if test = "${(dto.isnew * 24) < 1}">
						<span style="color:tomato; font-weight:bold;">new</span>
						</c:if>
						
					</td>
					<td>${dto.name}</td>
					<td>${dto.regdate}</td>
					<td>${dto.readcount}</td>
				</tr>
				</c:forEach>
				<c:if test="${list.size() == 0}">
				<tr>
					<td colspan="5">게시물이 없습니다.</td>
				</tr>
				</c:if>
			</table>
			
			<div style="text-align: center;">
				<%-- <select id="pagebar">
					<c:forEach var ="i" begin="1" end="${totalPage}">
					<option value="${i}">${i}페이지</option>
					</c:forEach>
				</select> --%>
				${pagebar}
			</div>
			
			<div>
				<form method="GET" action="/toy/board/list.do">
					<table class="search">
						<tr>
							<td>
								<select name="column" class="form-control">
									<option value="subject">제목</option>
									<option value="content">내용</option>
									<option value="name">글쓴이</option>
								</select>
							</td>
							<td>
								<input type="text" name="word" class="form-control" required>
							</td>
							<td>
								<button class="btn btn-primary">
									검색하기
								</button>
								
								<c:if test="${map.isSearch == 'y'}">
								<button class="btn btn-secondary" type="button" onclick="location.href='/toy/board/list.do';">
									검색중단하기
								</button>
								</c:if>
							</td>
						</tr>
					</table>
				</form>
			</div>
			
			<c:if test="${not empty auth}">
			<div class="btns">
				<input type="button" value="글쓰기" class="btn btn-primary" onclick="location.href='/toy/board/add.do';">
			</div>
			</c:if>

		</section>
	</main>
		
	<script>
		<c:if test="${map.isSearch == 'y'}">
			$('select[name=column]').val('${map.column}');
			$('input[name=word]').val('${map.word}');
		</c:if>
		
		$("#pagebar").change(function() {
			
			location.href = '/toy/board/list.do?page=' + $(this).val() + "&column={map.column}&word=${map.word}";
			
		});
		
		$("#pagebar").val(${nowPage});
		
	</script>

</body>
</html>




















