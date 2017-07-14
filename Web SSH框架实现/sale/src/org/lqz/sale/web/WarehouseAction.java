package org.lqz.sale.web;

import org.lqz.sale.domain.Warehouse;
import org.lqz.sale.service.WarehouseService;
import org.lqz.sale.utils.Page;

import com.opensymphony.xwork2.ModelDriven;

public class WarehouseAction extends BaseAction implements ModelDriven<Warehouse> {

	private static final long serialVersionUID = -353407057619292323L;
	private Warehouse model = new Warehouse();

	@Override
	public Warehouse getModel() {
		return model;
	}

	// 分页查询
	private Page<Warehouse> page = new Page<Warehouse>();
	public Page<Warehouse> getPage() {
		return page;
	}
	public void setPage(Page<Warehouse> page) {
		this.page = page;
	}

	private WarehouseService warehouseService;
	public void setWarehouseService(WarehouseService warehouseService) {
		this.warehouseService = warehouseService;
	}

	/**
	 * 分页查询
	 */
	public String list() throws Exception {
		String hql = "from Warehouse where delFlag = 0";

		warehouseService.findPage(hql, page, Warehouse.class, null);

		// 设置分页的url地址
		page.setUrl("warehouseAction_list");

		// 将page对象压入栈顶
		super.push(page);
		return "list";
	}

	/**
	 * 查看
	 */
	public String toview() throws Exception {
		// 1.调用业务方法，根据id,得到对象
		Warehouse dept = warehouseService.get(Warehouse.class, model.getId());

		// 放入栈顶
		super.push(dept);

		// 3.跳页面
		return "toview";
	}

	/**
	 * 进入新增页面
	 */
	public String tocreate() throws Exception {
		return "tocreate";
	}

	/**
	 * 保存
	 */
	public String insert() throws Exception {
		model.setDelFlag(0);
		warehouseService.saveOrUpdate(model);
		return "alist";
	}

	/**
	 * 进入修改页面
	 */
	public String toupdate() throws Exception {
		Warehouse warehouse = warehouseService.get(Warehouse.class, model.getId());
		super.push(warehouse);
		return "toupdate";
	}

	/**
	 * 修改
	 */
	public String update() throws Exception {
		Warehouse warehouse = warehouseService.get(Warehouse.class, model.getId());
		warehouse.setName(model.getName());
		warehouseService.saveOrUpdate(warehouse);
		return "alist";
	}

	/**
	 * 删除
	 */
	public String delete() throws Exception {
		String ids[] = model.getId().split(", ");
		
		//调用业务方法，实现批量删除
		warehouseService.delete(Warehouse.class, ids);
		return "alist";
	}
}
