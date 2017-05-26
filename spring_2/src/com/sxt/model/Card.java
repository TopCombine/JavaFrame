package com.sxt.model;

/**
 * 身份证类
 * @author Administrator
 *
 */
public class Card {
	
	private int cardId;
	
	private String cardNo;
	
	public Card() {
	}

	public Card(int cardId, String cardNo) {
		super();
		this.cardId = cardId;
		this.cardNo = cardNo;
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
