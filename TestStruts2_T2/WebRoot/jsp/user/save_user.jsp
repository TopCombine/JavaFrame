<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'save_user.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<body><!-- action的名字!指定方法.后缀 -->
		<form method="post" action="user!save.action">
			<p>
				&nbsp;帐号：
				<input type="text" name="user.userName">
			</p>
			<p>
				&nbsp;密码：
				<input type="password" name="user.password">
			</p>
			<p> 
				&nbsp;年龄: 
				<input type="text" name="user.age"> <br>
			</p>
			
			<p>&nbsp;
				<input type="submit" value="提交"> 
			</p>
			
		</form>

	</body>
</html>
