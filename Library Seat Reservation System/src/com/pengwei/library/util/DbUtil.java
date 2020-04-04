package com.pengwei.library.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 数据库工具类
 * @author 彭威
 *
 */
public class DbUtil {

	private String dbUrl = "jdbc:mysql://localhost:3306/db_library?useSSL=false";	
	private String dbUserName = "root";		
	private String dbPassword = "rq5589144...";		
	private String jdbcName = "com.mysql.jdbc.Driver";		
	
	/**
	 * 获取数据库连接
	 * @return
	 * @throws Exception
	 */
	public Connection getCon() throws Exception {
		Class.forName(jdbcName);
		Connection conn = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		
		return conn;
	}
	
	/**
	 * 关闭数据库连接
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
			System.out.println("数据库连接成功");
		} catch (Exception e) {
		 	e.printStackTrace();
		 	System.out.println("数据库连接失败");
		}
	}
}
