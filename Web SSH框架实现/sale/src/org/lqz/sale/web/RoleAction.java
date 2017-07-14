package org.lqz.sale.web;

import java.util.List;

import org.lqz.sale.domain.Role;
import org.lqz.sale.service.RoleService;
import org.lqz.sale.utils.Page;

import com.opensymphony.xwork2.ModelDriven;

public class RoleAction extends BaseAction implements ModelDriven<Role> {

	private static final long serialVersionUID = -628649677616338668L;
	private Role model = new Role();

	@Override
	public Role getModel() {
		return model;
	}

	// 分页查询
	private Page<Role> page = new Page<Role>();
	public Page<Role> getPage() {
		return page;
	}
	public void setPage(Page<Role> page) {
		this.page = page;
	}

	private RoleService roleService;
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	
	/**
	 * 分页查询
	 */
	public String list() throws Exception {
		String hql = "from Role";

		roleService.findPage(hql, page, Role.class, null);

		// 设置分页的url地址
		page.setUrl("roleAction_list");

		// 将page对象压入栈顶
		super.push(page);
		return "list";
	}

	/**
	 * 查看
	 */
	public String toview() throws Exception {
		// 1.调用业务方法，根据id,得到对象
		Role role = roleService.get(Role.class, model.getId());

		// 放入栈顶
		super.push(role);

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
		roleService.saveOrUpdate(model);
		return "alist";
	}

	/**
	 * 进入修改页面
	 */
	public String toupdate() throws Exception {
		// 1.调用业务方法，根据id,得到对象
		Role Role = roleService.get(Role.class, model.getId());
		super.push(Role);
		
		List<Role> roles = roleService.find("from Role", Role.class, null);
		super.put("roles", roles);
				
		return "toupdate";
	}

	/**
	 * 修改
	 */
	public String update() throws Exception {
		
		// 1.调用业务方法，根据id,得到对象
		Role Role = roleService.get(Role.class, model.getId());
		
//		Role.setName(model.getName());
//		Role.setPassword(model.getPassword());
//		Role.setRole(model.getRole());
		
		roleService.saveOrUpdate(Role);
				
		return "alist";
	}

	/**
	 * 删除
	 */
	public String delete() throws Exception {
		String ids[] = model.getId().split(", ");
		
		//调用业务方法，实现批量删除
		roleService.delete(Role.class, ids);
		
		return "alist";
	}
}
