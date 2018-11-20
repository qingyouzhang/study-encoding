<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>Purple_loginform Website Template | Home :: w3layouts</title>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%  ServletContext context=session.getServletContext(); 
  Integer count=(Integer)context.getAttribute("numSessions"); 
  %> 
 
</head>
<body>
	<div class="message warning">
		<div class="inset">
			欢迎<span style="color: red"><%=request.getParameter("userName")%></span>登录成功！

           
			<form action="/WebProjectForLogin/loginout" method="get">
			 <p style="text-align:center;">当前登录在线人数 <span style="color:red;font-size:x-large;"><%=count %></span>  </p>
				<button type="submit" style="float: right;">
					<span style="color: red; font-size: large;">退出系统</span>
				</button>
			</form>
		</div>
	</div>
</body>
</html>