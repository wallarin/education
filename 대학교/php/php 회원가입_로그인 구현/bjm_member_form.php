<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<script>
   function check_input()
   {
      if (!document.bjm_member_form.id.value) {
          alert("아이디를 입력하세요");    
          document.bjm_member_form.id.focus();
          return;
      }

      if (!document.bjm_member_form.pass.value) {
          alert("비밀번호를 입력하세요");    
          document.bjm_member_form.pass.focus();
          return;
      }

      if (!document.bjm_member_form.pass_confirm.value) {
          alert("비밀번호 확인을 입력하세요");    
          document.bjm_member_form.pass_confirm.focus();
          return;
      }

      if (!document.bjm_member_form.name.value) {
          alert("이름을 입력하세요");    
          document.bjm_member_form.name.focus();
          return;
      }

      if (document.bjm_member_form.pass.value != 
            document.bjm_member_form.pass_confirm.value) {
          alert("비밀번호가 일치하지 않습니다.\n다시 입력해 주세요");
          document.bjm_member_form.pass.focus();
          document.bjm_member_form.pass.select();
          return;
      }

      document.bjm_member_form.submit();
   }

   function reset_form() {
      document.bjm_member_form.id.value = "";  
      document.bjm_member_form.pass.value = "";
      document.bjm_member_form.pass_confirm.value = "";
      document.bjm_member_form.name.value = "";
      document.bjm_member_form.gender.value = "";
      return;
      }

</script>
</head>
<body>
	<section>
		<div id="main_content">
			<div id="join_box">
				<form name="bjm_member_form" method="post" action="bjm_member_insert.php">
					<h2>회원 정보 입력</h2>
					<div class="form id">  
						<input type="text" name="id" placeholder="ID를 입력하세요">&nbsp;</div><br>
					</div>
					<div class="clear"></div>
					<div class="form">
						<input type="password" name="pass" placeholder="PW를 입력하세요"></div><br>
					</div>
					<div class="clear"></div>
					<div class="form"><input type="password" name="pass_confirm" placeholder="PW를 재입력하세요"></div><br>
					</div>
					<div class="clear"></div>
					<div class="form">
						<input type="text" name="name"placeholder="이름을 입력하세요"></div><br>
					</div>
					<li> 성별 : 남성<input type="radio" name="gender" value="남성">
					 		 여성<input type="radio" name="gender" value="여성">
					</li><br>
					<div class="clear"></div>
					<div class="bottom_line"> </div>
					<div class="buttons">
					<input type="submit" value="가입하기" style="cursor:pointer" onclick="check_input()">&nbsp;
					<input type="reset" value="취소하기 " id="reset_button" style="cursor:pointer" onclick="reset_form()">
					</div>
				
				</form>

			</div>
		</div>
	</section>
</body>
</html>