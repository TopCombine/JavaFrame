package com.sxt.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sxt.dao.IUserDao;
import com.sxt.model.User;
/**
 * 用户类持久层实现类
 */
public class UserDaoImpl extends HibernateDaoSupport implements IUserDao {

	/**
	 * 保存的方法
	 */
	public void saveUser(User user) {
		this.getHibernateTemplate().save(user);
	}

}
