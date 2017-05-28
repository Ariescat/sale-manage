package org.lqz.module.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;
import org.lqz.framework.util.Item;
import org.lqz.framework.util.MyFont;
import org.lqz.module.services.Impl.CategoryServiceImpl;
import org.lqz.module.services.Impl.GoodsServiceImpl;
import org.lqz.module.services.Impl.WarehouseServiceImpl;

public class AddGoodsJFrame extends JFrame implements MouseListener {

	// 定义全局组件
	JPanel backgroundPanel, labelPanel, contentPanel, buttonPanel;
	JLabel label_name, label_price, label_origin, label_stock, label_warehouse, label_category;
	JTextField name, price, origin, stock;
	JComboBox warehouse, category;
	JButton button_add;

	// 获得屏幕的大小
	final static int width = Toolkit.getDefaultToolkit().getScreenSize().width;
	final static int height = Toolkit.getDefaultToolkit().getScreenSize().height;

	// 父面板对象
	GoodsManagerJPanel parentPanel;

	public AddGoodsJFrame(GoodsManagerJPanel parentPanel) {
		this.parentPanel = parentPanel;

		initBackgroundPanel();

		this.add(backgroundPanel);

		this.setTitle("添加商品");
		this.setSize(640, 360);
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

		JLabel title = new JLabel("商品信息");
		title.setFont(MyFont.Static);

		labelPanel.add(title);
	}

	// 初始化商品信息面板
	public void initContentPanel() {
		contentPanel = new JPanel(new GridLayout(6, 2));

		label_name = new JLabel("商品名称", JLabel.CENTER);
		label_price = new JLabel("商品价格", JLabel.CENTER);
		label_origin = new JLabel("商品产地", JLabel.CENTER);
		label_stock = new JLabel("商品库存", JLabel.CENTER);
		label_warehouse = new JLabel("所属仓库", JLabel.CENTER);
		label_category = new JLabel("所属分类", JLabel.CENTER);

		name = new JTextField("");
		price = new JTextField("");
		origin = new JTextField("");
		stock = new JTextField("");

		// 商品种类下拉框
		category = new JComboBox();
		CategoryServiceImpl categoryService = new CategoryServiceImpl();
		List<Object[]> list_category = null;
		try {
			list_category = categoryService.selectAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (list_category != null) {
			int sign = 0;
			for (int i = 0; i < list_category.size(); i++) {
				String id = (String) list_category.get(i)[0];
				String name = (String) list_category.get(i)[1];
				category.addItem(new Item(id, name));
			}
		}

		// 仓库下拉框
		warehouse = new JComboBox();
		WarehouseServiceImpl warehouseService = new WarehouseServiceImpl();
		List<Object[]> list_warehouse = null;
		try {
			list_warehouse = warehouseService.selectAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (list_warehouse != null) {
			int sign = 0;
			for (int i = 0; i < list_warehouse.size(); i++) {
				String id = (String) list_warehouse.get(i)[0];
				String name = (String) list_warehouse.get(i)[1];
				warehouse.addItem(new Item(id, name));
			}
		}

		contentPanel.add(label_name);
		contentPanel.add(name);
		contentPanel.add(label_price);
		contentPanel.add(price);
		contentPanel.add(label_origin);
		contentPanel.add(origin);
		contentPanel.add(label_stock);
		contentPanel.add(stock);
		contentPanel.add(label_category);
		contentPanel.add(category);
		contentPanel.add(label_warehouse);
		contentPanel.add(warehouse);
	}

	// 初始化按钮面板
	public void initButtonPanel() {
		buttonPanel = new JPanel();

		button_add = new JButton("保存");
		button_add.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.lightBlue));
		button_add.setForeground(Color.white);
		button_add.setFont(MyFont.Static);
		button_add.addMouseListener(this);

		buttonPanel.add(button_add);
	}

	// 鼠标点击事件
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == button_add) {

			String name_String = name.getText().trim();
			String price_String = price.getText().trim();
			String origin_String = origin.getText().trim();
			String stock_String = stock.getText().trim();

			if (name_String.isEmpty()) {
				JOptionPane.showMessageDialog(null, "请输入商品名称");
			} else if (price_String.isEmpty()) {
				JOptionPane.showMessageDialog(null, "请输入商品价格");
			} else if (origin_String.isEmpty()) {
				JOptionPane.showMessageDialog(null, "请输入商品产地");
			} else if (stock_String.isEmpty()) {
				JOptionPane.showMessageDialog(null, "请输入商品库存");
			} else {
				int result = 0;
				double price_double = Double.valueOf(price_String);
				BigDecimal price_decimal = BigDecimal.valueOf(price_double);
				double stock_double = Double.valueOf(stock_String);
				String warehouse_id = ((Item) warehouse.getSelectedItem()).getKey();
				String category_id = ((Item) category.getSelectedItem()).getKey();
				String id = UUID.randomUUID().toString().replaceAll("-", "");
				Object[] params = { id, name_String, price_decimal, origin_String, stock_double, warehouse_id,
						category_id };
				GoodsServiceImpl goodsService = new GoodsServiceImpl();
				try {
					result = goodsService.insertById(params);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				if (result > 0) {
					JOptionPane.showMessageDialog(null, "添加商品成功");
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
