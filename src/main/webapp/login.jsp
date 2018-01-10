<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登陆</title>
<script src="js/jquery-3.2.1.min.js" type="text/javascript"> </script>
<script src="js/keyEvent.js" type="text/javascript"> </script>
<script src="js/bootstrap.min.js"> </script>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="css/adminStyle.css" rel="stylesheet" type="text/css" />
</head>
<body onkeydown="keyLogin();">
	<div class="navbar navbar-default navbar-fixed-top" style="background:#272727;color:white" >
		<div class="container">
			<div class="row" style="font-size:20px;margin-top:10px;">
				<div class="col-sm-12">
					登录
				</div>
			</div>
		</div>
	</div>
	
	<div class="row" style="margin-top:100px;align:center;">
		<div class="col-sm-offset-4 col-sm-4" style="background:#eee;width:500px;border-radius:8px;box-shadow:5px 5px 5px #333">
			<form action="login" method="post" role="form">
				<div class="form-group" style="margin-top:15px">
					<div class="col-sm-12">
						<input type="text" id="username" name="username" class="form-control" placeholder="请输入帐号">
					</div>
				</div>
				<div class="form-group" >
					<div class="col-sm-12" style="margin-top:15px">
						<input type="password"  id="password" name="password" class="form-control" placeholder="请输入密码">
					</div>				
				</div>
				<div class="form-group">
					<div class="col-sm-12" style="margin-top:15px">
						<button type="submit" id="login" class="btn btn-primary" class="form-control" style="width:100%">登录</button>
					</div>
				</div>
			</form>
			<!-- 注册 -->
				<div class="col-sm-12" style="margin-top:15px;margin-bottom:15px">
					<a href="register.jsp" type="button" class="btn btn-primary form-horizontal" style="width:100%" >注册</a>
				</div>
				<span style="color:red;">${result}</span>
		</div>
	</div>
</body>
</html>