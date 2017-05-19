package org.lqz.sale.domain;

import java.io.Serializable;
import java.util.Set;

/**
 * 分类
 * 
 * @author 12755
 *
 */
public class Category implements Serializable {

	private Set<Good> goods; // 分类对商品 一对多

	private String id;
	private String name;// 分类名
	private int delFlag;// 删除标识{1表示已删除，0表示未删除}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", delFlag=" + delFlag + "]";
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

	public int getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(int delFlag) {
		this.delFlag = delFlag;
	}

	public Set<Good> getGoods() {
		return goods;
	}

	public void setGoods(Set<Good> goods) {
		this.goods = goods;
	}

}
