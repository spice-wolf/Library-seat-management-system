package com.pengwei.library.bean;

/**
 * 用户实体
 * @author 愿罚三杯不开口
 *
 */
public class User {

	/** 编号 */
	private int id;
	/** 用户名 */
	private String userName;
	/** 密码 */
	private String password;
	
	public User() {
		super();
	}
	
	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}

