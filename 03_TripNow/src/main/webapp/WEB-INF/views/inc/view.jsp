<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Toy Project</title>
<%@ include file="/WEB-INF/views/inc/asset.jsp" %>
<link rel="stylesheet" href="/toy/asset/css/tagify.css" />
<script src="/toy/asset/js/jQuery.tagify.min.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=4b2c4452052d56d04184af646057bc11"></script>
<style>
	
	tr:last-child form {
	 	margin-right: 5px;
	}
	
	
	<c:if test="${not empty dto.goodbad}">
	#btngood, #btnbad {
		opacity: .5;
	}
	</c:if>
	
	<c:if test="${empty dto.goodbad}">
	#btngood, #btnbad {
		opacity: 1;
	}
	</c:if>
	
	
	<c:if test="${not empty lat}">
	#map {
		width: 100%;
		height: 400px;
	}
	</c:if>
	
</style>
</head>
<body>

	<main>
		<%@ include file="/WEB-INF/views/inc/header.jsp" %>
		<section>
			
			<h2>Board</h2>
			
			
			<table class="table table-bordered vertical">
				<tr>
					<th>제목</th>
					<td>${dto.subject}</td>
				</tr>
				<tr>
					<th>내용</th>
					<td style="height: 300px; vertical-align: middle;">${dto.content}</td>
				</tr>
				<tr>
					<th>이름</th>
					<td>${dto.name}(${dto.id})</td>
				</tr>
				<tr>
					<th>날짜</th>
					<td>${dto.regdate}</td>
				</tr>
				<tr>
					<th>읽음</th>
					<td>${dto.readcount}</td>
				</tr>
				<tr>
					<th>번호</th>
					<td>${dto.seq}</td>
				</tr>
				<tr>
					<th>파일</th>
					<td>
						
						<c:if test="${not empty dto.orgfilename}">
						<a href="/toy/board/download.do?filename=${dto.filename}&orgfilename=${dto.orgfilename}">${dto.orgfilename}</a>
						</c:if>
						
						<c:if test="${empty dto.orgfilename}">
						파일 없음
						</c:if>
						
					</td>
				</tr>
				<tr>
					<th>태그</th>
					<td><input type="text" name="tags" readonly></td>
				</tr>
				<tr>
					<th>좋아요/싫어요</th>
					<td style="display: flex;">
						
						<form method="GET" action="/toy/board/goodbad.do">
						<button class="btn btn-danger" id="btngood">
							<i class="fa-solid fa-heart"></i>
							좋아요
							<span class="badge badge-primary">${dto.good}</span>
						</button>
						<input type="hidden" name="seq" value="${dto.seq}">
						<input type="hidden" name="isSearch" value="${isSearch}">
						<input type="hidden" name="column" value="${column}">
						<input type="hidden" name="word" value="${word}">
						<input type="hidden" name="good" value="1">
						<input type="hidden" name="bad" value="0">
						</form>
						
						<form method="GET" action="/toy/board/goodbad.do">
						<button class="btn btn-dark" id="btnbad">
							<i class="fa-solid fa-heart-crack"></i>
							싫어요
							<span class="badge badge-primary">${dto.bad}</span>
						</button>
						<input type="hidden" name="seq" value="${dto.seq}">
						<input type="hidden" name="isSearch" value="${isSearch}">
						<input type="hidden" name="column" value="${column}">
						<input type="hidden" name="word" value="${word}">
						<input type="hidden" name="good" value="0">
						<input type="hidden" name="bad" value="1">
						</form>
						
					</td>
				</tr>
				<c:if test="${not empty lat}">
				<tr>
					<th>위치</th>
					<td><div id="map"></div></td>
				</tr>
				</c:if>
			</table>
			
			<div class="btns">
			
				
				<input type="button" value="돌아가기" class="btn btn-secondary"
					onclick="location.href='/toy/board/list.do?column=${column}&word=${word}';"> 
				
				<!-- <input type="button" value="돌아가기" class="btn btn-secondary"
					onclick="history.back();"> -->
					
					
				<c:if test="${not empty auth}">
				
				<c:if test="${dto.id == auth || auth == 'admin'}">
				<button class="btn btn-primary"
					onclick="location.href='/toy/board/edit.do?seq=${dto.seq}&isSearch=${isSearch}&column=${column}&word=${word}';">
					<i class="fas fa-pen"></i>
					수정하기
				</button>
				
				<button class="btn btn-primary"
					onclick="location.href='/toy/board/del.do?seq=${dto.seq}&isSearch=${isSearch}&column=${column}&word=${word}';">
					<i class="fas fa-pen"></i>
					삭제하기
				</button>
				</c:if>
				
				<button class="btn btn-primary" type="button"
					onclick="location.href='/toy/board/add.do?reply=1&thread=${dto.thread}&depth=${dto.depth}&isSearch=${isSearch}&column=${column}&word=${word}';">
					<i class="fas fa-pen"></i>
					답변쓰기
				</button>
				</c:if>
				
			</div>
			
			
			
			<!-- 댓글 -->
			
			<%--
			<form method="POST" action="/toy/board/addcommentok.do">
			<table class="tblAddComment">
				<tr>
					<td>
						<textarea class="form-control" name="content" required></textarea>
					</td>
					<td>
						<button class="btn btn-primary">
							<i class="fas fa-pen"></i>
							쓰기
						</button>
					</td>
				</tr>
			</table>
			<input type="hidden" name="pseq" value="${dto.seq}">
			
			<input type="hidden" name="isSearch" value="${isSearch}">
			<input type="hidden" name="column" value="${column}">
			<input type="hidden" name="word" value="${word}">
			</form>
			
			
			<table class="table table-bordered comment">
				<c:forEach items="${clist}" var="cdto">
				<tr>
					<td>
						<div>${cdto.content}</div>
						<div>
							<span>${cdto.regdate}</span>
							<span>${cdto.name}(${cdto.id})</span>
							<c:if test="${cdto.id == auth}">
							<span class="btnspan"><a href="#!" onclick="delcomment(${cdto.seq});">[삭제]</a></span>
							<span class="btnspan"><a href="#!" onclick="editcomment(${cdto.seq});">[수정]</a></span>
							</c:if>
						</div>
					</td>
				</tr>
				</c:forEach>
				
			</table>
			--%>
			
			
			
			<!-- 댓글 > Ajax 버전 -->
			<form id="addCommentForm">
			<table class="tblAddComment">
				<tr>
					<td>
						<textarea class="form-control" name="content" required></textarea>
					</td>
					<td>
						<button class="btn btn-primary" type="button" 
								onclick="addComment();">
							<i class="fas fa-pen"></i>
							쓰기
						</button>
					</td>
				</tr>
			</table>
			<input type="hidden" name="pseq" value="${dto.seq}">
			</form>
			
			
			<table class="table table-bordered comment">
				<c:forEach items="${clist}" var="cdto">
				<tr>
					<td>
						<div>${cdto.content}</div>
						<div>
							<span>${cdto.regdate}</span>
							<span>${cdto.name}(${cdto.id})</span>
							<c:if test="${cdto.id == auth}">
							<span class="btnspan"><a href="#!" onclick="delcomment(${cdto.seq});">[삭제]</a></span>
							<span class="btnspan"><a href="#!" onclick="editcomment(${cdto.seq});">[수정]</a></span>
							</c:if>
						</div>
					</td>
				</tr>
				</c:forEach>
				
			</table>
			
			
			
		</section>
	</main>
	
	<script>
	
		//<td> x 9개 -> <td> x 9개 이벤트 추가 -> 댓글 쓰기 -> 새로운 <td> x 1개 추가
	
		$('.table.comment td').mouseover(function() {
			$(this).find('.btnspan').show();
		});
		
		$('.table.comment td').mouseout(function() {
			$(this).find('.btnspan').hide();
		});
		
		
		/*
		function delcomment(seq) {
			
			if (confirm('delete?')) {
				
				location.href = 'delcommentok.do?seq=' + seq + '&pseq=${dto.seq}&isSearch=${isSearch}&column=${column}&word=${word}';
			}
			
		}
		*/
		
		
		function delcomment(seq) {
			
			//$(event.target).parents('tr').remove();
			let tr = $(event.target).parents('tr');
			
			
			if (confirm('delete?')) {
				
				$.ajax({
					
					type: 'POST',
					url: '/toy/board/delcommentajaxok.do',
					data: 'seq=' + seq,
					dataType: 'json',
					success: function(result) {
						
						if (result.result == "1") {
							
							//$(event.target).parents('tr').remove();
							tr.remove();
							
						} else {
							alert('failed');
						}
						
					},
					error: function(a,b,c) {
						console.log(a,b,c);
					}
					
				});				
				
			}
			
		}
		
		
		
		let isEdit = false; 
		
		function editcomment(seq) {
			
			if (!isEdit) {
				
				const tempStr = $(event.target).parent().parent().prev().text();
				
				$(event.target).parents('tr').after(temp);
				
				isEdit = true;
				
				$(event.target).parents('tr').next().find('textarea').val(tempStr);
				$(event.target).parents('tr').next().find('input[name=seq]').val(seq);
			}
			
		}
		
		
		/*
		const temp = `<tr id='editRow' style="background-color: #CDCDCD;">
						<td>
							<form method="POST" action="/toy/board/editcommentok.do">
							<table class="tblEditComment">
								<tr>
									<td>
										<textarea class="form-control" name="content" required></textarea>
									</td>
									<td>
										<button class="btn btn-secondary" type="button"
											onclick="cancelForm();">
											취소하기
										</button>
										<button class="btn btn-primary">
											<i class="fas fa-pen"></i>
											수정하기
										</button>
									</td>
								</tr>
							</table>
							<input type="hidden" name="pseq" value="${dto.seq}">
							
							<input type="hidden" name="isSearch" value="${isSearch}">
							<input type="hidden" name="column" value="${column}">
							<input type="hidden" name="word" value="${word}">
							
							<input type="hidden" name="seq">
							</form>
						</td>
					</tr>`;
	
		*/
		
		const temp = `<tr id='editRow' style="background-color: #CDCDCD;">
						<td>
							<form id="editCommentForm">
							<table class="tblEditComment">
								<tr>
									<td>
										<textarea class="form-control" name="content" required id="txtcontent"></textarea>
									</td>
									<td>
										<button class="btn btn-secondary" type="button"
											onclick="cancelForm();">
											취소하기
										</button>
										<button class="btn btn-primary" type="button"
												onclick="editComment();">
											<i class="fas fa-pen"></i>
											수정하기
										</button>
									</td>
								</tr>
							</table>
							
							<input type="hidden" name="seq">
							</form>
						</td>
					</tr>`;
					
		function cancelForm() {
			$('#editRow').remove();
			isEdit = false;
		}
		
		
		//img.onload = function() {}
		/*
		$('#imgAttach').ready(function() {
		
			//alert($('#imgAttach').width());
			
			if ($('#imgAttach').width() > 630) {
				$('#imgAttach').width(630);
			}
			
			$('#imgAttach').show();
			
		});
		*/
		
		let tag = '';
		
		<c:forEach items="${dto.taglist}" var="tag">
			tag += '${tag},';
		</c:forEach>
		
		//alert(tag);
		
		$('input[name=tags]').val(tag);
		/* 
		$('input[name=tags]').tagify().on('click', function(e) {
			alert(e.detail);
		}); 
		*/
		
		const tagify = new Tagify(document.querySelector('input[name=tags]'), {});
		
		tagify.on('click', test);
		
		function test(e) {
			//alert(e.detail.data.value);
			
			location.href = '/toy/board/list.do?tag=' + e.detail.data.value;
		}
		
		
		
		
		
		
		<c:if test="${not empty lat}">
		
			var container = document.getElementById('map');
			
			var options = {
				center: new kakao.maps.LatLng(${lat}, ${lng}),
				level: 3
			};
		
			var map = new kakao.maps.Map(container, options);
			
			var m = new kakao.maps.Marker({
				position: new kakao.maps.LatLng(${lat}, ${lng})
			});
			
			m.setMap(map);
			
		</c:if>
		
		
		
		
		//댓글 쓰기(Ajax)
		function addComment() {
			
			$.ajax({
				type: 'POST',
				url: '/toy/board/addcommentajaxok.do',
				data: $('#addCommentForm').serialize(),
				dataType: 'json',
				success: function(result) {
					if (result.result == "1") {
						//성공 > 새로 작성된 댓글을 목록에 반영하기
						
						let temp = `<tr>
										<td>
											<div>\${$('[name=content]').val()}</div>
											<div>
												<span>\${result.regdate}</span>
												<span>\${result.name}(\${result.id})</span>
												<span class="btnspan"><a href="#!" onclick="delcomment(\${result.seq});">[삭제]</a></span>
												<span class="btnspan"><a href="#!" onclick="editcomment(\${result.seq});">[수정]</a></span>
											</div>
										</td>
									</tr>`;
						
									
						if ($('.comment tbody').length == 0) {
							$('.comment').append('<tbody></tbody>');
						}
						
						$('.comment tbody').prepend(temp);
						
						
						$('[name=content]').val('');
						
						
						$('.table.comment td').mouseover(function() {
							$(this).find('.btnspan').show();
						});
						
						$('.table.comment td').mouseout(function() {
							$(this).find('.btnspan').hide();
						});
						
						
					} else {
						//실패
						alert('failed');						
					}
				},
				error: function(a,b,c) {
					console.log(a,b,c);
				}
			});
			
		}
		
		
		
		function editComment() {
			
			
			//alert($('#editRow').prev().children().eq(0).children().eq(0).text());
			//alert($('textarea[name=content]').val());
			
			$.ajax({
				
				type: 'POST',
				url: '/toy/board/editcommentajaxok.do',
				data: $('#editCommentForm').serialize(),
				dataType: 'json',
				success: function(result) {
					
					if (result.result == "1") {
						
						//수정된 댓글을 화면에 반영하기
						//$('textarea[name=content]').val()
						$('#editRow').prev().children().eq(0).children().eq(0).text($('#txtcontent').val());
						
						$('#editRow').remove();
						
					} else {
						alert('failed');
					}
					
				},
				error: function(a,b,c) {
					console.log(a,b,c);
				}
				
			});
			
		}
		

	</script>

</body>
</html>


























