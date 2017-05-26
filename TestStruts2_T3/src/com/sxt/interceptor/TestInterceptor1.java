package com.sxt.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
/**
 * 一个普通的拦截器
 * @author Administrator
 *
 */
public class TestInterceptor1 extends AbstractInterceptor{
	
	@Override
	public void init() {
		System.out.println("初始化了拦截器");
	}

	@Override
	public void destroy() {
		System.out.println("销毁了拦截器");
	}
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("执行了拦截");
		//往下传递动作
		invocation.invoke();//action.execute()
		return null;
	}

}
