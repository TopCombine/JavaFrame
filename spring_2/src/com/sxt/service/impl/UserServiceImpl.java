package com.sxt.service.impl;

import com.sxt.model.User;
import com.sxt.service.IUserService;

public class UserServiceImpl implements IUserService{

	/**
	 * 保存用户
	 */
	public int saveUser(User user) {
		System.out.println("交给持久层=="+user.getUserName());
		return 0;
	}

	/**
	 * 取得用户
	 */
	public User getUser(int userId) {
		System.out.println("从持久层取=="+userId);
		User user=new User();
		user.setUserName("张四");
		return user;
	}

}
