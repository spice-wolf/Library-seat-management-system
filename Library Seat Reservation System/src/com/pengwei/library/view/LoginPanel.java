package com.pengwei.library.view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * µÇÂ¼Ò³ÃæÍ¼Æ¬Õ¹Ê¾
 * @author ÅíÍþ
 *
 */
public class LoginPanel extends JPanel {

	protected ImageIcon icon;
	private int width, height;
	
	public LoginPanel() {
		super();
		icon = new ImageIcon("images/login.jpg");
		width = icon.getIconWidth();
		height = icon.getIconHeight();
		setSize(width, height);
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image img = icon.getImage();
		g.drawImage(img, 0, 0, getParent());
	}
}
