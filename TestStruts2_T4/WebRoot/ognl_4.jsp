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
  
  <br>----------------------set标签 ------------------- <br>
  <s:set var="v1" value="123" scope="session"></s:set>
   
  <s:property value="#attr.v1"/>
  <br>----------------------栈 ----push压入栈顶部，结束后移除 --------------- <br>
  <s:push value="'中华人民好痛苦'">
  	 <s:property/>
  </s:push>
   <br>---------------------bean组建对象---------------- <br>
  <s:bean name="com.sxt.model.User" var="user">
  	<s:param name="id" value="438"></s:param>
  	<s:param name="name" value="'张哥荣'"></s:param>
  	<s:param name="sex" value="1"></s:param>
  </s:bean>
   
   <s:property value="#user.name"/>
  <br>---------------------日期格式化---------------- <br>
  <%
  	 Date date=new Date();
  	 ///String date="2010-12-25 14:14:14";
  	 request.setAttribute("date",date);
   %>
   <s:date format="yyyy年MM月dd日 HH:mm:ss" name="#request.date"/>
   <br>---------------------debug标签---------------- <br>
   <s:debug></s:debug>
   
  </body>
</html>
