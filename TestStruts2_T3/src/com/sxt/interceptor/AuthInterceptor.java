package com.sxt.interceptor;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.sxt.model.User;

public class AuthInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		System.out.println(invocation.getAction().getClass().getName());
		
		
		Map<String,Object> session=invocation.getInvocationContext().getSession();
		User user=(User) session.get("user");
		System.out.println(invocation.getProxy().getMethod());
		//如果不是登录动作就检查
		if(!invocation.getProxy().getMethod().endsWith("login")){
			if(user==null){
				ServletActionContext.getRequest().setAttribute("msg", "请先登后再操作");
				return "login";
			}
		}
		//如果是登录动作就放行
		invocation.invoke();
		return null;
	}
	
}
