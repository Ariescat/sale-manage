package org.lqz.framework.util;

/**
 * 说明:自定义带有背景图片的面板工具类
 */
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class ImagePanel extends JPanel {

	// 创建图像变量
	Image im;

	// 构造函数
	public ImagePanel(Image im) {
		this.im = im;// 初始化图像变量
		// 获取当前屏幕宽高
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setSize(width, height);
	}

	// 绘制组件
	@Override
	public void paintComponent(Graphics g) {
		// 继承父类方法
		super.paintComponent(g);
		g.drawImage(im, 0, 0, this.getWidth(), this.getHeight(), this);
	}
}
