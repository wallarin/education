<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터 전송하기 실습페이지</title>
<style>
	.ran {
		width: 460px;
	}
	
	input {
		padding: 3px 8px;
	}
	
	input[type=number] {
		text-align: right;
		width: 100px;
	}
	
	#hiddenbox {
		display: none;
	}
	
	#tbl {
		border-collapse: collapse;
	}
	
	#tbl th {
		border: 1px solid #E6E6E6;
		width: 120px;
		height: 40px;
		text-align: center;
	}
	
	#tbl td {
		border: 1px solid #E4E4E4;
		padding: 10px;
	}
	
	#sel1 {
		width: 120px;
		padding: 8px;
	}
	
	#btn1 {
		border: 0px;
		border-radius: 5px;
		color: white;
		margin: 20px 0;
		padding: 10px;
		background-color: #5fb85d;
	}
	
	#btn1:hover {
		cursor: pointer;
	}
	
	.ran {
		padding: 0;
	}
	
	#hiddenbox {
		border: 1px solid #a6a6a6;
		background-color: #e9e8e9;
		margin: 5px 0;
		padding: 20px;
	}
	
	#hiddenbox > div {
		margin-bottom: 10px;
	}
	
	#hiddenbox > div:nth-child(2) > input {
		width: 100px;
	}
	
	#hiddenbox > div:nth-child(3) > select {
		padding: 5px;
		width: 100px;
	}
	
</style>
<script src="https://kit.fontawesome.com/e4f03f4c6c.js" crossorigin="anonymous"></script>
</head>
<body>

	<h1>버튼 만들기</h1>
	
	<form method="POST" action="ex11_ok.jsp">
		<table id="tbl">
			<tr>
				<th>너비(px)</th>
				<td><input type="number" name="width" min="0" max="300" value="50" step="10"></td>
			</tr>
			<tr>
				<th>높이(px)</th>
				<td><input type="number" name="height" min="0" max="300" value="40" step="10"></td>
			</tr>
			<tr>
				<th>텍스트</th>
				<td><input type="text" name="text" value="버튼"></td>
			</tr>
			<tr>
				<th>배경색</th>
				<td><input type="color" name="backgroundcolor" value="#FFFFFF"></td>
			</tr>
			<tr>
				<th>글자색</th>
				<td><input type="color" name="fontcolor"></td>
			</tr>
			<tr>
				<th>글자 크기(px)</th>
				<td><input type="number" name="fontsize" min="0" max="30" value="16"></td>
			</tr>
			<tr>
				<th>버튼 개수(ea)</th>
				<td><input type="number" name="ea" min="0" max="100" value="0"></td>
			</tr>
			<tr>
				<th>버튼 간격</th>
				<td>
					<div>좌우 간격: <br><input type="range" min="0" max="100" value="0" class="ran" name="leftran"></div> 
					<div>상하 간격: <br><input type="range" min="0" max="100" value="0" class="ran" name="topran"></div>
				</td>
			</tr>
			<tr>
				<th>아이콘</th>
				<td>
					<label><input type="radio" name="rb" value="nope" checked>없음</label>
					<label><input type="radio" name="rb" value="heart"><i class="fa-solid fa-heart"></i></label>
					<label><input type="radio" name="rb" value="headphones"><i class="fa-solid fa-headphones"></i></label>
					<label><input type="radio" name="rb" value="camera"><i class="fa-solid fa-camera"></i></label>
					<label><input type="radio" name="rb" value="video"><i class="fa-solid fa-video"></i></label>
					<label><input type="radio" name="rb" value="magnet"><i class="fa-solid fa-magnet"></i></label>
				</td>
			</tr>
			<tr>
				<th>테두리</th>
				<td>
					<select name="sel1" id="sel1">
						<option value="1">감추기</option>
						<option value="2">보이기</option>
					</select>
						<div id="hiddenbox">
							<div>두께(px): <input type="number" value="0" min="0" max="20" name="borderwidth"></div>
							<div>색상: <input type="color" name="bordercolor"></div>
							<div>스타일: <select name="borderstyle">
								<option value="solid">실선</option>
								<option value="dashed">쇄선</option>
								<option value="dotted">점선</option>
							</select></div>
							<div>모서리(px): <input type="number" value="0" min="0" max="150" name="borderradius"></div>
						</div>
				</td>
			</tr>
		</table>
		<input type="submit" id="btn1" value="만들기">
	</form>
	
	
	<script>
	
	document.getElementById('sel1').onchange = function(event) {

        if (event.target.value == "2") {
            document.getElementById('hiddenbox').style.display = 'block';
        } else {
            document.getElementById('hiddenbox').style.display = 'none';
        }

    };
	
	</script>

</body>
</html>












