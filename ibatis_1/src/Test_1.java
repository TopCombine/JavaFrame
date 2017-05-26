import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.sxt.model.User;


public class Test_1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
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
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
