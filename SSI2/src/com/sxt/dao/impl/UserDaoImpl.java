package com.sxt.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.sxt.dao.IUserDao;
import com.sxt.model.User;
/**
 * 用户类持久层实现类
 */
public class UserDaoImpl extends SqlMapClientDaoSupport implements IUserDao {

	/**
	 * 保存的方法
	 */
	public void saveUser(User user) {
		this.getSqlMapClientTemplate().insert("saveUser", user);

		User user2=new User();
		user2.setUserName(user.getUserName());
		user2.setUserPwd(user.getUserPwd());
		
		//this.getSqlMapClientTemplate().insert("saveUser", user2);
	}

	/**
	 * 查询列表
	 */
	public List<User> findUserList(User user) {
		List<User> userList=this.getSqlMapClientTemplate().queryForList("findUserList", user);
		return userList;
	}
	
	/**
	 * 查询列表总行数
	 */
	public int findUserListCount(User user) {
		int rowCount=(Integer) this.getSqlMapClientTemplate().queryForObject("findUserListCount", user);
		return rowCount;
	}

}
