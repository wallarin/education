<%@page import="java.util.Comparator"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	String path = application.getRealPath("/gallery/images");

	File dir = new File(path);
	
	File[] list = dir.listFiles();
	
	Arrays.sort(list, new Comparator<File>() {
		public int compare(File a, File b) {
			return Long.compare(a.lastModified(), b.lastModified());
		}
	});
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/example/inc/asset.jsp" %>
<style>
	#list {
		width: 800px;
		margin-top: 20px;
		margin-bottom: 30px;
		/* outline: 10px solid black; */
		/* display: inline-block; */
	}
	
	#list > div {
		float: left;
		border: 1px solid #999;
		margin: 15px;
		width: 126px;
		height: 126px;
		background-size: contain;
		background-repeat: no-repeat;
		background-position: center center;
		position: relative;
		left: 0;
		top: 0;
	}
	
	#list > div > span {
		font-size: 1.5em;
		position: absolute;
		right: 6px;
		top: 0;
		cursor: pointer;
		display: none;
	}
	
	#list > div:hover > span {
		display: inline;
	}
	
	#list::after {
		content: '';
		display: block;
		clear: both;
	}
	
	/* 
	#list > div > img {
		width: 126px;
		height: 126px;
	} 
	*/
	
	.modal-body > img {
		display: block;
		margin: 15px auto;
		
		/*
		width: ; > 고정 크기
		max-width: ; > 작을 땐 객체 크기, 클땐 지정 크기
		min-width: ; > 클 땐 객체 크기, 작은 지정 크기
		*/
		max-width: 560px;
	}
	
	#exampleModal .modal-dialog {
       -webkit-transform: translate(0,-50%);
       -o-transform: translate(0,-50%);
       transform: translate(0,-50%);
       top: 50%;
       margin: 0 auto;
   }
   
   
</style>
</head>
<body>

	<div class="container">
		<h1>Image Gallery</h1>
		
		<form method="POST" action="addok.jsp" enctype="mulipart/form-data">
		
		<table class="table">
			<tr>
				<th>이미지</th>
				<td><input type="file" name="attach" required></td>
			</tr>
		</table>
		
		<div>
			<input type="submit" value=" 이미지 업로드 "
				class="btn btn-success">
		</div>
		
		</form>
		
	</div>
	
	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	        <img src="images/1.png">
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	<script>
	
		function showImage(img) {
			//alert(img);
			
			$('.modal-body > img').attr('src', 'images/' + img);
			$('#exampleModalLabel').text(img);
			
		}
		
		function deleteImage(img) {
			//alert(img);
			
			if (confirm('delete?')) {
				location.href = 'ex20_file_delete.jsp?filename=' + img;
			}
			
			event.stopPropagation();
			
		}
	
	</script>

</body>
</html>




















