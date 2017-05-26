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
  <br>----------------------作用域测试------------------- <br>
  request====	<s:property value="#request.var"/><br> 
  session====	<s:property value="#session.var"/> <br>
  application====	<s:property value="#application.var"/> <br>
  
  attr==== <s:property value="#attr.var"/> <br>
   <br>------------------Iterator Map----------------------- <br>
   <s:iterator value="#attr.map" var="gj">
   		key---<s:property value="#gj.key"/>   value---<s:property value="#gj.value"/><br/>
   </s:iterator>
   
   <s:iterator value="#{'生庆':'庆生','涛哥':'死相','江江':'闰士'}" var="name">
   		key---<s:property value="#name.key"/>   value---<s:property value="#name.value"/><br/>
   </s:iterator>
  </body>
</html>
