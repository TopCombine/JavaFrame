<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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


	</head>

	<body>
	<p>用户列表</p><a href="jsp/user/save_user.jsp">添加用户</a>
	<table width="80%" border="1" align="center">
      <tr>
        <td><div align="center">姓名</div></td>
        <td><div align="center">密码</div></td>
        <td><div align="center">年龄</div></td>
        <td><div align="center">操作</div></td>
      </tr>
      <c:forEach items="${userList}" var="user">
      <tr>
        <td><div align="center">${user.userName}</div></td>
        <td><div align="center">********</div></td>
        <td><div align="center">${user.age}</div></td>
        <td><div align="center">
        	<a href="user!delete.action?id=${user.userId}">删除</a>
        	| 
        	<a href="user!findUserToUpdate?id=${user.userId}">更新 </a>
        	| 
        	<a href="user!findUserToDetail?id=${user.userId}">明细</a>
        	</div></td>
      </tr>
      </c:forEach>
    </table>
   <center>
		<div>
		<a href="user!find.action?page=${pageUtil.firstPage}">首页</a> 
		<a href="user!find.action?page=${pageUtil.prePage}">上一页</a>
		[${pageUtil.currentPage}/${pageUtil.pageCount}] 
		<a href="user!find.action?page=${pageUtil.nextPage}">下一页 </a>
		<a href="user!find.action?page=${pageUtil.lastPage}">尾页</a>
		</div>
		</center>
	<p>&nbsp; </p>
	</body>
</html>
