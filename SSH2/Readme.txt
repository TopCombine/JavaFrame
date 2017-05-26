SSH

一、加入jar包

二、加入struts和spring的配置
①：spring配置
	<!-- spring监听web容器是否启动 [初始化和启动spring容器] start -->
 	<!-- 配置spring的配置文件中路径 -->
  	<context-param>
		<param-name>contextConfigLocation</param-name>
		<param-value>
			/WEB-INF/classes/applicationContext.xml
		</param-value>
	</context-param>
 	<!--监听器 -->
 	<listener>
  		<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
 	</listener>
 	<!-- spring监听web容器是否启动 [初始化和启动spring容器] end-->

②：struts配置
 	<filter>
  		<filter-name>struts2</filter-name>
  		<filter-class>
  			org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter
  		</filter-class>
 	</filter>
  
 	<filter-mapping>
  		<filter-name>struts2</filter-name>
  		<url-pattern>*.action</url-pattern>
  	</filter-mapping>


三、加入Struts2(struts.xml)和spring的配置文件(applicationContext.xml)

struts.xml:

<struts>
	<!-- 告诉struts 要找action的实例就到spring容器中找
	<constant name="struts.ObjectFactory" value="spring"></constant>
	-->
	<package name="base" extends="struts-default">
		<action name="user" class="com.sxt.web.UserAction">
			<result name="result">/result.jsp</result>
		</action>
	</package>
</struts>  

applicationContext.xml:

<?xml version="1.0" encoding="UTF-8"?>
<beans
	xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:p="http://www.springframework.org/schema/p"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">

	<!-- struts action类组装 -->
	<bean name="/user" class="com.sxt.web.UserAction">
		<property name="userService">
			<ref bean="userService"></ref>
		</property>
	</bean>
	
	<!-- 用户服务层配置 -->
	<bean id="userService" class="com.sxt.service.impl.UserServiceImpl">
		<property name="userDao">
			<ref bean="userDao"></ref>
		</property>
	</bean>
	
	<!-- 用户DAO层配置 -->
	<bean id="userDao" class="com.sxt.dao.impl.UserDaoImpl">
		<property name="sessionFactory">
			<ref bean="sessionFactory"></ref>
		</property>
	</bean>
	
	<bean id="sessionFactory"
		class="org.springframework.orm.hibernate3.LocalSessionFactoryBean">
		<property name="dataSource">
			<ref bean="dataSource"></ref>
		</property>
		<property name="hibernateProperties">
			<props>
				<prop key="hibernate.dialect">
					org.hibernate.dialect.MySQLDialect
				</prop>
				<prop key="hibernate.show_sql">
					true
				</prop>
				<prop key="hibernate.format_sql">
					true
				</prop>
			</props>
		</property>
		<property name="mappingResources">
			<list>
				<value>com/sxt/model/User.hbm.xml</value>
				<value>com/sxt/model/Address.hbm.xml</value>
				<value>com/sxt/model/Card.hbm.xml</value></list>
		</property>
	</bean>
	<bean id="dataSource"
		class="org.apache.commons.dbcp.BasicDataSource">
		<property name="driverClassName"
			value="com.mysql.jdbc.Driver">
		</property>
		<property name="url"
			value="jdbc:mysql://localhost:3306/test_hibernate?useUnicode=true&amp;characterEncoding=utf-8">
		</property>
		<property name="username" value="root"></property>
		<property name="password" value="123456"></property>
	</bean>
</beans>  


四、
实现：Action(extends ActionSupport)->Dao(extends HibernateDaoSupport implements IUserDao)
this.getHibernateTemplate().save(user);
