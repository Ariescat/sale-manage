package org.lqz.framework.util;

/**
 * 说明:自定义下拉菜单元素的工具类
 * 
 * @author Administrator
 * 
 */
public class Item {
	private String key;

	private String value;

	public Item(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public String toString() {
		return value;
	}
}
