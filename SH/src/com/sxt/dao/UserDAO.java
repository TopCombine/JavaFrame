package com.sxt.dao;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sxt.model.User;
import com.sxt.util.PageUtil;

/**
 * A data access object (DAO) providing persistence and search support for User
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.sxt.model.User
 * @author MyEclipse Persistence Tools
 */

public class UserDAO extends BaseDao {
	private static final Logger log = LoggerFactory.getLogger(UserDAO.class);

	public void save(User transientInstance) {
		log.debug("saving User instance");
		try {
			Session session=getSession();
			session.beginTransaction();
			
			session.save(transientInstance);
			
			session.getTransaction().commit();
			session.close();
			log.debug("save successful");
		} catch (RuntimeException re) {
			throw re;
		}
	}

	/**
	 * 更新
	 * @param userId
	 */
	public void delete(int userId) {
		
		try {
			getSession().beginTransaction();
			Query query=getSession().createQuery("delete from User where userId="+userId);
			query.executeUpdate();
			//User user=(User) getSession().load(User.class, userId);
			//getSession().delete(user);
			
			getSession().getTransaction().commit();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public User findById(java.lang.Integer id) {
		try {
			User instance = (User) getSession().get("com.sxt.model.User", id);
			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public void updateUser(User user) {
		
		try {
			getSession().beginTransaction();
			//加载用户对象
			User userTemp=(User) getSession().load(User.class, user.getUserId());
			userTemp.setUserName(user.getUserName());
			userTemp.setUserPwd(user.getUserPwd());
			userTemp.setUserDesc(user.getUserDesc());
			getSession().saveOrUpdate(userTemp);
			getSession().getTransaction().commit();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List findByExample(User instance) {
		log.debug("finding User instance by example");
		try {
			List results = getSession().createCriteria("com.sxt.model.User")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding User instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from User as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll(PageUtil pageUtil) {
		log.debug("finding all User instances");
		try {
			String queryString = "from User";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setFirstResult(pageUtil.getStartRow());
			queryObject.setMaxResults(pageUtil.getPageSize());
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	/**
	 * 得 到总行数
	 * @return
	 */
	public int findAllCount() {

		Long rowCount=0L;
		try {
			String queryString = "select count(userId) from User";
			Query queryObject = getSession().createQuery(queryString);
			rowCount=(Long) queryObject.uniqueResult();
			
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
		return rowCount.intValue();
	}

	public User merge(User detachedInstance) {
		log.debug("merging User instance");
		try {
			User result = (User) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(User instance) {
		log.debug("attaching dirty User instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(User instance) {
		log.debug("attaching clean User instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}