package com.sxt.util;

import org.aspectj.lang.JoinPoint;

import com.sxt.model.User;


/**
 * 事务类
 * @author Administrator
 *
 */
public class TransactionHandler {
	
	JoinPoint jpEnd;
	
	public void begins(JoinPoint jp){
		
		jpEnd=jp;
		Object[] objs=jp.getArgs();
		for (Object object : objs) {
			User user=(User)object;
			
			System.out.println(user.getUserName()+"param==="+object.toString());
		}
		System.out.println("开始");
	}
	
	public void end(JoinPoint jp){
		
		System.out.println("结束"+jp.getTarget().getClass());
	}

}
