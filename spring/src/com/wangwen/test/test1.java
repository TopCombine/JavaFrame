package com.wangwen.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import com.wangwen.model.User;

public class test1 {
	public static void main(String[] args) {
		BeanFactory bf = new XmlBeanFactory(new FileSystemResource("src/applicationContext.xml"));
		User user = (User)bf.getBean("user");
		System.out.println(user.getUserName());
		System.out.println(user.getUserPwd());
		System.out.println(user.getUserAge());
		System.out.println(user.getCard().getCardNo());
	}
}
