package org.lqz.sale.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.lqz.sale.domain.Sale;
import org.lqz.sale.utils.Page;

public interface SaleService {
	// 查询所有，带条件查询
	public List<Sale> find(String hql, Class<Sale> entityClass, Object[] params);

	// 获取一条记录
	public Sale get(Class<Sale> entityClass, Serializable id);

	// 分页查询，将数据封装到一个page分页工具类对象
	public Page<Sale> findPage(String hql, Page<Sale> page, Class<Sale> entityClass, Object[] params);

	// 新增和修改保存
	public void saveOrUpdate(Sale entity);

	// 批量新增和修改保存
	public void saveOrUpdateAll(Collection<Sale> entitys);

	// 单条删除，按id
	public void deleteById(Class<Sale> entityClass, Serializable id);

	// 批量删除
	public void delete(Class<Sale> entityClass, Serializable[] ids);
	
}
