package com.sxt.dao;

import java.util.List;

import com.sxt.model.User;
/**
 * 用户持久层接口
 * @author Administrator
 *
 */
public interface IUserDao {
	
	public void saveUser(User user);
	
	public List<User> findUserList(User user);
	
	public int findUserListCount(User user);

}
