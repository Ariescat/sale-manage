package org.lqz.sale.domain;

import java.io.Serializable;
import java.util.Set;

/**
 * 出入库订单表
 * 
 * @author 12755
 *
 */
public class Stock implements Serializable {

	private Set<StockGoods> stockGoods; // 出入库与货物 一对多
	private User handler;// 经手人

	private String id;
	private int sign;// 出入库标识{0表示入库，1表示出库}
	private int delFlag;// 删除标识{1表示已删除，0表示未删除}

	public Set<StockGoods> getStockGoods() {
		return stockGoods;
	}

	public void setStockGoods(Set<StockGoods> stockGoods) {
		this.stockGoods = stockGoods;
	}

	public User getHandler() {
		return handler;
	}

	public void setHandler(User handler) {
		this.handler = handler;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getSign() {
		return sign;
	}

	public void setSign(int sign) {
		this.sign = sign;
	}

	public int getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(int delFlag) {
		this.delFlag = delFlag;
	}

}
