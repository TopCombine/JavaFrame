package com.sxt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.sxt.model.Address;
import com.sxt.model.User;

public class UserDao {

	public static void main(String[] args) {
		 testRelation();
		// testPrepareLoad();
		// testBatch();
		// testBatch2();
		// testOneCache();
		// testTwoCache();
	}

	/**
	 * 二级缓存
	 */
	public static void testTwoCache() {
		Session session = HSF.getSession();
		List<User> userList = session.createQuery("from User").list();
		for (User user : userList) {
			System.out.println(user.getUserName());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		session.close();
	}

	/**
	 * 一级缓存 在一级缓存中只要session没关，曾经用过的对象，在后面可以续用，并且是同一个
	 */
	public static void testOneCache() {
		Session session = HSF.getSession();

		List<User> userList = session.createQuery("from User").list();
		for (User user : userList) {
			System.out.println(user.getUserName());
		}

		User user = (User) session.load(User.class, 19);

		User user2 = (User) session.load(User.class, 19);
		System.out.println(user.getUserName());
		System.out.println(user2.getUserName());

		System.out.println("" + user + "=" + user2);

		session.close();
	}

	public static void testBatch2(){
		try {
			Session session = HSF.getSession();
			session.beginTransaction();
	
			for(int i=1;i<=1000;i++){
				User user=new User();
				user.setUserName("乐哥="+i);
				user.setUserPwd("123");
				session.save(user);
				
				if(i%30==0) 
				{
					// 只是将Hibernate缓存中的数据提交到数据库，保持与数据库数据的同步
					session.flush(); 
					// 清除内部缓存的全部数据，及时释放出占用的内存
					session.clear(); 
				}
				System.out.println("="+i);
				
			}
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * 测试批量加载 set-------batch-size=2
	 */
	public static void testBatch() {
		Session session = HSF.getSession();
		String hql = "from User ";
		Query query = session.createQuery(hql);
		List<User> userList = query.list();
		for (User user : userList) {
			System.out.println(user.getUserName());
			Set<Address> addrs = user.getAddresses();
			for (Address address : addrs) {
				System.out.println(address.getAddrName());
			}
		}
		System.out.println(userList.size());
		session.close();
	}

	/**
	 * 预加载 用数组的方式取 fetch封装的方式为对象-->属性
	 */
	public static void testPrepareLoad() {
		Session session = HSF.getSession();
		String hql = "from User us left join  us.addresses";

		Query query = session.createQuery(hql);
		Iterator it = query.list().iterator();
		while (it.hasNext()) {
			Object[] objs = (Object[]) it.next();
			System.out.println(objs.length);
		}

		session.close();
	}

	/**
	 * 加载关连的对象 lazy =true false
	 */
	public static void testRelation() {
		Session session = HSF.getSession();
		String hql = "from User ";
		Query query = session.createQuery(hql);
		List<User> userList = query.list();
		for (User user : userList) {
			System.out.println(user.getUserName());
			Set<Address> addrs = user.getAddresses();
			for (Address address : addrs) {
				System.out.println(address.getAddrName());
			}
		}
		System.out.println(userList.size());
		session.close();
	}

}
