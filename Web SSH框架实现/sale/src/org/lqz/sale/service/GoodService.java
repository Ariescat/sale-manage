package org.lqz.sale.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.lqz.sale.domain.Good;
import org.lqz.sale.utils.Page;

public interface GoodService {
	// 查询所有，带条件查询
	public List<Good> find(String hql, Class<Good> entityClass, Object[] params);

	// 获取一条记录
	public Good get(Class<Good> entityClass, Serializable id);

	// 分页查询，将数据封装到一个page分页工具类对象
	public Page<Good> findPage(String hql, Page<Good> page, Class<Good> entityClass, Object[] params);

	// 新增和修改保存
	public void saveOrUpdate(Good entity);

	// 批量新增和修改保存
	public void saveOrUpdateAll(Collection<Good> entitys);

	// 单条删除，按id
	public void deleteById(Class<Good> entityClass, Serializable id);

	// 批量删除
	public void delete(Class<Good> entityClass, Serializable[] ids);
}
