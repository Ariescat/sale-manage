package org.lqz.sale.domain;

import java.io.Serializable;
import java.util.Set;

/**
 * 用户
 * 
 * @author 12755
 *
 */
public class Role implements Serializable {

	private Set<User> users;// 角色与用户 一对多

	private String id;
	private String name;

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + "]";
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
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

}
