SSI2(Struts2,Spring,Ibaties)


一、加入jar包

二、
①：加入struts的配置：
struts.xml，struts-user.xml文件
②：加入spring的配置：
spring-base.xml
③：加入Ibatis的配置：
User.xml， sqlMapConfig.xml


三、统一将配置文件放在config里


四、测试
Action->UserDaoImpl(UserDaoImpl extends SqlMapClientDaoSupport implements IUserDao)
调用：
this.getSqlMapClientTemplate().insert("saveUser", user);





