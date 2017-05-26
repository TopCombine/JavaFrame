package com.sxt.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
/**
 * 环绕通知
 * @author Administrator
 *
 */
public class TestCompareAdvice implements MethodInterceptor{

	public Object invoke(MethodInvocation inv) throws Throwable {
		
		System.out.println("执行了环绕通知");
		//通过
		return inv.proceed();
	}

}
