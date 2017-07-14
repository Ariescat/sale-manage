package org.lqz.module.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;
import org.lqz.framework.util.MyFont;
import org.lqz.module.services.Impl.StockOrderServiceImpl;

public class ModifyStockInputJFrame extends JFrame implements MouseListener {

	// 定义全局组件
	JPanel backgroundPanel, labelPanel, contentPanel, buttonPanel;
	JLabel label_billno, label_name, label_amount, label_category, label_warehouse, label_handler;
	JTextField billno, name, amount, category, warehouse, handler;
	JButton button_modify;

	// 获得屏幕的大小
	final static int width = Toolkit.getDefaultToolkit().getScreenSize().width;
	final static int height = Toolkit.getDefaultToolkit().getScreenSize().height;

	// 表格对象
	JTable table;
	int selectedRow;
	StockInputManagerJPanel parentPanel;

	public ModifyStockInputJFrame(StockInputManagerJPanel parentPanel, JTable table, int selectedRow) {
		this.table = table;
		this.selectedRow = selectedRow;
		this.parentPanel = parentPanel;

		initBackgroundPanel();

		this.add(backgroundPanel);

		this.setTitle("修改入库单");
		this.setSize(480, 270);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}

	// 初始化背景面板
	public void initBackgroundPanel() {
		backgroundPanel = new JPanel(new BorderLayout());

		initContentPanel();
		initButtonPanel();
		initLabelPanel();

		backgroundPanel.add(labelPanel, "North");
		backgroundPanel.add(contentPanel, "Center");
		backgroundPanel.add(buttonPanel, "South");
	}

	// 初始化label面板
	public void initLabelPanel() {

		labelPanel = new JPanel();

		JLabel title = new JLabel("入库信息");
		title.setFont(MyFont.Static);

		labelPanel.add(title);
	}

	// 初始化商品信息面板
	public void initContentPanel() {
		contentPanel = new JPanel(new GridLayout(6, 2));

		label_billno = new JLabel("订单号", JLabel.CENTER);
		label_name = new JLabel("商品名称", JLabel.CENTER);
		label_amount = new JLabel("入库数量", JLabel.CENTER);
		label_category = new JLabel("所属分类", JLabel.CENTER);
		label_warehouse = new JLabel("所属仓库", JLabel.CENTER);
		label_handler = new JLabel("经手人", JLabel.CENTER);

		double amount_double = (Double) table.getValueAt(selectedRow, 3);
		String amount_String = String.valueOf(amount_double);

		billno = new JTextField((String) table.getValueAt(selectedRow, 1));
		billno.setEnabled(false);
		name = new JTextField((String) table.getValueAt(selectedRow, 2));
		name.setEnabled(false);
		amount = new JTextField(amount_String);
		amount.setEnabled(true);
		category = new JTextField((String) table.getValueAt(selectedRow, 4));
		category.setEnabled(false);
		warehouse = new JTextField((String) table.getValueAt(selectedRow, 5));
		warehouse.setEnabled(false);
		handler = new JTextField((String) table.getValueAt(selectedRow, 6));
		handler.setEnabled(false);

		contentPanel.add(label_billno);
		contentPanel.add(billno);
		contentPanel.add(label_name);
		contentPanel.add(name);
		contentPanel.add(label_amount);
		contentPanel.add(amount);
		contentPanel.add(label_category);
		contentPanel.add(category);
		contentPanel.add(label_warehouse);
		contentPanel.add(warehouse);
		contentPanel.add(label_handler);
		contentPanel.add(handler);

	}

	// 初始化按钮面板
	public void initButtonPanel() {
		buttonPanel = new JPanel();

		button_modify = new JButton("保存修改");
		button_modify.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.lightBlue));
		button_modify.setForeground(Color.white);
		button_modify.setFont(MyFont.Static);
		button_modify.addMouseListener(this);

		buttonPanel.add(button_modify);
	}

	// 鼠标点击事件
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == button_modify) {

			String amount_String = amount.getText().trim();

			if (amount_String.isEmpty()) {
				JOptionPane.showMessageDialog(null, "请输入入库数量");
			} else {
				int result = 0;
				double amount_double = Double.valueOf(amount_String);
				String id = (String) table.getValueAt(selectedRow, 0);
				Object[] params = { amount_double, id };
				StockOrderServiceImpl stockOrderService = new StockOrderServiceImpl();
				try {
					result = stockOrderService.updateStockInputById(params);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				if (result > 0) {
					JOptionPane.showMessageDialog(null, "入库单修改成功");
					this.setVisible(false);
					parentPanel.refreshTablePanel();
				}
			}
		}

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
