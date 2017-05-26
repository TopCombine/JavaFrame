package com.sxt.service;

import com.sxt.model.User;
/**
 * 用户服务层接口类
 * @author Administrator
 *
 */
public interface IUserService {
	
	public int saveUser(User user);
	
	public User getUser(int userId);

}
