package com.sxt.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sxt.model.User;
import com.sxt.service.IUserService;
import com.sxt.util.PageUtil;

public class UserAction extends ActionSupport {

	private User user = new User();

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
		// 保存用户
		userService.saveUser(user);
		ServletActionContext.getRequest().setAttribute("user", user);
		// 跳转
		return "result";
	}

	public String findUserList() throws Exception {
		HttpServletRequest req = ServletActionContext.getRequest();
		// 组装数据并得到pageUtil
		String page = req.getParameter("page");
		if (page == null || page.equals("")) {
			page = "1";
		}

		int rowCount = userService.findUserListCount(user);
		// 组装查询的参数
		PageUtil pageUtil = new PageUtil(rowCount, Integer.parseInt(page));
		user.setPageUtil(pageUtil);

		// 查询
		List<User> userList = userService.findUserList(user);
		// 将参数放到请求域中
		req.setAttribute("userList", userList);
		req.setAttribute("pageUtil", pageUtil);

		return "list_user";
	}
}
