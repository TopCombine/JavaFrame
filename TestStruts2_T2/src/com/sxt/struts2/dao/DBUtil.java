package com.sxt.struts2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 数据库的连接
 * @author Administrator
 *
 */
public class DBUtil {
	
	/**
	 * 得到数据库连接
	 * @return
	 */
	public static Connection getConn(){
		
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/bbs?useUnicode=true&characterEncoding=UTF-8";
			conn=DriverManager.getConnection(url, "root", "123456");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 关闭连接
	 * @param conn
	 * @param stat
	 * @param rs
	 */
	public static void closeConn(Connection conn,Statement stat,ResultSet rs){
		try {
			if(rs!=null){
				rs.close();
			}
			if(stat!=null){
				stat.close();
			}
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
