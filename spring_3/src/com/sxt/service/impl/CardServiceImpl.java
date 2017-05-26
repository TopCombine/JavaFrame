package com.sxt.service.impl;

import com.sxt.model.Card;
import com.sxt.service.ICardService;
/**
 * 身份证服务层实现类
 * @author Administrator
 *
 */
public class CardServiceImpl implements ICardService{

	public Card getCard(int cardId) {
		System.out.println("取得身份证");
		return null;
	}

	public int saveCard(Card card) {
		System.out.println("保存身份证");
		return 0;
	}
	

}
