package com.pengwei.library.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * ���ݿ⹤����
 * @author ����
 *
 */
public class DbUtil {

	private String dbUrl = "jdbc:mysql://localhost:3306/db_library?useSSL=false";	
	private String dbUserName = "root";		
	private String dbPassword = "rq5589144...";		
	private String jdbcName = "com.mysql.jdbc.Driver";		
	
	/**
	 * ��ȡ���ݿ�����
	 * @return
	 * @throws Exception
	 */
	public Connection getCon() throws Exception {
		Class.forName(jdbcName);
		Connection conn = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		
		return conn;
	}
	
	/**
	 * �ر����ݿ�����
	 * @param conn
	 * @throws Exception
	 */
	public void closeCon(Connection conn) throws Exception {
		if (conn != null) {
			conn.close();
		}
	}

	public static void main(String[] args) {
		DbUtil dbUtil = new DbUtil();
		try {
			dbUtil.getCon();
			System.out.println("���ݿ����ӳɹ�");
		} catch (Exception e) {
		 	e.printStackTrace();
		 	System.out.println("���ݿ�����ʧ��");
		}
	}
}
