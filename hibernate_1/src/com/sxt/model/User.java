package com.sxt.model;

import java.util.HashSet;
import java.util.Set;

/**
 * 普通的JAVA类
 * @author Administrator
 *
 */
public class User {
	
	private int id;
	
	private String name;
	
	private String pwd;
	
	private String desc;
	
	private int status;
	//用户地址集合
	private Set<Address> addrSet=new HashSet<Address>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Set getAddrSet() {
		return addrSet;
	}

	public void setAddrSet(Set addrSet) {
		this.addrSet = addrSet;
	}

}
