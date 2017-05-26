package com.sxt.dao;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sxt.model.Address;
import com.sxt.model.User;

public class UserDao {

	public static void main(String[] args) {
		saveUser();
		// saveAddress();
		// update();
		// delete();
		// load();
	}

	/**
	 * 加载
	 */
	public static void load() {
		// 新建配置对象
		Configuration config = new Configuration();
		// 加载配置
		config.configure();
		// 创建工厂
		SessionFactory sf = config.buildSessionFactory();
		// 创建会话session
		Session session = sf.openSession();

		User user = (User) session.load(User.class, 1);
		System.out.println(user.getName());
		// 加载用户的地址
		Set<Address> addrs = user.getAddrSet();
		for (Address address : addrs) {
			System.out.println(address.getAddressName());
		}
		// 关闭
		session.close();
		sf.close();
	}

	/**
	 * 删除动作
	 */
	public static void delete() {
		// 新建配置对象
		Configuration config = new Configuration();
		// 加载配置
		config.configure();
		// 创建工厂
		SessionFactory sf = config.buildSessionFactory();
		// 创建会话session
		Session session = sf.openSession();
		// 开始事务
		Transaction trans = session.beginTransaction();

		User user = new User();
		user.setId(1);

		session.delete(user);

		// 提交
		trans.commit();
		// 关闭
		session.close();
		sf.close();
	}

	/**
	 * 更新动作
	 */
	public static void update() {
		// 新建配置对象
		Configuration config = new Configuration();
		// 加载配置
		config.configure();
		// 创建工厂
		SessionFactory sf = config.buildSessionFactory();
		// 创建会话session
		Session session = sf.openSession();
		// 开始事务
		Transaction trans = session.beginTransaction();

		// 加载
		User user = (User) session.load(User.class, 1);
		// 更新一个属性值
		user.setName("乐哥黑猪");
		user.setDesc("好吃的一个种类23");

		session.update(user);

		// 提交
		trans.commit();
		// 关闭
		session.close();
		sf.close();
	}

	public static void saveUser() {
		// 新建配置对象
		Configuration config = new Configuration();
		// 加载配置
		config.configure();
		// 创建工厂
		SessionFactory sf = config.buildSessionFactory();
		// 创建会话session
		Session session = sf.openSession();
		// 开始事务
		Transaction trans = session.beginTransaction();
		User user = new User();
		// user.setId(1);
		user.setDesc("好用的不得了");
		user.setName("重阳猪");
		user.setPwd("38");
		user.setStatus(1);

		Address addr = new Address();
		addr.setId(3);
		addr.setAddressName("无路可走");

		user.getAddrSet().add(addr);
		// 保存对象
		session.save(user);

		// 提交
		trans.commit();
		// 关闭
		session.close();
		sf.close();
	}

	public static void saveAddress() {
		Configuration config = new Configuration();
		config.configure();

		SessionFactory sf = config.buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		Address addr = new Address();
		addr.setId(1);
		addr.setAddressName("湖南重点地下通道");

		session.save(addr);
		session.getTransaction().commit();

		session.close();
		sf.close();
	}

}
