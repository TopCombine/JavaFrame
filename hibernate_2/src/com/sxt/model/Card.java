package com.sxt.model;
/**
 * 身份证
 * @author Administrator
 *
 */
public class Card {
	
	private int cardId;
	
	private String cardNo;
	//一对一主键关联
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getCardId() {
		return cardId;
	}

	public void setCardId(int cardId) {
		this.cardId = cardId;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

}
