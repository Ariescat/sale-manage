package org.lqz.sale.domain;

import java.io.Serializable;
import java.util.Set;

/**
 * 销售订单表
 * 
 * @author 12755
 *
 */

public class Sale implements Serializable {

	private Set<SaleGoods> saleGoods; // 销售单对销售货物, 一对多
	private User handler; // 销售单对经手人， 多对一

	private String id;// 订单id
	private Integer delFlag;// 删除标识{1表示已删除，0表示未删除}

	@Override
	public String toString() {
		return "Sale [handler=" + handler + ", id=" + id + ", delFlag=" + delFlag + "]";
	}

	public Set<SaleGoods> getSaleGoods() {
		return saleGoods;
	}

	public void setSaleGoods(Set<SaleGoods> saleGoods) {
		this.saleGoods = saleGoods;
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

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

}
