package com.sxt.struts2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sxt.struts2.model.User;
import com.sxt.struts2.utils.PageUtil;

/**
 * 用户的数据处理
 * 
 * @author Administrator
 * 
 */
public class UserDao {

	
	/**
	 * 删除用户
	 * @param userId
	 * @return
	 */
	public int deleteUser(int userId) {

		Connection conn = null;
		Statement stat = null;

		try {
			conn = DBUtil.getConn();
			stat = conn.createStatement();
			String sql = "delete from bbs_user  where user_id="+userId;
			stat.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}
	/**
	 * 保存的方法
	 * 
	 * @param user
	 * @return
	 */
	public int saveUser(User user) {

		Connection conn = null;
		Statement stat = null;

		try {
			conn = DBUtil.getConn();
			stat = conn.createStatement();
			String sql = "insert into bbs_user(user_name,user_pwd,user_age) "
					+ " values('" + user.getUserName() + "','"
					+ user.getPassword() + "'," + user.getAge() + ")";
			stat.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}
	
	/**
	 * 更新用户信息
	 * @param user
	 * @return
	 */
	public int updateUser(User user) {

		Connection conn = null;
		PreparedStatement stat = null;

		try {
			conn = DBUtil.getConn();
			String sql = "update  bbs_user set user_name=?,user_pwd=?,user_age=? where user_id=?";
			stat = conn.prepareStatement(sql);
			stat.setString(1, user.getUserName());
			stat.setString(2, user.getPassword());
			stat.setInt(3, user.getAge());
			stat.setInt(4, user.getUserId());
			
			stat.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}
	
	
	public List<User> findUserList(PageUtil pageUtil,User users) {

		//===============================组装条件
		// where 1=1 and user_name like '%abc%' and user_age=12
		String cond="where 1=1 ";
		//如果用户名有就加到条件中去
		if(users!=null && users.getUserName()!=null && !users.getUserName().equals("")){
			//条件的拼装
			cond=cond+" and  user_name like '%"+users.getUserName()+"%'";
		}
		if(users!=null && users.getAge()!=0){
			cond=cond+" and user_age="+users.getAge();
		}
		
		//=================================================
		Connection conn = null;
		Statement stat = null;
		ResultSet rs=null;
		List<User> userList=new ArrayList<User>();
		try {
			conn = DBUtil.getConn();
			stat = conn.createStatement();
			String sql = "select * from bbs_user "+cond+" order by user_id desc limit "+pageUtil.getStartRow()+","+pageUtil.getPageSize();
			//将结果装到用户集合列表中
			rs=stat.executeQuery(sql);
			while(rs.next()){
				int userId=rs.getInt("user_id");
				String userName=rs.getString("user_name");
				String userPwd=rs.getString("user_pwd");
				int userAge=rs.getInt("user_age");
				
				User user=new User();
				user.setAge(userAge);
				user.setUserName(userName);
				user.setPassword(userPwd);
				user.setUserId(userId);
				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(conn, stat, rs);
		}
		return userList;

	}
	
	public int findUserListCount(User user) {
		
		//===============组装条件===============================
		// where 1=1 and user_name like '%abc%' and user_age=12
		String cond="where 1=1 ";
		//如果用户名有就加到条件中去
		if(user!=null && user.getUserName()!=null && !user.getUserName().equals("")){
			cond=cond+" and  user_name like '%"+user.getUserName()+"%'";
		}
		if(user!=null && user.getAge()!=0){
			cond=cond+" and user_age="+user.getAge();
		}
		//============================================
		
		//有名字，没年龄
		//有名字，有年龄
		Connection conn = null;
		Statement stat = null;
		ResultSet rs=null;
		int rowCount=0;
		try {
			conn = DBUtil.getConn();
			stat = conn.createStatement();
			String sql = "select count(*) as rowCounts from bbs_user "+cond;
			//将结果装到用户集合列表中
			rs=stat.executeQuery(sql);
			if(rs.next()){
				rowCount=rs.getInt("rowCounts");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(conn, stat, rs);
		}
		return rowCount;

	}
	
	/**
	 * 根据ID查询用户
	 * @param userId
	 * @return
	 */
	public User findUserById(int userId) {

		Connection conn = null;
		Statement stat = null;
		ResultSet rs=null;
		User user=null;
		try {
			conn = DBUtil.getConn();
			stat = conn.createStatement();
			String sql = "select * from bbs_user where user_id="+userId;
			//将结果装到用户集合列表中
			rs=stat.executeQuery(sql);
			if(rs.next()){
				String userName=rs.getString("user_name");
				String userPwd=rs.getString("user_pwd");
				int userAge=rs.getInt("user_age");
				
				user=new User();
				user.setAge(userAge);
				user.setUserName(userName);
				user.setPassword(userPwd);
				user.setUserId(userId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(conn, stat, rs);
		}
		return user;

	}

}
