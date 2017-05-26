package com.sxt.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Card entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Card implements java.io.Serializable {

	// Fields

	private Integer cardId;
	private String cardNo;
	private Set users = new HashSet(0);

	// Constructors

	/** default constructor */
	public Card() {
	}

	/** full constructor */
	public Card(String cardNo, Set users) {
		this.cardNo = cardNo;
		this.users = users;
	}

	// Property accessors

	public Integer getCardId() {
		return this.cardId;
	}

	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}

	public String getCardNo() {
		return this.cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public Set getUsers() {
		return this.users;
	}

	public void setUsers(Set users) {
		this.users = users;
	}

}