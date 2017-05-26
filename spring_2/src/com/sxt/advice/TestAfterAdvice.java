package com.sxt.advice;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

/**
 * 后置通知
 * @author Administrator
 *
 */
public class TestAfterAdvice implements AfterReturningAdvice{

	public void afterReturning(Object arg0, Method arg1, Object[] arg2,
			Object arg3) throws Throwable {

			System.out.println("执行了后置通知");
	}

}
