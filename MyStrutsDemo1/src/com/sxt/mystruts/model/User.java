package com.sxt.mystruts.model;

import java.util.Date;

import com.sxt.struts3.ActionForm;

/**
 * 用户类
 * @author Administrator
 *
 */
public class User  implements ActionForm{
	
	private String userName;
	
	private String password;
	
	private int age;
	
	private Date regDate;
	
	private String email;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	

}
