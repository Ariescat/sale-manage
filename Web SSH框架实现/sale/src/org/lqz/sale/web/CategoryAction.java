package org.lqz.sale.web;

import org.lqz.sale.domain.Category;
import org.lqz.sale.service.CategoryService;
import org.lqz.sale.utils.Page;

import com.opensymphony.xwork2.ModelDriven;

public class CategoryAction extends BaseAction implements ModelDriven<Category> {

	private static final long serialVersionUID = 488205036302802836L;
	private Category model = new Category();

	@Override
	public Category getModel() {
		return model;
	}

	// 分页查询
	private Page<Category> page = new Page<Category>();
	public Page<Category> getPage() {
		return page;
	}
	public void setPage(Page<Category> page) {
		this.page = page;
	}

	private CategoryService categoryService;
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	/**
	 * 分页查询
	 */
	public String list() throws Exception {
		String hql = "from Category";

		categoryService.findPage(hql, page, Category.class, null);

		// 设置分页的url地址
		page.setUrl("categoryAction_list");

		// 将page对象压入栈顶
		super.push(page);
		return "list";
	}

	/**
	 * 查看
	 */
	public String toview() throws Exception {
		// 1.调用业务方法，根据id,得到对象
		Category dept = categoryService.get(Category.class, model.getId());

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
		categoryService.saveOrUpdate(model);
		return "alist";
	}

	/**
	 * 进入修改页面
	 */
	public String toupdate() throws Exception {
		Category category = categoryService.get(Category.class, model.getId());
		super.push(category);
		return "toupdate";
	}

	/**
	 * 修改
	 */
	public String update() throws Exception {
		Category category = categoryService.get(Category.class, model.getId());
		category.setName(model.getName());
		categoryService.saveOrUpdate(category);
		return "alist";
	}

	/**
	 * 删除
	 */
	public String delete() throws Exception {
		String ids[] = model.getId().split(", ");
		
		//调用业务方法，实现批量删除
		categoryService.delete(Category.class, ids);
		return "alist";
	}
}
