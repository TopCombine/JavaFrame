package com.sxt.service.impl;

import com.sxt.model.User;
import com.sxt.service.IUserService;

public class UserServiceOtherSysImpl implements IUserService{

	public User getUser(int userId) {
		System.out.println("从其它系统中取参数");
		User user=new User();
		user.setUserName("吴三贵");
		return user;
	}

	public int saveUser(User user) {
		System.out.println("将数据保存到其它系统中");
		return 0;
	}

}
