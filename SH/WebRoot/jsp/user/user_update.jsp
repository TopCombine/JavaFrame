<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'user_save.jsp' starting page</title>
    
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
   	<form action="user!updateUser.action" method="post">
   		名字：<input type="text" name="user.userName" value="${user.userName}"/> <br/>
   		<input type="hidden" name="user.userId" value="${user.userId}"/>
   		密码：<input type="password" name="user.userPwd" value="${user.userName}"/> <br/>
   		描述：<input type="text" name="user.userDesc" value="${user.userName}"/> <br/>
   		<input type="submit" value="更新"/>
   	</form>
  </body>
</html>
