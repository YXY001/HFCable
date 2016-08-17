<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login/admin.css" type="text/css">
<script src="${pageContext.request.contextPath}/js/jquery-1.4.2.min.js" type="text/javascript"></script>
<title>用户登录</title>
<script type="text/javascript">
	$(document).keydown(function(e) {
		document.getElementById("namenull").style.display = "none";
		document.getElementById("pwdnull").style.display = "none";
	});
	function checknull() {
		var name = $("#username");
		var pwd = $("#password");
		var nnull = $("#namenull");
		var pnull = $("#pwdnull");
		if (name.val() == '' || name.val() == 0) {
			document.getElementById("namenull").style.display = "block";
			document.getElementById('username').focus();
			return false;
		} else if (pwd.val() == '' || pwd.val() == 0) {
			document.getElementById("pwdnull").style.display = "block";
			document.getElementById('password').focus();
			return false;
		}

	}
</script>
</head>
<body>
	<div class="wrapper">
		<div class="container">
			<h1>用户登录</h1>
			<form class="form1" action="${pageContext.request.contextPath }/user/login" method="post">
				<input type="text" placeholder="用户名" id="username" name="userName"><span
					id="namenull" style="display: none; color: red; font-weight: bold">请填写用户名</span>
				<input type="password" placeholder="密码" id="password"
					name="password"><span id="pwdnull"
					style="display: none; color: red; font-weight: bold">请填写密码</span>
				<button type="submit" id="login-btn" onclick="return checknull();">登录</button>
			</form>
		</div>

		<ul class="blue-block">
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
		</ul>
	</div>
</body>
</html>