<!DOCTYPE html>
<html>
<head> 
<meta charset="utf-8">
<script type="text/javascript" src="./js/login.js"></script>
</head>
<body> 
	<section>
        <div id="main_content">
      		<div id="login_box">
	    		<div id="login_title">
		    		<h2>로그인</h2>
	    		</div>
	    		<div id="login_form">
          		<form  name="login_form" method="post" action="bjm_login_form.php">		       	
                  	
                    <input type="text" name="id" placeholder="아이디를 입력하세요" > <br><br>
                    <input type="password" id="pass" name="pass" placeholder="비밀번호를 입력하세요" > <br>
                  	
                  	<div id="login_btn">
                      	<a href="#"><input type="submit" value="로그인" onclick="check_input()"></a>
                  	</div>		    	
           		</form>
        		</div>
    		</div> 
        </div>
	</section> 
</body>
</html>

