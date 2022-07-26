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
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=899a346481b7e6424e876fdab9897a08"></script>
<style>
	tr:last-child form {
		margin-right: 5px;
	}
	
	<c:if test="${not empty dto.goodbad}">
	#btngood, #btnbad {
		opacity: .65;
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
						<th>번호</th>
						<td>${dto.seq}</td>
					</tr>
					<tr>
						<th>제목</th>
						<td>${dto.subject}</td>					
					</tr>
					<tr>
						<th>내용</th>
						<td style="height: 300px;">${dto.content}</td>					
					</tr>
					<tr>
						<th>글쓴이</th>
						<td>${dto.name}(${dto.id})</td>
					</tr>
					<tr>
						<th>날짜</th>
						<td>${dto.regdate}</td>
					</tr>
					<tr>
						<th>조회수</th>
						<td>${dto.readcount}</td>
					</tr>
					<tr>
						<th>파일</th>
						<td>
							<c:if test="${not empty dto.orgfilename}">
							<a href="/toy/board/download.do?filename=${dto.filename}&orgfilename=${dto.orgfilename}">${dto.orgfilename}</a>
							</c:if>
							
							<c:if test="${empty dto.orgfilename}">
							첨부파일이 없습니다.
							</c:if>
						</td>
					</tr>
					<tr>
						<th>태그</th>
						<td><input type="text" name="tags" readonly></td>
					</tr>
					<tr>
						<th> 좋아요 / 싫어요</th>
						<td style="display: flex;">
							
							<form method="GET" action="/toy/board/goodbad.do">
							<button class="btn btn-info" id="btngood">
							<i class="fa-solid fa-thumbs-up"></i>
							<br>
								좋아요
							<br>
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
							<button class="btn btn-danger" id="btnbad">
							<i class="fa-solid fa-thumbs-down"></i>
							<br>
							싫어요
							<br>
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
					<input type="button" value="돌아가기" class="btn btn-secondary" onclick="location.href='/toy/board/list.do?column=${column}&word=${word}';">
					<!-- <input type="button" value="돌아가기" class="btn btn-secondary" onclick="history.back();"> -->
					
					<c:if test="${not empty auth}">
					
					<c:if test="${dto.id == auth || auth == 'admin'}">
					<button class="btn btn-primary" onclick="location.href='/toy/board/edit.do?seq=${dto.seq}&iseSearch=${isSearch}&column=${column}&word=${word}';" style="float: right">
					<i class="fas fa-pen"></i>
					수정하기
					</button>
					
					<button class="btn btn-primary" onclick="location.href='/toy/board/del.do?seq=${dto.seq}&iseSearch=${isSearch}&column=${column}&word=${word}';" style="float: right">
					<i class="fas fa-pen"></i>
					삭제하기
					</button>
					</c:if>
					
					<button class="btn btn-primary" style="float: right;" type="button" onclick="location.href='/toy/board/add.do?reply=1&thread=${dto.thread}&depth=${dto.depth}&iseSearch=${isSearch}&column=${column}&word=${word}';">
						<i class="fas fa-pen"></i>
						답변쓰기
						</button>
					</c:if>
					
				</div>
				
				<!-- 댓글 -->
				
				<%-- 서블릿과 jsp를 이용해서 댓글 구현 
				<form method="POST" action="/toy/board/addcommentok.do">
					<table class="tblAddComment">
						<tr>
							<td><textarea class="form-control" name="content" required></textarea></td>
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
								<span class="btnspan"><a href="#!" onclick="delcomment(${cdto.seq});">[삭제 <i class="fa-solid fa-xmark"></i>] </a></span>
								<span class="btnspan"><a href="#!" onclick="editcomment(${cdto.seq});">[수정 <i class="fa-solid fa-pen-to-square"></i>]</a></span>
								</c:if>
							</div>
						</td>
					</tr>
					</c:forEach>
					
				</table>
				 --%>
				 
				 
				 
				 
				 <!-- 댓글 구현 Ajax 버전 -->
				 <form id="addCommentForm">
					<table class="tblAddComment">
						<tr>
							<td><textarea class="form-control" name="content" required></textarea></td>
							<td>
								<button type="button" class="btn btn-primary" onclick="addComment();">
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
								<span class="btnspan"><a href="#!" onclick="delcomment(${cdto.seq});">[삭제 <i class="fa-solid fa-xmark"></i>] </a></span>
								<span class="btnspan"><a href="#!" onclick="editcomment(${cdto.seq});">[수정 <i class="fa-solid fa-pen-to-square"></i>]</a></span>
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
				location.href = 'delcommentok.do?seq=' + seq +'&pseq=${dto.seq}&isSearch=${isSearch}&column=${column}&word=${word}';
			}
		}
		*/
		
		
		function delcomment(seq) {
			
			//alert($(event.target).parents('tr')[0].nodeName);
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
							//alert(event.target);
							//$(event.target).parents('tr').remove();
							tr.remove();
						} else {
							alert('error!');
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
						<td><textarea class="form-control" name="content" required></textarea></td>
						<td>
							<button class="btn btn-secondary" type="button" onclick="cancelForm();">
								취소
							</button>
							<button class="btn btn-primary">
								<i class="fas fa-pen"></i>
								수정
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
							<td><textarea class="form-control" name="content" required id="txtcontent"></textarea></td>
							<td>
								<button class="btn btn-secondary" type="button" onclick="cancelForm();">
									취소
								</button>
								<button class="btn btn-primary" type="button" onclick="editComment();">
									<i class="fas fa-pen"></i>
									수정
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
	
	
	//img.onload == function() {}
	/*
	$('#imgattach').ready(function() {
		if ($('#imgattach').width() > 600) {
			$('#imgattach').width(600);
		}
		
		$('#imgattach').show();
		
	});
	*/
	
	let tag = '';
	
	<c:forEach items="${dto.taglist}" var="tag">
		tag += '${tag},';
	</c:forEach>
	//alert(tag);
	
	$('input[name=tags]').val(tag);
	//$('input[name=tags]').tagify();
	
	const tagify = new Tagify(document.querySelector('input[name=tags]'), {});
    
    tagify.on('click', test);
    
    function test(e) {
       //alert(e.detail.data.value);
       
       location.href = '/toy/board/list.do?tag=' + e.detail.data.value;
    }
    
    
    //좋아요, 싫어요
    
    
    
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
    
		
		
		//댓글 쓰기 (Ajax 버전)
		
		function addComment() {
			
			$.ajax ({
				type: 'POST',
				url: '/toy/board/addcommentajaxok.do',
				data: $('#addCommentForm').serialize(),
				dataType: 'json',
				success: function(result) {
					//댓글의 성공유무를 받아와야한다.
					
					if(result.result == "1") {
						//먼저 성공했는지를 출력
						//alert('success');
						
						//댓글쓰기 성공 > 새로 작성된 댓글을 목록에 반영하기
						
							let temp = `<tr>
							<td>
								<div>\${$('[name=content]').val()}</div>
								<div>
									<span>\${result.regdate}</span>
									<span>\${result.name}(\${result.id})</span>
									<span class="btnspan"><a href="#!" onclick="delCommentAjax(\${result.seq});">[삭제 <i class="fa-solid fa-xmark"></i>] </a></span>
									<span class="btnspan"><a href="#!" onclick="editCommentAjax(\${result.seq});">[수정 <i class="fa-solid fa-pen-to-square"></i>]</a></span>
								</div>
							</td>
						</tr>`;
						
						if ($('.comment tbody').length == 0) {
							$('.comment').append('<tbody></tbody>');
						}
							$('.comment tbody').prepend(temp);
							
					
					//댓글작성 폼에 남아있는 정보를 초기화하기 위해서 사용했던것이다..
					$('[name=content]').val('');
					
					
					$('.table.comment td').mouseover(function() {
						$(this).find('.btnspan').show();
					});
					
					$('.table.comment td').mouseout(function() {
						$(this).find('.btnspan').hide();
					});
					
					
						
					} else {
						//댓글쓰기 실패
						alert('error!');
					}
				},
				error: function(a,b,c) {
					console.log(a,b,c);
				}
			});
		}
		
		
		
		function editComment() {
			
			//alert($('#editRow').prev().children().eq(0).children().eq(0).text());
			
			$.ajax({
				
				type: 'POST',
				url: '/toy/board/editcommentajaxok.do',
				data: $('#editCommentForm').serialize(),
				dataType: 'json',
				success: function(result) {
					
					if (result.result == 1) {
						
						//수정된 댓글을 화면에 반영하기
						//$('textarea[name=content]').val()
						$('#editRow').prev().children().eq(0).children().eq(0).text($('#txtcontent').val());
						
						$('#editRow').remove();
						
						
					} else {
						alert('error!');
					}
					
				},
				error: function(a,b,c) {
					console.log(a,b,c);
				}
				
			})
			
		}
		
	
	</script>

</body>
</html>




















