Spring


一、加入jar包

二、加入配置文件(applicationContext.xml)
	<?xml version="1.0" encoding="UTF-8"?>
	<!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN//EN" 
	"http://www.springframework.org/dtd/spring-beans.dtd">
	
	<beans>
		<bean id="user" class="com.wangwen.model.User">
			<property name="userName" value="wangwen"/>
			<property name="userPwd" value="201314"/>
			<property name="userAge" value="21"/>
			<!-- 注入另外一个对象 -->
			<property name="card">
				<ref bean="card"></ref>
			</property>
		</bean>
		<!-- 身份证对象 -->
		<!-- 用set方法给值 -->
		<!-- 
		<bean id="card" class="com.wangwen.model.Card">
			<property name="cardId" value="123"></property>
			<property name="cardNo" value="123456"></property>
		</bean>
		 -->
		<!-- 用构造方法给值 -->
		<bean id="card" class="com.wangwen.model.Card">
			<constructor-arg index="1">
				<value>123456</value>
			</constructor-arg>
			<constructor-arg index="0">
				<value>123</value>
			</constructor-arg>
		</bean>
		<!-- 集合 -->
		<bean id="collection" class="com.wangwen.model.Collection">
			<!-- list -->
			<property name="list">
				<list>
					<value>L---123</value>
					<value>L---456</value>
					<value>L---789</value>
				</list>
			</property>
			<!-- SET集合 -->
			<property name="set">
				<set>
					<value>S---123</value>
					<value>S---456</value>
					<value>S---789</value>
				</set>
			</property>
			<!-- map集合 -->
			<property name="map">
				<map>
					<entry>
						<key>
							<value>key1</value>
						</key>
						<value>M---123</value>
					</entry>
					<entry>
						<key>
							<value>key2</value>
						</key>
						<value>M---456</value>
					</entry>
				</map>	
			</property>
		</bean>
	</beans>

三、测试
方式一：
	BeanFactory bf = new XmlBeanFactory(new FileSystemResource("src/applicationContext.xml"));
	User user = (User)bf.getBean("user");
	System.out.println(user.getUserName());
	System.out.println(user.getUserPwd());
	System.out.println(user.getUserAge());
	System.out.println(user.getCard().getCardNo());
方式二：
	// 应用上下文
	ApplicationContext fac = new ClassPathXmlApplicationContext("applicationContext.xml");
	// 采用接口方式
	IUserService userService = (IUserService) fac.getBean("userService");



四、配置详解
applicationContext_auto.xml， applicationContext_default.xml，applicationContext_proxy.xml



五、AOP与依赖
TODO：


六、注解


