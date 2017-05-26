package com.sxt.model;

import java.util.HashSet;
import java.util.Set;

import com.sxt.util.PageUtil;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User  implements java.io.Serializable {

	// Fields

	private Integer userId;
	private Card card;
	private String userPwd;
	private String userName;
	private String userDesc;
	private Integer userStatus;
	private Integer userAge;
	private Set addresses = new HashSet(0);
	
	PageUtil pageUtil;
	
	// Constructors

	public PageUtil getPageUtil() {
		return pageUtil;
	}

	public void setPageUtil(PageUtil pageUtil) {
		this.pageUtil = pageUtil;
	}

	/** default constructor */
	public User() {
		
	}

	/** full constructor */
	public User(Card card, String userPwd, String userName, String userDesc,
			Integer userStatus, Integer userAge, Set addresses) {
		this.card = card;
		this.userPwd = userPwd;
		this.userName = userName;
		this.userDesc = userDesc;
		this.userStatus = userStatus;
		this.userAge = userAge;
		this.addresses = addresses;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Card getCard() {
		return this.card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public String getUserPwd() {
		return this.userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserDesc() {
		return this.userDesc;
	}

	public void setUserDesc(String userDesc) {
		this.userDesc = userDesc;
	}

	public Integer getUserStatus() {
		return this.userStatus;
	}

	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}

	public Integer getUserAge() {
		return this.userAge;
	}

	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}

	public Set getAddresses() {
		return this.addresses;
	}

	public void setAddresses(Set addresses) {
		this.addresses = addresses;
	}

}