package org.lqz.sale.domain;

import java.io.Serializable;

/**
 * 出入库商品表
 * 
 * @author 12755
 *
 */
public class StockGoods implements Serializable {

	private Stock stock;// 多对一
	private Good good; // 一对一

	private String id;
	private String goodName; // 商品名
	private int amount; // 商品数量

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
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
