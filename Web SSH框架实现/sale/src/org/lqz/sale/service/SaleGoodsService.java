package org.lqz.sale.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.lqz.sale.domain.SaleGoods;
import org.lqz.sale.utils.Page;

public interface SaleGoodsService {
	// 查询所有，带条件查询
	public List<SaleGoods> find(String hql, Class<SaleGoods> entityClass, Object[] params);

	// 获取一条记录
	public SaleGoods get(Class<SaleGoods> entityClass, Serializable id);

	// 分页查询，将数据封装到一个page分页工具类对象
	public Page<SaleGoods> findPage(String hql, Page<SaleGoods> page, Class<SaleGoods> entityClass, Object[] params);

	// 新增和修改保存
	public void saveOrUpdate(SaleGoods entity);

	// 批量新增和修改保存
	public void saveOrUpdateAll(Collection<SaleGoods> entitys);

	// 单条删除，按id
	public void deleteById(Class<SaleGoods> entityClass, Serializable id);

	// 批量删除
	public void delete(Class<SaleGoods> entityClass, Serializable[] ids);
	
}
