package org.lqz.sale.web;


import java.util.List;

import org.lqz.sale.domain.Role;
import org.lqz.sale.domain.User;
import org.lqz.sale.service.RoleService;
import org.lqz.sale.service.UserService;
import org.lqz.sale.utils.Page;

import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends BaseAction implements ModelDriven<User> {

	private static final long serialVersionUID = -628649677616338668L;
	private User model = new User();

	@Override
	public User getModel() {
		return model;
	}

	// 分页查询
	private Page<User> page = new Page<User>();
	public Page<User> getPage() {
		return page;
	}
	public void setPage(Page<User> page) {
		this.page = page;
	}

	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	private RoleService roleService;
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	/**
	 * 分页查询
	 */
	public String list() throws Exception {
		String hql = "from User";

		userService.findPage(hql, page, User.class, null);

		// 设置分页的url地址
		page.setUrl("UserAction_list");

		// 将page对象压入栈顶
		super.push(page);
		return "list";
	}

	/**
	 * 查看
	 */
	public String toview() throws Exception {
		// 1.调用业务方法，根据id,得到对象
		User user = userService.get(User.class, model.getId());

		// 放入栈顶
		super.push(user);

		// 3.跳页面
		return "toview";
	}

	/**
	 * 进入新增页面
	 */
	public String tocreate() throws Exception {
		List<Role> roles = roleService.find("from Role", Role.class, null);
		
		super.put("roles", roles);
		
		return "tocreate";
	}

	/**
	 * 保存
	 */
	public String insert() throws Exception {
		userService.saveOrUpdate(model);
		return "alist";
	}

	/**
	 * 进入修改页面
	 */
	public String toupdate() throws Exception {
		// 1.调用业务方法，根据id,得到对象
		User user = userService.get(User.class, model.getId());
		super.push(user);
		
		List<Role> roles = roleService.find("from Role", Role.class, null);
		super.put("roles", roles);
				
		return "toupdate";
	}

	/**
	 * 修改
	 */
	public String update() throws Exception {
		
		// 1.调用业务方法，根据id,得到对象
		User user = userService.get(User.class, model.getId());
		
		user.setName(model.getName());
		user.setPassword(model.getPassword());
		user.setRole(model.getRole());
		
		userService.saveOrUpdate(user);
				
		return "alist";
	}

	/**
	 * 删除
	 */
	public String delete() throws Exception {
		String ids[] = model.getId().split(", ");
		
		//调用业务方法，实现批量删除
		userService.delete(User.class, ids);
		
		return "alist";
	}
}
