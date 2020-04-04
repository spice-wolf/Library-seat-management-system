package com.pengwei.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.pengwei.library.bean.User;

/**
 * �û�Dao��
 * @author ����
 *
 */
public class UserDao {

	/**
	 * ��¼��֤
	 * @param conn
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User login(Connection conn, User user) throws Exception {
		User resultUser = null;
		String sql = "select * from t_user where userName = ? and password = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		// ���洫����������
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
	 * ע�Ṧ��ʵ��
	 * @param conn
	 * @param user
	 * @return ��ע�����õ��û��������е��û����ظ�ʱ������false�����򣬷���true
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
