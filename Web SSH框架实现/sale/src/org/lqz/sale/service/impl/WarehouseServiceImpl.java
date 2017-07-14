package org.lqz.sale.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.lqz.sale.dao.BaseDao;
import org.lqz.sale.domain.Warehouse;
import org.lqz.sale.service.WarehouseService;
import org.lqz.sale.utils.Page;

public class WarehouseServiceImpl implements WarehouseService {

	private BaseDao baseDao;

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public List<Warehouse> find(String hql, Class<Warehouse> entityClass, Object[] params) {
		return baseDao.find(hql, entityClass, params);
	}

	@Override
	public Warehouse get(Class<Warehouse> entityClass, Serializable id) {
		return baseDao.get(entityClass, id);
	}

	@Override
	public Page<Warehouse> findPage(String hql, Page<Warehouse> page, Class<Warehouse> entityClass, Object[] params) {
		return baseDao.findPage(hql, page, entityClass, params);
	}

	@Override
	public void saveOrUpdate(Warehouse entity) {
		baseDao.saveOrUpdate(entity);
	}

	@Override
	public void saveOrUpdateAll(Collection<Warehouse> entitys) {
		baseDao.saveOrUpdateAll(entitys);
	}

	@Override
	public void deleteById(Class<Warehouse> entityClass, Serializable id) {
		baseDao.deleteById(entityClass, id);// 删除一个对象
	}

	@Override
	public void delete(Class<Warehouse> entityClass, Serializable[] ids) {
		for (Serializable id : ids) {
			this.deleteById(Warehouse.class, id);
		}
	}

}
