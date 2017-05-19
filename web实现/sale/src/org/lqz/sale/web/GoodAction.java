package org.lqz.sale.web;

import java.util.List;

import org.lqz.sale.domain.Category;
import org.lqz.sale.domain.Good;
import org.lqz.sale.domain.Warehouse;
import org.lqz.sale.service.CategoryService;
import org.lqz.sale.service.GoodService;
import org.lqz.sale.service.WarehouseService;
import org.lqz.sale.utils.Page;

import com.opensymphony.xwork2.ModelDriven;

public class GoodAction extends BaseAction implements ModelDriven<Good> {

	private static final long serialVersionUID = 1202675939258668831L;
	private Good model = new Good();

	@Override
	public Good getModel() {
		return model;
	}

	// 分页查询
	private Page<Good> page = new Page<Good>();
	public Page<Good> getPage() {
		return page;
	}
	public void setPage(Page<Good> page) {
		this.page = page;
	}

	private GoodService goodService;
	public void setGoodService(GoodService goodService) {
		this.goodService = goodService;
	}
	private CategoryService categoryService;
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	private WarehouseService warehouseService;
	public void setWarehouseService(WarehouseService warehouseService) {
		this.warehouseService = warehouseService;
	}

	/**
	 * 分页查询
	 */
	public String list() throws Exception {
		
		String hql = "from Good where delFlag = 0";

		goodService.findPage(hql, page, Good.class, null);

		// 设置分页的url地址
		page.setUrl("goodAction_list");

		// 将page对象压入栈顶
		super.push(page);
		
		return "list";
	}

	/**
	 * 查看
	 */
	public String toview() throws Exception {
		// 1.调用业务方法，根据id,得到对象
		Good good = goodService.get(Good.class, model.getId());

		// 放入栈顶
		super.push(good);

		// 3.跳页面
		return "toview";
	}

	/**
	 * 进入新增页面
	 */
	public String tocreate() throws Exception {
		// 查询分类
		List<Category> cates = categoryService.find("from Category where delFlag = 0", Category.class, null);
		
		// 查询仓库
		List<Warehouse> wares = warehouseService.find("from Warehouse where delFlag = 0", Warehouse.class, null);
		
		super.put("categorys", cates);
		
		super.put("warehouses", wares);
		
		return "tocreate";
	}

	/**
	 * 保存
	 */
	public String insert() throws Exception {
		goodService.saveOrUpdate(model);
		return "alist";
	}

	/**
	 * 进入修改页面
	 */
	public String toupdate() throws Exception {
		Good good = goodService.get(Good.class, model.getId());
		super.push(good);
		
		// 查询分类
		List<Category> cates = categoryService.find("from Category where delFlag = 0", Category.class, null);
		// 查询仓库
		List<Warehouse> wares = warehouseService.find("from Warehouse where delFlag = 0", Warehouse.class, null);
		super.put("categorys", cates);
		super.put("warehouses", wares);
		
		return "toupdate";
	}

	/**
	 * 修改
	 */
	public String update() throws Exception {
		Good good = goodService.get(Good.class, model.getId());
		
		good.setName(model.getName());
		good.setOrigin(model.getOrigin());
		good.setPrice(model.getPrice());
		good.setStock(model.getStock());
		good.setCategory(model.getCategory());
		good.setWarehouse(model.getWarehouse());
		
		goodService.saveOrUpdate(good);
		return "alist";
	}

	/**
	 * 删除
	 */
	public String delete() throws Exception {
		String ids[] = model.getId().split(", ");
		
		//调用业务方法，实现批量删除
		goodService.delete(Good.class, ids);
				
		return "alist";
	}
}
