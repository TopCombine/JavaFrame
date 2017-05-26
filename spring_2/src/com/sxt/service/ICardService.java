package com.sxt.service;

import com.sxt.model.Card;
/**
 * 身份证服务层接口
 * @author Administrator
 *
 */
public interface ICardService {
	
	public int saveCard(Card card);
	
	public Card getCard(int cardId);

}
