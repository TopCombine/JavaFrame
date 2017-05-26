package com.sxt.web;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sxt.model.User;
import com.sxt.service.IUserService;

public class UserAction extends ActionSupport {
	
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	private IUserService userService;
	
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	public String saveUser() throws Exception {
		//保存用户
		userService.saveUser(user);
		ServletActionContext.getRequest().setAttribute("user", user);
		//跳转
		return "result";
	}
}
