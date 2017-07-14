package org.lqz.sale.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.lqz.sale.domain.Stock;
import org.lqz.sale.utils.Page;

public interface StockService {
	// 查询所有，带条件查询
	public List<Stock> find(String hql, Class<Stock> entityClass, Object[] params);

	// 获取一条记录
	public Stock get(Class<Stock> entityClass, Serializable id);

	// 分页查询，将数据封装到一个page分页工具类对象
	public Page<Stock> findPage(String hql, Page<Stock> page, Class<Stock> entityClass, Object[] params);

	// 新增和修改保存
	public void saveOrUpdate(Stock entity);

	// 批量新增和修改保存
	public void saveOrUpdateAll(Collection<Stock> entitys);

	// 单条删除，按id
	public void deleteById(Class<Stock> entityClass, Serializable id);

	// 批量删除
	public void delete(Class<Stock> entityClass, Serializable[] ids);
}
