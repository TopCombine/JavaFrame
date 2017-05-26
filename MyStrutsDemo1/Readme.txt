一、 struts1
①：struts.xml(类对应关系)


②：
ActionForm,Action,ObjectUtil(反射),ParseXML(xml解析(对struts.xml解析)),ActionServlet


-----------------------------------------------------------------------------
二、 struts2
①：
设置xml的快捷方式(DTD)
②：步骤：
1.加入jar包
2.web.xml加入配置
	<filter>
		<filter-name>struts2</filter-name>
		<filter-class>org.apache.struts2.dispatcher.FilterDispatcher</filter-class>
	</filter>

	<filter-mapping>
		<filter-name>struts2</filter-name>
		<url-pattern>/*</url-pattern>
	</filter-mapping>
3.加入struts.xml
<struts>
  	<package name="test" extends="struts-default">
 		<!-- 业务处理类 action name="访问路径" class="业务处理类" type="redirect"表示重定向 默认是转发 result=定义跳转-->
 		<action name="user"   class="com.sxt.struts2.web.UserAction">
 			<result name="ind" >index.jsp</result>
 		</action>
 	</package> 
 </struts>
4.业务类继承(重写execute方法)(对象方式来封装参数)
public class ProductAction extends ActionSupport
5.表单
<form method="post" action="user.action" enctype ="multipart/form-data">
6.拦截器
<!-- 定义拦截器 -->
		<interceptors>
			<!-- 定义权限和登录的拦截器 -->
			<interceptor name="authInter" class="com.sxt.interceptor.AuthInterceptor"></interceptor>
			<interceptor name="interceptor1" class="com.sxt.interceptor.TestInterceptor1"></interceptor>
			<interceptor name="logger" class="com.opensymphony.xwork2.interceptor.LoggingInterceptor"/>
			<interceptor name="timer" class="com.opensymphony.xwork2.interceptor.TimerInterceptor"/>
			
			<interceptor name="log" class="com.sxt.interceptor.LogInterceptor"></interceptor>
			
			<!-- 定义自已的拦截器栈 -->
			<interceptor-stack name="myStack">
				<interceptor-ref name="authInter"></interceptor-ref>
				<interceptor-ref name="interceptor1"></interceptor-ref>
				<interceptor-ref name="logger"></interceptor-ref>
				<interceptor-ref name="timer"></interceptor-ref>
				<interceptor-ref name="log"></interceptor-ref>
				<!-- 如果你定义自已的拦截器，还想用struts2提供的功能就必须显示的添加defaultStack的引用 -->
			<interceptor-ref name="defaultStack"></interceptor-ref>
			</interceptor-stack>
		</interceptors>


		<!-- 定义一个默认使用的拦截器栈  -->
		<default-interceptor-ref name="myStack"></default-interceptor-ref>
		
7. ognl


-----------------------------------------------------------------------------
三、struts1与struts2的区别
TODO：