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
  
  <br>----------------------if else elseif ------------------- <br>
    <s:iterator value="#request.userList" var="user">
  	ID===<s:property value="#user.id"/>  
  	姓名===<s:property value="#user.name"/>
  	
  	 性别=
  	 <s:if test="#user.sex==1">
  	 	男
  	 </s:if>
  	 <s:if test="#user.sex==0">
  	 	女
  	 </s:if>
  	 <s:if test="#user.sex==3">
  	 	系统无法识别
  	 </s:if>
  	 
  	&nbsp;
  	  <s:if test="#user.sex==1">
  	 	男
  	 </s:if>
  	 <s:elseif test="#user.sex==0">
  	 	女
  	 </s:elseif>
  	 <s:else>
  	 	系统无法识别
  	 </s:else>
  	 <br/>
  </s:iterator>
  
    <br>--------------------- iterator详解 ------------------- <br>
    <table width="80%" border="1">
    
  	<s:iterator value="{'中华人民共和国', '美利坚合众国', '阿拉伯联合酋长国'}" var="cur" status="st">
  	<tr 
	  	<s:if test="#st.odd==true">
	  		style="background-color: gray"
	  	</s:if>
  	>
  		<td>count=<s:property value="#st.count"/> &nbsp; </td>
  		<td>index<s:property value="#st.index"/> &nbsp;</td>
  		<td>even<s:property value="#st.even"/> &nbsp;</td>
  		<td>odd<s:property value="#st.odd"/> &nbsp;</td>
  		<td>first<s:property value="#st.first"/> &nbsp;</td>
  		<td>last<s:property value="#st.last"/> &nbsp;</td>
  		<td><s:property value="#cur"/></td>
  	</tr>
 </s:iterator>
 
 </table>
  <br>---------------------合并集合---------------- <br>
	  <s:append var="newCollection">
		<s:param value="{'中国', '美国', '日本'}"></s:param>
		<s:param value="{'德国', '泰国', '新加坡'}"></s:param>
	 </s:append>
	 
	 <s:iterator value="#newCollection" var="cur">
	<s:property value="#cur"/><br/>
	 </s:iterator>
	 
	  <br>---------------------字符串分隔---------要切隔成数组再进行迭代---"ab,cdm,c".splite(",");---- <br>
	 <s:generator separator="," val="'中,华人,民共和,国'" var="arr"/>
		<s:iterator value="#arr" var="cur">
			<s:property value="#cur"/><Br/>
		</s:iterator>
	 
  </body>
</html>
