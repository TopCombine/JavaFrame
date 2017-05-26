Hibernate搭建

一、步骤
①：加入jar包
②：建立model类
③：建立hibernate配置文件hibernate.cfg.xml(src目录下)
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE hibernate-configuration PUBLIC
          "-//Hibernate/Hibernate Configuration DTD 3.0//EN"
          "http://hibernate.sourceforge.net/hibernate-configuration-3.0.dtd">          
<hibernate-configuration>
<session-factory>
	<property name="connection.username">root</property>
	<property name="connection.password">123456</property>
	<property name="connection.url">
		jdbc:mysql://localhost:3306/test_hibernate?useUnicode=true&amp;characterEncoding=utf-8
	</property>
	<property name="show_sql">true</property>
	<property name="format_sql">true</property>
	<property name="connection.driver_class">com.mysql.jdbc.Driver</property>
	<property name="dialect">org.hibernate.dialect.MySQLDialect</property>
	<!-- 加载项目中的对象映射文件 -->
	<mapping resource="com/sxt/model/User.hbm.xml"/>
	<mapping resource="com/sxt/model/Address.hbm.xml"/>
</session-factory>
</hibernate-configuration>


④：建立与model对应的hbm.xml(路径在同一个package)
<hibernate-mapping>
	<class name="com.sxt.model.Address" table="address">
		<!-- ID的配置 -->
		<id name="id" type="java.lang.Integer" column="addr_id">
			<generator class="assigned"/>
		</id>
		<!-- 其它属性的配置 -->
		<property name="addressName" type="java.lang.String">
			<column name="addr_name"></column>
		</property>
		
	</class>
</hibernate-mapping>

⑤：测试
	//新建配置对象
	Configuration config=new Configuration();
	//加载配置
	config.configure();
	//创建工厂
	SessionFactory sf=config.buildSessionFactory();
	//创建会话session
	Session session=sf.openSession();
	//开始事务
	Transaction trans=session.beginTransaction();
	User user=new User();
	//user.setId(1);
	user.setDesc("好用的不得了");
	user.setName("重阳猪");
	user.setPwd("38");
	user.setStatus(1);
	//保存对象
	session.save(user);
	//提交
	trans.commit();
	//关闭
	session.close();
	sf.close();

2.删除
// 开始事务
Transaction trans = session.beginTransaction();
User user = new User();
user.setId(1);
session.delete(user);

3.更新
// 开始事务
Transaction trans = session.beginTransaction();
// 加载
User user = (User) session.load(User.class, 1);
// 更新一个属性值
user.setName("乐哥黑猪");
user.setDesc("好吃的一个种类23");
session.update(user);



------------------------------------------------------------------------------------
二、
<!-- 一对一主键关联 -->
	<one-to-one name="card" class="com.sxt.model.Card" cascade="all"></one-to-one>

<!-- 多对一的关系 cascade=动作传递-->
	<many-to-one name="user" column="user_id" cascade="save-update"></many-to-one>
	
<!-- 采用list 接收 cascade级联-->
	<list name="addrList" table="address" cascade="save-update">
		<key column="user_id"></key>
		<list-index column="list_index"></list-index>
		<one-to-many class="com.sxt.model.Address"/>
	</list>

----------------------------------------------------------------	
	User ------> Card
	1:一对一
	<one-to-one>
	主键关联
	 card方 foreign---->user【user_id】
	
	外键关联
	card方 <one-to-many > 
	-->
	<one-to-one name="user" property-ref="card">
	
	2：一对多
	一对多
	<one-to-many>
	多对一
	<many-to-one>
	
	3：多对多

----------------------------------------------------------------------------------------------
三、
1.通过模板查询
	// 创建一个查询器
	Criteria cri = session.createCriteria(User.class);
	// 通过模板生成条件 不包括为零的值 忽略大小写
	Criterion crit = Example.create(user).excludeZeroes().ignoreCase().excludeProperty("userName");
	// 添加条件
	cri.add(crit);
	// 查询出列表
	List<User> userList = cri.list();

2.条件查询
	// 创建一个条件查询器
	Criteria cri = session.createCriteria(User.class);
	// 条件
	Criterion crit = Expression.eq("userPwd", "435");
	Criterion like = Expression.like("userName", "张%");
	// 将条件加到查询器中 可以设置多个条件如何相组合
	cri.add(Restrictions.or(crit, like));
	// 查询出列表
	List<User> userList = cri.list();

3.HQL查询
	// String hql="from User where userId=:userId";
	String hql = "from User where userId=?";
	// 创建一个查询器
	Query query = session.createQuery(hql);
	// query.setInteger("userId",35);
	query.setParameter(0, 35);
	List<User> userList = query.list();
	
4.get和load的区别


5.本地查询
①：
	SQLQuery query = session
					.createSQLQuery("select * from user where user_id=35");
	query.addEntity(User.class);
	// 得到一个唯一的结果
	User user = (User) query.uniqueResult();
	System.out.println(user.getUserName());
②：
	Session session = HSF.getSession();
	Long count = (Long) session.createQuery(
			"select count(user_id) from User").uniqueResult();
	System.out.println(count);
③：
	String sql = "select us.*,addr.addr_name from user us left join Address addr on us.user_id=addr.user_id";
	Session session = HSF.getSession();
	SQLQuery query = session.createSQLQuery(sql);
	List list = query.list();
	for (int i = 0; i < list.size(); i++) {
		Object[] objs = (Object[]) list.get(i);
		System.out.println(objs[0]);
		System.out.println(objs[1]);
		System.out.println(objs[2]);
		System.out.println(objs[3]);
		System.out.println(objs[4]);
		System.out.println(objs[5]);
		System.out.println(objs[6]);

	}
	System.out.println(list.size());


6.缓存(ehcache.xml)
<ehcache>
<diskStore path="d:/cache"/>
    <defaultCache   
            maxElementsInMemory="500"   
            eternal="false"
            overflowToDisk="true"   
            timeToLiveSeconds="180"
            />
</ehcache>


7.hibernate配置文件的两种方式：
TODO：










