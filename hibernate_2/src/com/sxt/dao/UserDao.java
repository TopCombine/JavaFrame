package com.sxt.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sxt.model.Address;
import com.sxt.model.Card;
import com.sxt.model.User;

public class UserDao {
	
	public static void main(String[] args) {
		//saveUser();
		//testLoad();
		//testOneToManyList();
		//testgetAddressAndUser();
		//saveUserAndAddress();
		//saveAddressAndUser();
		//appendAddressToUser();
		saveUserAndCard();
	}
	

	/**
	 * 保存用户和身份证
	 */
	public static void saveUserAndCard(){
		Configuration config=new Configuration().configure();
		
		SessionFactory sf=config.buildSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		
		User user=new User();
		user.setName("重阳");
		
		Card card=new Card();
		card.setCardNo("123456");
		
		//保存用户
		card.setUser(user);
		user.setCard(card);
		
		session.save(user);
		
		session.getTransaction().commit();
		session.close();
		sf.close();
		
	}
	
	public static void testgetAddressAndUser(){
		Session session=getSession();
		//加载地址对象
		Address addr=(Address) session.load(Address.class, 1);
		
		User user=addr.getUser();
		System.out.println(addr.getAddressName()+"=="+user.getName());
		
		session.close();
		
	}
	
	public static void testOneToManyList(){
		Session session=getSession();
		User user=(User) session.load(User.class, 1);
		System.out.println(user.getName());
		//取得地址
		List<Address> list=user.getAddrList();
		for (Address address : list) {
			System.out.println(address.getAddressName());
		}
		
	}
	
	public static void testLoad(){
		Session session1=getSession();
		Session session2=getSession();
		//不同session中查出的对象不会相等
		//同一sessoin中查出来的对象相等
		User user1=(User) session1.load(User.class, 1);
		User user2=(User) session1.load(User.class, 1);
		System.out.println(user1==user2);
		System.out.println(user1.getName()+user2.getName());
		session1.close();
		session2.close();
	}
	
	
	public static void saveUser(){
		Configuration config=new Configuration().configure();
		
		SessionFactory sf=config.buildSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		
		User user=new User();
		user.setName("张三");
		
		session.save(user);
		
		session.getTransaction().commit();
		session.close();
		sf.close();
		
	}
	
	/**
	 * 保存地址时同时保存用户
	 */
	public static void saveAddressAndUser(){
		Configuration config=new Configuration().configure();
		
		SessionFactory sf=config.buildSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		
		User user=new User();
		user.setName("张四");
		
		Address addr=new Address();
		addr.setAddressName("湖南一号");
		//给地址加上一个用户
		addr.setUser(user);
		
		//保存
		session.save(addr);
		
		session.getTransaction().commit();
		session.close();
		sf.close();
		
	}
	
	/**
	 * 保存用户和附加的地址
	 */
	public static void saveUserAndAddress(){
		Configuration config=new Configuration().configure();
		
		SessionFactory sf=config.buildSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		
		User user=new User();
		user.setName("张三");
		
		Address addr=new Address();
		addr.setAddressName("湖南");
		//将地址添加到用户的地址列表中
		user.getAddrList().add(addr);
		session.save(user);
		
		session.getTransaction().commit();
		session.close();
		sf.close();
		
	}
	
	/**
	 * 给用户追加地址
	 */
	public static void appendAddressToUser(){
		Configuration config=new Configuration().configure();
		
		SessionFactory sf=config.buildSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		//取得用户
		User user=(User) session.load(User.class, 7);
		//给用户新增地址
		Address addr=new Address();
		addr.setAddressName("湖南三号");
		//将地址添加到用户的地址列表中
		user.getAddrList().add(addr);
		
		//session.update(user);
		
		session.getTransaction().commit();
		session.close();
		sf.close();
		
	}
	
	public static Session getSession(){
		Configuration config=new Configuration().configure();
		
		SessionFactory sf=config.buildSessionFactory();
		Session session=sf.openSession();
		
		return session;
	}

}
