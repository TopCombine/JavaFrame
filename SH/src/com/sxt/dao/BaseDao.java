package com.sxt.dao;

import org.hibernate.Session;

/**
 * Data access object (DAO) for domain model
 * @author MyEclipse Persistence Tools
 */
public class BaseDao implements IBaseHibernateDAO {
	
	public Session getSession() {
		return HSF.getSession();
	}
	
}