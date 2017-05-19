package org.lqz.sale.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.lqz.sale.domain.StockGoods;
import org.lqz.sale.utils.Page;

public interface StockGoodsService {
	// 查询所有，带条件查询
	public List<StockGoods> find(String hql, Class<StockGoods> entityClass, Object[] params);

	// 获取一条记录
	public StockGoods get(Class<StockGoods> entityClass, Serializable id);

	// 分页查询，将数据封装到一个page分页工具类对象
	public Page<StockGoods> findPage(String hql, Page<StockGoods> page, Class<StockGoods> entityClass, Object[] params);

	// 新增和修改保存
	public void saveOrUpdate(StockGoods entity);

	// 批量新增和修改保存
	public void saveOrUpdateAll(Collection<StockGoods> entitys);

	// 单条删除，按id
	public void deleteById(Class<StockGoods> entityClass, Serializable id);

	// 批量删除
	public void delete(Class<StockGoods> entityClass, Serializable[] ids);
	
}
