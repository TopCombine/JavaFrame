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

		<title>My JSP 'index.jsp' starting page</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	</head>

	<body>
		<form method="post" action="user.sxt">
			<p>
				&nbsp;帐号：
				<input type="text" name="userName">
			</p>
			<p>
				&nbsp;密码：
				<input type="text" name="password">
			</p>
			<p>
				&nbsp;长相：
				<input type="text" name="face">
			</p>
			<p>
				&nbsp;
				<input type="submit" value="提交">
				<br>
			</p>
			
		</form>
	</body>
</html>
