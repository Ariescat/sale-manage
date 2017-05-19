package org.lqz.sale.domain;

import java.io.Serializable;

/**
 * 商品表
 * 
 * @author 12755
 *
 */
public class Good implements Serializable {

	private Category category; // 商品与分类 多对一
	private Warehouse warehouse;// 商品与仓库 多对一

	private String id;
	private String name;// 商品名
	private double price;// 价格
	private String origin;// 产地
	private int stock;// 库存
	private int delFlag;// 删除标识{1表示已删除，0表示未删除}

	@Override
	public String toString() {
		return "Good [id=" + id + ", name=" + name + ", price=" + price + ", origin=" + origin + ", stock=" + stock
				+ ", delFlag=" + delFlag + "]";
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(int delFlag) {
		this.delFlag = delFlag;
	}

}
