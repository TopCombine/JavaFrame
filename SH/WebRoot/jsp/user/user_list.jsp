<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
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
   	<p>用户列表  </p>
   	<p><a href="jsp/user/user_save.jsp">添加</a></p>
   	<table width="80%" border="1" align="center">
      <tr>
        <td><div align="center">姓名</div></td>
        <td><div align="center">密码</div></td>
        <td><div align="center">描述</div></td>
        <td><div align="center">操作</div></td>
      </tr>
      <s:iterator value="#request.userList" var="user">
      <tr>
        <td>&nbsp;${user.userName}</td>
        <td>&nbsp;${user.userPwd}</td>
        <td>&nbsp;${user.userDesc}</td>
        <td>&nbsp;
        <a href="user!deleteUser.action?userId=${user.userId}">删除</a>
        &nbsp;|&nbsp;
        <a href="user!findUserDetail.action?flag=update&userId=${user.userId}">更新</a>
        &nbsp;|&nbsp;
        <a href="user!findUserDetail.action?flag=detail&userId=${user.userId}">明细</a>
        </td>
      </tr>
      </s:iterator>
    </table>
    <center>
     <div>
  	<a href="user!findUserList.action?page=${pageUtil.firstPage}">首页</a>
  	<a href="user!findUserList.action?page=${pageUtil.prePage}">上一页</a>
  	[${pageUtil.currentPage}/${pageUtil.lastPage}]
  	<a href="user!findUserList.action?page=${pageUtil.nextPage}">下一页</a>
  	<a href="user!findUserList.action?page=${pageUtil.lastPage}">尾页</a>
  </div>
    </center>
   	<p>&nbsp;  </p>
  </body>
</html>
