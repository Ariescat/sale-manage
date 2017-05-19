package org.lqz.sale.domain;

import java.io.Serializable;

public class SaleGoods implements Serializable {
	private Sale sale;// 多对一
	private Good good; // 一对一

	private String id;
	private String goodName; // 商品名
	private int amount; // 商品数量

	@Override
	public String toString() {
		return "SaleGoods [id=" + id + ", goodName=" + goodName + ", amount=" + amount + "]";
	}

	public Sale getSale() {
		return sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}

	public Good getGood() {
		return good;
	}

	public void setGood(Good good) {
		this.good = good;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGoodName() {
		return goodName;
	}

	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}
