package org.lqz.sale.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.lqz.sale.dao.BaseDao;
import org.lqz.sale.domain.Good;
import org.lqz.sale.service.GoodService;
import org.lqz.sale.utils.Page;

public class GoodServiceImpl implements GoodService {

	private BaseDao baseDao;

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public List<Good> find(String hql, Class<Good> entityClass, Object[] params) {
		return baseDao.find(hql, entityClass, params);
	}

	@Override
	public Good get(Class<Good> entityClass, Serializable id) {
		return baseDao.get(entityClass, id);
	}

	@Override
	public Page<Good> findPage(String hql, Page<Good> page, Class<Good> entityClass, Object[] params) {
		return baseDao.findPage(hql, page, entityClass, params);
	}

	@Override
	public void saveOrUpdate(Good entity) {
		baseDao.saveOrUpdate(entity);
	}

	@Override
	public void saveOrUpdateAll(Collection<Good> entitys) {
		baseDao.saveOrUpdateAll(entitys);
	}

	@Override
	public void deleteById(Class<Good> entityClass, Serializable id) {
		baseDao.deleteById(entityClass, id);// 删除一个对象
	}

	@Override
	public void delete(Class<Good> entityClass, Serializable[] ids) {
		for (Serializable id : ids) {
			this.deleteById(Good.class, id);
		}
	}

}
