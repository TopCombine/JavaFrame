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
	<script type="text/javascript" src="js/jquery-1.6.2.js"></script>
	<script type="text/javascript">
		function checkUpdate(){
			var userName=$("input[name='user.userName']").val();
			if(userName==''){
				alert("帐号不能为空");
				$("input[name='user.userName']").focus();
				
				return;
			}
			var password=$("input[name='user.password']").val();
			if(password==''){
				alert("密码不能为空");
				return;
			}
			if(password.length>6){
				alert("密码长度不能超过6位");
				return;
			}
			var age=$("input[name='user.age']").val();
			if(age==''){
				alert("年龄不能为空");
				return;
			}
			//is not a number
			if(isNaN(age)){
				alert("年龄只能为数字");
				$("input[name='user.age']").select();
				return;
			}
			if(confirm("确认更新")){
				//用脚本提交
				$("form[name='form']").submit();
			}
			
		}
	</script>
	</head>

	<body><!-- action的名字!指定方法.后缀 -->
		<form name="form" method="post" action="user!update.action">
			<p>
				&nbsp;帐号：
				<input type="text" name="user.userName" value="${user.userName}">
				<input type="hidden" name="user.userId" value="${user.userId}">
			</p>
			<p>
				&nbsp;密码：
				<input type="password" name="user.password" value="${user.password}">
			</p>
			<p> 
				&nbsp;年龄: 
				<input type="text" name="user.age" value="${user.age}"> <br>
			</p>
			
			<p>&nbsp;
				<input type="button" onclick="checkUpdate()" value="更新"> 
			</p>
			
		</form>

	</body>
</html>
