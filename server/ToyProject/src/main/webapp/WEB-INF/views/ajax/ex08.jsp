<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Toy Project</title>
<%@ include file="/WEB-INF/views/inc/asset.jsp" %>
<script src="/toy/asset/js/jquery-ui.js"></script>
<style>

</style>
</head>
<body>

	<main>
		<%@ include file="/WEB-INF/views/inc/header.jsp" %>
		<section>
			<h2>jQuery + Ajax</h2>	
			
			<img src="/toy/asset/images/catty01.png" class="drag" id="cat01">
			<img src="/toy/asset/images/catty02.png" class="drag" id="cat02">
			<img src="/toy/asset/images/catty03.png" class="drag" id="cat03">

		</section>
	</main>
		
	<script>
		
		$('.drag').draggable({
			stop: function(event, ui) {
				//정보
				let id = this.id;
				let x = ui.position.left;
				let y = ui.position.top;
				
				//alert(id + ',' + x + ',' + y);
				$.ajax({
					
					type: 'POST',
					url: '/toy/ajax/ex08data.do',
					data: 'id=' + id + '&x=' + x + '&y=' + y,
					dataType: 'json',
					success: function(result) {
						
						if (result.result == "1") {
							
						}
						
					},
					error: function(a,b,c) {
						console.log(a,b,c);
					}
					
				});
			}
		});
		
		
		<c:forEach items="${list}" var="dto">
		$('#${dto.id}').css({
			left: '${dto.left}px',
			top: '${dto.top}px'
		});
		</c:forEach>
	
	</script>

</body>
</html>




















