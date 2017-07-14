package org.lqz.framework.util;

/**
 * 说明:其他工具类
 */
import java.awt.*;
import java.util.Enumeration;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

public class Tools {

	// 设置Table样式
	@SuppressWarnings("static-access")
	public static void setTableStyle(JTable jtb) {

		// 设置选中项背景
		jtb.setSelectionBackground(new Color(51, 153, 255));
		// 设置行高
		jtb.setRowHeight(40);
		// 设置表格可排序
		jtb.setAutoCreateRowSorter(true);
		// 设置表格表头内容居中
		DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) jtb
				.getTableHeader().getDefaultRenderer();
		renderer.setHorizontalAlignment(renderer.CENTER);
		// 设置表格单元格内容居中
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		jtb.setDefaultRenderer(Object.class, r);

		jtb.setFont(MyFont.Static);
		fitTableColumns(jtb);
	}

	// 兼容设置Table布局
	@SuppressWarnings("rawtypes")
	private static void fitTableColumns(JTable myTable) {
		myTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		JTableHeader header = myTable.getTableHeader();
		int rowCount = myTable.getRowCount();
		Enumeration columns = myTable.getColumnModel().getColumns();
		while (columns.hasMoreElements()) {
			TableColumn column = (TableColumn) columns.nextElement();
			int col = header.getColumnModel().getColumnIndex(
					column.getIdentifier());
			int width = (int) header
					.getDefaultRenderer()
					.getTableCellRendererComponent(myTable,
							column.getIdentifier(), false, false, -1, col)
					.getPreferredSize().getWidth();
			for (int row = 0; row < rowCount; row++) {
				int preferedWidth = (int) myTable
						.getCellRenderer(row, col)
						.getTableCellRendererComponent(myTable,
								myTable.getValueAt(row, col), false, false,
								row, col).getPreferredSize().getWidth();
				width = Math.max(width, preferedWidth);
			}
			// 设置列宽与内容相适应
			header.setResizingColumn(column);
			column.setWidth(width + myTable.getIntercellSpacing().width);
		}
	}

	// 设置JScrollPane样式
	public static void setJspStyle(JScrollPane jsp) {

		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.getViewport().setOpaque(false);
		jsp.getVerticalScrollBar().setOpaque(false);
	}

}
