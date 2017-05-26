Struts2和Hibernate的结合


一、加入jar包


二、配置web.xml（Struts2的监听）
	<filter>
		<filter-name>struts2</filter-name>
		<filter-class>
			org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter</filter-class>
	</filter>
	<filter-mapping>
		<filter-name>struts2</filter-name>
		<url-pattern>*.action</url-pattern>
	</filter-mapping>
	
	
	
三、struts和hibernate的配置
<struts>
	<package name="base" extends="struts-default">
		<action name="user" class="com.sxt.web.UserAction">
			<result name="user_list">/jsp/user/user_list.jsp</result>
			<result name="user_list_action" type="redirect">user!findUserList.action</result>
			<result name="user_update">/jsp/user/user_update.jsp</result>
			<result name="user_detail">/jsp/user/user_detail.jsp</result>
		</action>
	</package>
</struts>    

<hibernate-configuration>
	<session-factory>
		<property name="dialect">org.hibernate.dialect.MySQLDialect</property>
		<property name="connection.url">
			jdbc:mysql://localhost:3306/test_hibernate?useUnicode=true&amp;characterEncoding=utf-8
		</property>
		<property name="connection.username">root</property>
		<property name="connection.password">123456</property>
		<property name="connection.driver_class">
			com.mysql.jdbc.Driver
		</property>
		<property name="myeclipse.connection.profile">mysql</property>
		<property name="show_sql">true</property>
		<property name="format_sql">true</property>
		<mapping resource="com/sxt/model/User.hbm.xml" />
		<mapping resource="com/sxt/model/Address.hbm.xml" />
		<mapping resource="com/sxt/model/Card.hbm.xml" />
	</session-factory>
</hibernate-configuration>


四、
流程：
jsp->Action->Dao(hibernate)->Action->jsp


五、




