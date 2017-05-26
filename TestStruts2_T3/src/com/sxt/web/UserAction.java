package com.sxt.web;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sxt.model.User;

public class UserAction extends ActionSupport{
	
	private String userName;
	
	private String password;
	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String login() throws Exception {
		System.out.println(userName+"===="+password);
		//从数据库判断是否为正确的帐号和密码
		if(userName!=null && userName.equals("admin")){
			//登录成功能后将用户装入到session中
			User user=new User();
			user.setUserName(userName);
			user.setPassword(password);
			ServletActionContext.getRequest().getSession().setAttribute("user",user);
			
			return "success";
		}else{
			ServletActionContext.getRequest().setAttribute("msg", "帐号或密码错误");
			return "login";
		}
	}
}
