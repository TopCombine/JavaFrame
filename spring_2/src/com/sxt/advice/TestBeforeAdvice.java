package com.sxt.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;
/**
 * 前置通知
 * @author Administrator
 *
 */
public class TestBeforeAdvice implements MethodBeforeAdvice{

	public void before(Method method, Object[] arg, Object target)
			throws Throwable {
		
		System.out.println("执行了前置通知");
	}

}
