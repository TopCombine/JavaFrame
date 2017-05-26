import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.sxt.model.User;

public class Test_1 {

	public static void main(String[] args) {
//		testLog4j();
//		testFindCount();
//		findUserAndCardList();
	}
	
	/**
	 * 获取SqlMapConfig
	 * 
	 * @return
	 */
	private static SqlMapClient getSqlMapClient() {
		try {
			String configFile = "SqlMapConfig.xml";
			// 读取配置文件
			Reader reader = Resources.getResourceAsReader(configFile);
			SqlMapClient client = SqlMapClientBuilder.buildSqlMapClient(reader);
			return client;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 查询单个对象
	 */
	public static void testLog4j() {
		SqlMapClient client = getSqlMapClient();
		User user = null;
		try {
			user = (User) client.queryForObject("findUserById", 17);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(user.getUserName());
	}
	
	
	/**
	 * 查询总行数
	 */
	public static void testFindCount() {
		try {
			SqlMapClient client = getSqlMapClient();
			HashMap map = new HashMap();
			// map.put("userName","光");
			int count = (Integer) client.queryForObject("findUserAndCardCount",map);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 好方法
	 */
	public static void findUserAndCardList() {
		try {
			SqlMapClient sqlMap = getSqlMapClient();
			// 要传入的参数封装对象
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("startRow", 0);
			paramMap.put("pageSize", 3);
			// paramMap.put("userName", "%哥%");
			paramMap.put("userDesc", "%哥%");

			// 查找 将参数放进去
			List<HashMap> userList = sqlMap.queryForList("findUserAndCardList",paramMap);
			for (HashMap hashMap : userList) {
				System.out.println(hashMap.get("user_name") + "==" + hashMap.get("card_no"));
			}
			System.out.println(userList.size());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
