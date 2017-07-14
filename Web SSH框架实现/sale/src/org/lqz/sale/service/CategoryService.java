package org.lqz.sale.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.lqz.sale.domain.Category;
import org.lqz.sale.utils.Page;

public interface CategoryService {
	// 查询所有，带条件查询
	public List<Category> find(String hql, Class<Category> entityClass, Object[] params);

	// 获取一条记录
	public Category get(Class<Category> entityClass, Serializable id);

	// 分页查询，将数据封装到一个page分页工具类对象
	public Page<Category> findPage(String hql, Page<Category> page, Class<Category> entityClass, Object[] params);

	// 新增和修改保存
	public void saveOrUpdate(Category entity);

	// 批量新增和修改保存
	public void saveOrUpdateAll(Collection<Category> entitys);

	// 单条删除，按id
	public void deleteById(Class<Category> entityClass, Serializable id);

	// 批量删除
	public void delete(Class<Category> entityClass, Serializable[] ids);
}
