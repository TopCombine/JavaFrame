package com.sxt.struts2.web;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 业务类
 * @author Administrator
 *
 */
public class UserAction  extends ActionSupport{
	//用户名 
	private String userName;
	//密码
	private String password;
	//长相
	private String face;
	

	public String getFace() {
		return face;
	}

	public void setFace(String face) {
		this.face = face;
	}

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

	
	public String execute() throws Exception {
		
		System.out.println("收到请求"+userName+"=="+password+"=="+face);
		return "ind";
	}

}
