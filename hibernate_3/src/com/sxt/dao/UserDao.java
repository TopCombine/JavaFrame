package com.sxt.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.sxt.model.User;

public class UserDao {

	public static void main(String[] args) {
//		 testGetAndLoad();
//		 testHQL();
//		 testCriteria();
//		 testExample();
//		 testNativeSQL();
//		 testNativeSQL2();
//		 testNativeSQL3();
//		testSelectTD();
		testSort();
//		testPage();
	}
	
	/**
	 * 分页
	 */
	public static void testPage() {

		Session session = HSF.getSession();
		Query query = session.createQuery("from User order by userId desc");
		//分页
		//起始行数
		query.setFirstResult(2);
		//每页显示条数
		query.setMaxResults(2);
		
		List<User> list = query.list();
		for (User user : list) {
			System.out.println(user.getUserName());
		}
		System.out.println("显示="+list.size());
		session.close();
	}
	
	/**
	 * 查父类得出所有子类的信息
	 */
	public static void testSort() {

		Session session = HSF.getSession();
		Query query = session.createQuery("from User order by userId desc");
		
		List<User> list = query.list();
		for (User user : list) {
			System.out.println(user.getUserName());
		}
		System.out.println(list.size());
		session.close();
	}

	/**
	 * 查父类得出所有子类的信息
	 */
	public static void testSelectTD() {

		Session session = HSF.getSession();
		Query query = session.createQuery("from java.lang.Object");
		List list = query.list();

		System.out.println(list.size());
		session.close();
	}

	public static void testNativeSQL3() {

		String sql = "select us.*,addr.addr_name from user us left join Address addr on us.user_id=addr.user_id";
		Session session = HSF.getSession();
		SQLQuery query = session.createSQLQuery(sql);
		List list = query.list();
		for (int i = 0; i < list.size(); i++) {
			Object[] objs = (Object[]) list.get(i);
			System.out.println(objs[0]);
			System.out.println(objs[1]);
			System.out.println(objs[2]);
			System.out.println(objs[3]);
			System.out.println(objs[4]);
			System.out.println(objs[5]);
			System.out.println(objs[6]);

		}

		System.out.println(list.size());
		session.close();
	}

	public static void testNativeSQL2() {
		/*
		 * Session session=HSF.getSession(); SQLQuery
		 * query=session.createSQLQuery("select count(user_id) as ss from
		 * user"); //System.out.println("总行数="+rowCount); session.close();
		 */
		Session session = HSF.getSession();
		Long count = (Long) session.createQuery(
				"select count(user_id) from User").uniqueResult();
		System.out.println(count);

		session.close();
	}

	public static void testNativeSQL() {
		Session session = HSF.getSession();
		SQLQuery query = session
				.createSQLQuery("select * from user where user_id=35");
		query.addEntity(User.class);
		// 得到一个唯一的结果
		User user = (User) query.uniqueResult();
		System.out.println(user.getUserName());
		session.close();
	}

	public static void testExample() {
		Session session = HSF.getSession();

		User user = new User();
		user.setUserName("wenber");
		user.setUserPwd("123");
		// 创建一个查询器
		Criteria cri = session.createCriteria(User.class);

		// 通过模板生成条件 不包括为零的值 忽略大小写
		Criterion crit = Example.create(user).excludeZeroes().ignoreCase()
				.excludeProperty("userName");

		// 添加条件
		cri.add(crit);
		// 查询出列表
		List<User> userList = cri.list();
		for (User users : userList) {
			System.out.println(users.getUserName() + "==" + users.getUserPwd());
		}
		session.close();
	}

	/**
	 * 条件查询
	 */
	public static void testCriteria() {
		Session session = HSF.getSession();
		// 创建一个条件查询器
		Criteria cri = session.createCriteria(User.class);
		// 条件
		Criterion crit = Expression.eq("userPwd", "435");
		Criterion like = Expression.like("userName", "张%");
		// 将条件加到查询器中 可以设置多个条件如何相组合
		cri.add(Restrictions.or(crit, like));
		// cri.add(crit);
		// 查询出列表
		List<User> userList = cri.list();
		for (User user : userList) {
			System.out.println(user.getUserName() + "==" + user.getUserPwd());
		}
		session.close();
	}

	/**
	 * HQL查询
	 */
	public static void testHQL() {
		Session session = HSF.getSession();
		// String hql="from User where userId=:userId";
		String hql = "from User where userId=?";
		// 创建一个查询器
		Query query = session.createQuery(hql);
		// query.setInteger("userId",35);
		query.setParameter(0, 35);
		List<User> userList = query.list();
		for (User user : userList) {
			System.out.println(user.getUserName());
		}
		session.close();
	}

	public static void testGetAndLoad() {
		Session session = HSF.getSession();

		// User user=(User) session.load(User.class, 39);
		User user = (User) session.get(User.class, 39);
		System.out.println(user);
		session.close();
	}

	public static void saveUser() {
		Session session = HSF.getSession();
		session.beginTransaction();
		User user = new User();
		user.setUserName("张三");
		session.save(user);
		session.getTransaction().commit();
		session.close();
	}

}
