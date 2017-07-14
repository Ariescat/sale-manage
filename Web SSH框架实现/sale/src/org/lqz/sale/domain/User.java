package org.lqz.sale.domain;

import java.io.Serializable;
import java.util.Set;

/**
 * 用户
 * 
 * @author 12755
 *
 */
public class User implements Serializable {

	private Set<Stock> stocks; // 用户与出入库 一对多
	private Set<Sale> sales;// 用户与销售 一对多

	private Role role;

	private String id;
	private String name;
	private String password;

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + "]";
	}

	public Set<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(Set<Stock> stocks) {
		this.stocks = stocks;
	}

	public Set<Sale> getSales() {
		return sales;
	}

	public void setSales(Set<Sale> sales) {
		this.sales = sales;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
