package com.sxt.service.impl;

import com.sxt.dao.IUserDao;
import com.sxt.model.User;
import com.sxt.service.IUserService;
/**
 * 服务层实现类
 * @author Administrator
 *
 */
public class UserServiceImpl implements IUserService {
	
	private IUserDao userDao;
	
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * 业务层保存的方法
	 */
	public void saveUser(User user) {
		userDao.saveUser(user);
	}

}
