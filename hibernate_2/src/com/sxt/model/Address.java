package com.sxt.model;
/**
 * 地址类
 * @author Administrator
 *
 */
public class Address {
	
	private int id;
	
	private String addressName;
	//多对一的关系
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}
	
	

}
