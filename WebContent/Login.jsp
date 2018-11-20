<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>Purple_loginform Website Template | Home :: w3layouts</title>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
	<!-- contact-form -->
	<div class="message warning">
		<div class="inset">
			<div class="login-head">
				<h1>登&nbsp;&nbsp;&nbsp;录</h1>
				<div class="alert-close"></div>
			</div>
			<%
				String mess = (String) session.getAttribute("msg");
				if ("".equals(mess) && mess == null) {
				} 
				else {%>
			 <script type="text/javascript"> 
			    alert("<%=mess%>");
			</script>
			<%  session.setAttribute("mess", ""); %>
			<%}%>
			<form action="/WebProjectForLogin/login" method="post">
				<li><label>用户名：</label><input type="text" name="userName" value="" /></li>
				<li><label>密  &nbsp;&nbsp;  码 ：</label><input type="password" name="psw" value="" /> </li>
				<div class="clear"></div>
				<br>
				<div class="submit">
					<input type="submit" onclick="myFunction()" value="登&nbsp;&nbsp;&nbsp;录">
				</div>

			</form>
		</div>
	</div>
	</div>
	<div class="clear"></div>
	

</body>
</html>