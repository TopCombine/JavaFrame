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

	<body>
			<p>
				&nbsp;帐号：
				<!--  readonly="readonly"只读，[不可编辑 可能提交]-->
				<!--  disabled="disabled"不可用，[不可编辑 不会提交]-->
				<input type="text" disabled="disabled" name="user.userName" value="${user.userName}">
			</p>
			<p>
				&nbsp;密码：
				<input type="password"  readonly="readonly" name="user.password" value="${user.password}">
			</p>
			<p> 
				&nbsp;年龄: 
				<input type="text"  readonly="readonly" name="user.age" value="${user.age}"> <br>
			</p>
			
			<p>&nbsp;
				<input type="button" onclick="history.go(-1)" value="返回"> 
			</p>
	</body>
</html>
