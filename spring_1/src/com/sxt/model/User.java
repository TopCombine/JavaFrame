package com.sxt.model;

import java.util.List;

/**
 * 用户类
 * @author Administrator
 *
 */
public class User {
	
	private void init(){
		System.out.println("执行了初始化动作");
	}
	
	private void destory(){
		System.out.println("执行了销毁动作");
	}
	
	private int userId;
	
	private Card card;
	

	

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	private String userName;
	
	private String userPwd;
	
	private int userAge;

}
