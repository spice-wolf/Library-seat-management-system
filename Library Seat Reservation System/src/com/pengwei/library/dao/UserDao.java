package com.pengwei.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.pengwei.library.bean.User;

/**
 * 用户Dao类
 * @author 彭威
 *
 */
public class UserDao {

	/**
	 * 登录验证
	 * @param conn
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User login(Connection conn, User user) throws Exception {
		User resultUser = null;
		String sql = "select * from t_user where userName = ? and password = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		// 界面传过来的数据
		pstmt.setString(1, user.getUserName());
		pstmt.setString(2, user.getPassword());
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			resultUser = new User();
			resultUser.setId(rs.getInt("id"));
			resultUser.setUserName(rs.getString("userName"));
			resultUser.setPassword(rs.getString("password"));
		}
		
		return resultUser;
	}
	
	/**
	 * 注册功能实现
	 * @param conn
	 * @param user
	 * @return 当注册所用的用户名与已有的用户名重复时，返回false；否则，返回true
	 * @throws Exception
	 */
	public boolean register(Connection conn, User user) throws Exception {
		User resultuser = null;
		String querySql = "select * from t_user where userName = ?";
		PreparedStatement pstmtOne = conn.prepareStatement(querySql);
		pstmtOne.setString(1, user.getUserName());
		ResultSet rs = pstmtOne.executeQuery();
		if (rs.next()) {
			return false;
		} else {
			String insertSql = "insert into t_user (userName, password) values (?, ?)";
			PreparedStatement pstmtTwo = conn.prepareStatement(insertSql);
			pstmtTwo.setString(1, user.getUserName());
			pstmtTwo.setString(2, user.getPassword());
			pstmtTwo.executeUpdate();
			return true;
		}
	}
}
