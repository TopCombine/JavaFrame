package com.sxt.web;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.sxt.dao.UserDAO;
import com.sxt.model.User;
import com.sxt.util.PageUtil;

public class UserAction extends ActionSupport implements RequestAware {

	Map<String, Object> req;

	public void setRequest(Map<String, Object> req) {
		this.req = req;
	}

	User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String updateUser() throws Exception {
		UserDAO userDao = new UserDAO();
		userDao.updateUser(user);
		return "user_list_action";
	}
	
	public String saveUser() throws Exception {
		UserDAO userDao = new UserDAO();
		userDao.save(user);
		return "user_list_action";
	}

	public String deleteUser() throws Exception {

		String userId = ServletActionContext.getRequest()
				.getParameter("userId");

		UserDAO userDao = new UserDAO();
		userDao.delete(Integer.parseInt(userId));
		return "user_list_action";
	}

	public String findUserList() throws Exception {

		String page = ServletActionContext.getRequest().getParameter("page");
		if (page == null || page.equals("")) {
			page = "1";
		}
		UserDAO userDao = new UserDAO();
		int rowCount = userDao.findAllCount();
		// 得到分页工具类
		PageUtil pageUtil = new PageUtil(rowCount, Integer.parseInt(page), 5);
		// 取得用户列表
		List<User> userList = userDao.findAll(pageUtil);
		// 存入请求中
		req.put("userList", userList);
		req.put("pageUtil", pageUtil);
		return "user_list";
	}

	public String findUserDetail() throws Exception {
		String userId = ServletActionContext.getRequest()
				.getParameter("userId");
		String flag = ServletActionContext.getRequest()
		.getParameter("flag");
		UserDAO userDao = new UserDAO();
		User user = userDao.findById(Integer.parseInt(userId));
		req.put("user", user);
		if(flag!=null && flag.equals("update")){
			return "user_update";
		}else if(flag!=null && flag.equals("detail")){
			return "user_detail";
		}
		return null;
		
	}

}
