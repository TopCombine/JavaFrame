package com.sxt.web;

import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport {

	private String name;
	
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	@Override
	public String execute() throws Exception {
		System.out.println("执行了action==="+name);
		return "other";
	}
}
