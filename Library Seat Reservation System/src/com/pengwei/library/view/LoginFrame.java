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
 * ��¼������
 * @author ����
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
		setTitle("ͼ�����λԤ��ϵͳ");
		
		final JPanel panel = new LoginPanel();
		panel.setLayout(null);
		getContentPane().add(panel);
		setBounds(650, 250, panel.getWidth(), panel.getHeight());
		
		userLabel = new JLabel();
		passwordLabel = new JLabel();
		userLabel.setText("�û���:");
		passwordLabel.setText("��  ��:");
		userLabel.setBounds(135, 133, 300, 30);
		userLabel.setFont(new Font("����", Font.BOLD, 18));
		passwordLabel.setBounds(135, 170, 300, 30);
		passwordLabel.setFont(new Font("����", Font.BOLD, 18));
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
		loginBtn.setText("��¼");
		loginBtn.setBounds(205, 230, 80, 30);
		panel.add(loginBtn);
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				loginActionPerformed(e);
				
			}
		});
		
		registerBtn = new JButton();
		registerBtn.setText("ע��");
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
	 * ��¼�¼�����
	 * @param evt
	 */
	private void loginActionPerformed(ActionEvent evt) {
		String userName = this.userNameTxt.getText();
		String password = this.passwordTxt.getText();
		
		if (StringUtil.isEmpty(userName)) {
			JOptionPane.showMessageDialog(null, "�û�������Ϊ��");
			return ;
		}
		if (StringUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(null, "���벻��Ϊ��");
			return ;
		}
		
		User user = new User(userName, password);
		Connection conn = null;
		try {
			conn = dbUtil.getCon();
			User currentUser = userDao.login(conn, user);
			
			if (currentUser != null) {
				JOptionPane.showMessageDialog(null, "��¼�ɹ�");
			} else {
				JOptionPane.showMessageDialog(null, "�û������������");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * ע���¼�����
	 * @param e
	 */
	protected void registerActionPerformed(ActionEvent e) {
		String userName = this.userNameTxt.getText();
		String password = this.passwordTxt.getText();
		
		if (StringUtil.isEmpty(userName)) {
			JOptionPane.showMessageDialog(null, "�û�������Ϊ��");
			return ;
		}
		if (StringUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(null, "���벻��Ϊ��");
			return ;
		}
		
		User user = new User(userName, password);
		Connection conn = null;
		try {
			conn = dbUtil.getCon();
			if (userDao.register(conn, user)) {
				JOptionPane.showMessageDialog(null, "ע��ɹ�");
			} else {
				JOptionPane.showMessageDialog(null, "���û��Ѵ���");
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new LoginFrame();
	}
}
