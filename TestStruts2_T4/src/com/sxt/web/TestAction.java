package com.sxt.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.sxt.model.User;

/**
 * 测试OGNL
 * @author Administrator
 *
 */
public class TestAction extends ActionSupport implements RequestAware,SessionAware{
	
	@Override
	public String execute() throws Exception {
		System.out.println("O 啦");
		//请求域
		//request.put("var", "request_var");
		//会话
		//session.put("var", "session_var");
		//上下文
		ServletActionContext.getServletContext().setAttribute("var", "application_var");
		
		
		HashMap<String,String> map=new HashMap<String,String>();
		map.put("china", "中国");
		map.put("USA", "美国");
		map.put("E", "俄罗斯");
		map.put("JPA", "小日本");
		request.put("map", map);
		
		User user1=new User(1,"张伯勋",new Date());
		user1.setSex(38);
		User user2=new User(2,"生庆",new Date());
		User user3=new User(3,"江江",new Date());
		user3.setSex(0);
		User user4=new User(4,"松鼠",new Date());
		User user5=new User(5,"温晕",new Date());
		user5.setSex(15);
		
		//新建用户对象装入集合中
		List<User> userList=new ArrayList<User>();
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		userList.add(user4);
		userList.add(user5);
		
		request.put("userList",userList);
		
		
		request.put("user",user5);
		
		return this.SUCCESS;
	}

	//通过容器注入请求
	Map<String, Object> request;
	//通过容器注入会话
	Map<String, Object> session;
	
	public void setRequest(Map<String, Object> request) {
		this.request=request;
	}

	public void setSession(Map<String, Object> session) {
		this.session=session;
	}

}
