package com.sxt.service;

import java.util.List;

import com.sxt.model.User;
/**
 * 用户类服务层
 * @author Administrator
 *
 */
public interface IUserService {
	
	public void saveUser(User user);
	
	public List<User> findUserList(User user);
	
	public int findUserListCount(User user);

}
