<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!--  引入struts2标签 -->
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
  <br>----------------------过滤和投影（projecting)集合 ------------------- <br>
  <s:iterator value="#request.userList.{$#this.id%2==0}" var="user">
  	ID===<s:property value="#user.id"/>  姓名===<s:property value="#user.name"/> 日期==<s:property value="#user.date"/> <br/>
  </s:iterator>


 <br>--------------------- 取得作用域中 用户列表 id为偶数 最后一行 属性为name------------------- <br>
 <s:property value="#attr.userList.{$#this.id%2==0}.{name}"/>
 
  <br>--------------------- 测试调用对象中方法 ------------------- <br>
   <br>--------------------- 调用前------------------- <br>
 <s:property value="#request.user.name"/>
    <br>--------------------- 调用后------------------- <br>
 <s:property value="#request.user.setName('温晕')"/>
 <s:property value="#request.user.name"/>
  </body>
</html>
