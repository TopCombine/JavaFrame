package com.sxt.struts2.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.sxt.struts2.dao.UserDao;
import com.sxt.struts2.model.User;
import com.sxt.struts2.utils.PageUtil;

public class UserAction extends ActionSupport implements RequestAware {

	// 通过容器将request注入进来 IOC
	Map<String, Object> req;

	public void setRequest(Map<String, Object> requ) {
		this.req = requ;
	}

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String findUserToUpdate() throws Exception {

		// 取得要更新的用户id
		String updateUserId = ServletActionContext.getRequest().getParameter("id");
		// 新建一个dao层
		UserDao userDao = new UserDao();
		// 调用dao层查询用户
		User user=userDao.findUserById(Integer.parseInt(updateUserId));
		//将数据装载到请求域中
		ServletActionContext.getRequest().setAttribute("user", user);
		// 跳转显示流程
		return "upate_user";
	}
	
	public String findUserToDetail() throws Exception {

		// 取得要更新的用户id
		String detailUserId = ServletActionContext.getRequest().getParameter("id");
		// 新建一个dao层
		UserDao userDao = new UserDao();
		// 调用dao层查询用户
		User user=userDao.findUserById(Integer.parseInt(detailUserId));
		//将数据装载到请求域中
		ServletActionContext.getRequest().setAttribute("user", user);
		// 跳转显示流程
		return "detail_user";
	}
	
	public String update() throws Exception {

		// 新建一个DAO层
		UserDao userDao = new UserDao();
		// 调用DAO层保存数据
		userDao.updateUser(user);
		// 跳转
		return find();
	}

	/**
	 * 删除用户
	 * 
	 * @return
	 * @throws Exception
	 */
	public String delete() throws Exception {

		// 取得要删除的用户id
		String deleteUserId = ServletActionContext.getRequest().getParameter(
				"id");
		// 新建一个dao层
		UserDao userDao = new UserDao();
		// 调用dao层删除
		userDao.deleteUser(Integer.parseInt(deleteUserId));
		// 跳转显示流程
		return find();
	}

	/**
	 * 保存用户
	 * 
	 * @return
	 * @throws Exception
	 */
	public String save() throws Exception {

		// 取得提交的参数

		// 新建一个DAO层
		UserDao userDao = new UserDao();
		// 调用DAO层保存数据
		userDao.saveUser(user);
		// 跳转
		return find();
	}

	public String find() throws Exception {

		HttpServletRequest req = ServletActionContext.getRequest();

		// =====================取得查询表单提交的参数
		User queryUser = new User();
		queryUser.setUserName(req.getParameter("queryUserName"));

		String ageStr = req.getParameter("queryAge");// age=abc
		if (ageStr != null && !ageStr.equals("")) {
			queryUser.setAge(Integer.parseInt(ageStr));
		}
		// ====================初始化工作=========================

		// 取得当前页
		String page = req.getParameter("page");
		// 如果有误 就赋一个默认值=1
		if (page == null || page.equals("")) {
			page = "1";
		}

		UserDao userDao = new UserDao();
		// 取得总行数
		int rowCount = userDao.findUserListCount(queryUser);

		// 新建分页工具类
		PageUtil pageUtil = new PageUtil(rowCount, Integer.parseInt(page));
		// =======================================
		// 查询用户列表信息
		List<User> userList = userDao.findUserList(pageUtil, queryUser);

		// 将用户和工具类装入请求域中 Application[整个容器共享] > session[一次对话] > request[一次请求]
		// pageContext[页面]
		req.setAttribute("userList", userList);
		req.setAttribute("pageUtil", pageUtil);

		return "list_user";
	}

}
