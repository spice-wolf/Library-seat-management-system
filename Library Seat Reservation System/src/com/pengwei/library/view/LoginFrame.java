package com.pengwei.library.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.pengwei.library.bean.User;
import com.pengwei.library.dao.UserDao;
import com.pengwei.library.util.DbUtil;
import com.pengwei.library.util.StringUtil;

/**
 * 登录主界面
 * @author 彭威
 *
 */
public class LoginFrame extends JFrame{
	
	private JLabel userLabel;
	private JLabel passwordLabel;
	private JTextField userNameTxt;
	private JTextField passwordTxt;
	private JButton loginBtn;
	private JButton registerBtn;
	
	private DbUtil dbUtil = new DbUtil();
	private UserDao userDao = new UserDao();
	
	public LoginFrame() {
		setTitle("图书馆座位预定系统");
		
		final JPanel panel = new LoginPanel();
		panel.setLayout(null);
		getContentPane().add(panel);
		setBounds(650, 250, panel.getWidth(), panel.getHeight());
		
		userLabel = new JLabel();
		passwordLabel = new JLabel();
		userLabel.setText("用户名:");
		passwordLabel.setText("密  码:");
		userLabel.setBounds(135, 133, 300, 30);
		userLabel.setFont(new Font("黑体", Font.BOLD, 18));
		passwordLabel.setBounds(135, 170, 300, 30);
		passwordLabel.setFont(new Font("黑体", Font.BOLD, 18));
		panel.add(userLabel);
		panel.add(passwordLabel);
		
		userNameTxt = new JTextField();
		userNameTxt.setBounds(200, 135, 200, 25);
		panel.add(userNameTxt);
		passwordTxt = new JPasswordField();
		passwordTxt.setBounds(200, 175, 200, 25);
		panel.add(passwordTxt);
		passwordTxt.addKeyListener(new KeyAdapter() {
			public void keyPressed(final KeyEvent e) {
				if (e.getKeyCode() == 10)
					loginBtn.doClick();
			}
		});
		
		loginBtn = new JButton();
		loginBtn.setText("登录");
		loginBtn.setBounds(205, 230, 80, 30);
		panel.add(loginBtn);
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				loginActionPerformed(e);
				
			}
		});
		
		registerBtn = new JButton();
		registerBtn.setText("注册");
		registerBtn.setBounds(315, 230, 80, 30);
		panel.add(registerBtn);
		registerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registerActionPerformed(e);
			}
		});
		
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	/**
	 * 登录事件处理
	 * @param evt
	 */
	private void loginActionPerformed(ActionEvent evt) {
		String userName = this.userNameTxt.getText();
		String password = this.passwordTxt.getText();
		
		if (StringUtil.isEmpty(userName)) {
			JOptionPane.showMessageDialog(null, "用户名不能为空");
			return ;
		}
		if (StringUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(null, "密码不能为空");
			return ;
		}
		
		User user = new User(userName, password);
		Connection conn = null;
		try {
			conn = dbUtil.getCon();
			User currentUser = userDao.login(conn, user);
			
			if (currentUser != null) {
				JOptionPane.showMessageDialog(null, "登录成功");
			} else {
				JOptionPane.showMessageDialog(null, "用户名或密码错误");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * 注册事件处理
	 * @param e
	 */
	protected void registerActionPerformed(ActionEvent e) {
		String userName = this.userNameTxt.getText();
		String password = this.passwordTxt.getText();
		
		if (StringUtil.isEmpty(userName)) {
			JOptionPane.showMessageDialog(null, "用户名不能为空");
			return ;
		}
		if (StringUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(null, "密码不能为空");
			return ;
		}
		
		User user = new User(userName, password);
		Connection conn = null;
		try {
			conn = dbUtil.getCon();
			if (userDao.register(conn, user)) {
				JOptionPane.showMessageDialog(null, "注册成功");
			} else {
				JOptionPane.showMessageDialog(null, "该用户已存在");
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new LoginFrame();
	}
}
