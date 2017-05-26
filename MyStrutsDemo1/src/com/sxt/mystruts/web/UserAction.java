package com.sxt.mystruts.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxt.mystruts.model.User;
import com.sxt.struts3.Action;
import com.sxt.struts3.ActionForm;

/**
 * 一个独立用户业务处理类
 * @author Administrator
 *
 */
public class UserAction implements Action{
	
	public String execute(HttpServletRequest request,HttpServletResponse response,ActionForm form){
		
		User user=(User)form;
		//添加到数据库
		System.out.println(user.getUserName()+"="+user.getPassword()+"="+user.getAge()+"="+user.getEmail());
		//将用户数据放到请求域中
		request.setAttribute("user", user);
		return "adduserresult.jsp";
	}

}
