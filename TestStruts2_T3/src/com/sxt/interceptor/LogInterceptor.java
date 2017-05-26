package com.sxt.interceptor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.sxt.model.User;

public class LogInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation inv) throws Exception {
		
		Map<String,Object> session=inv.getInvocationContext().getSession();
		//类名
		String actionName=inv.getAction().getClass().getName();
		User user=(User) session.get("user");
		
		//只处理登录以后的日志
		if(user!=null){
			String userName=user.getUserName();
			//方法
			String method=inv.getProxy().getMethod();
			
			//时间
			Date date=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateStr=sdf.format(date);
			
			System.out.println("系统日志："+userName+" 在 "+dateStr +"操作了 "+ actionName +" 中的 "+method+"方法");
		}
		//用户名
	
		//传递动作
		inv.invoke();
		return null;
	}
	
}
