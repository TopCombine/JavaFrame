Ibatis


一、加入jar包

二、加入配置文件(User.xml)
	<?xml version="1.0" encoding="UTF-8"?>
	<!DOCTYPE sqlMap
	PUBLIC "-//iBATIS.com//DTD SQL Map 2.0//EN"
	"http://www.ibatis.com/dtd/sql-map-2.dtd">
	
	<sqlMap>
		<!-- 查找用户的映射SQL -->
		<select id="getUser" resultClass="com.sxt.model.User" parameterClass="java.lang.Integer">
			SELECT user_id as userId,user_name as userName,user_pwd as userPwd,user_desc userdesc from user
			where user_id=#value#
		</select>
		<!-- 插入对象SQL -->
		<insert id="saveUser" parameterClass="com.sxt.model.User">
			insert into user(user_name,user_pwd,user_desc)
			values(#userName#,#userPwd#,#userDesc#)
		</insert>
	</sqlMap>

三、加入配置文件(SqlMapConfig.xml)
	<?xml version="1.0" encoding="UTF-8"?>
	<!DOCTYPE sqlMapConfig
	PUBLIC "-//iBATIS.com//DTD SQL Map Config 2.0//EN"
	"http://www.ibatis.com/dtd/sql-map-config-2.dtd">
	<sqlMapConfig>
		<transactionManager type="JDBC">
			<dataSource type="SIMPLE">
				<property name="JDBC.Driver" value="com.mysql.jdbc.Driver" />
				<property name="JDBC.ConnectionURL" value="jdbc:mysql://localhost:3306/test_hibernate?useUnicode=true&amp;characterEncoding=utf-8" />
				<property name="JDBC.Username" value="root" />
				<property name="JDBC.Password" value="123456" />
			</dataSource>
		</transactionManager>
		<sqlMap resource="com/sxt/model/User.xml"/>
	</sqlMapConfig>
	
四、测试
	String resource = "SqlMapConfig.xml";
	//读取配置文件
	Reader reader = Resources.getResourceAsReader (resource);
	//创建连接
	SqlMapClient sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
	//查找
	User user=(User) sqlMap.queryForObject("getUser", 17);	
	System.out.println(user.getUserName()+"=="+user.getUserDesc());
	//保存
	User  user2=new User();
	user2.setUserName("江光头");
	user2.setUserPwd("258");
	user2.setUserDesc("好亮一个灯");	
	sqlMap.insert("saveUser",user2);


