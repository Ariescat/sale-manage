package org.lqz.sale.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.lqz.sale.dao.BaseDao;
import org.lqz.sale.domain.Category;
import org.lqz.sale.service.CategoryService;
import org.lqz.sale.utils.Page;

public class CategoryServiceImpl implements CategoryService {

	private BaseDao baseDao;

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public List<Category> find(String hql, Class<Category> entityClass, Object[] params) {
		return baseDao.find(hql, entityClass, params);
	}

	@Override
	public Category get(Class<Category> entityClass, Serializable id) {
		return baseDao.get(entityClass, id);
	}

	@Override
	public Page<Category> findPage(String hql, Page<Category> page, Class<Category> entityClass, Object[] params) {
		return baseDao.findPage(hql, page, entityClass, params);
	}

	@Override
	public void saveOrUpdate(Category entity) {
		baseDao.saveOrUpdate(entity);
	}

	@Override
	public void saveOrUpdateAll(Collection<Category> entitys) {
		baseDao.saveOrUpdateAll(entitys);
	}

	@Override
	public void deleteById(Class<Category> entityClass, Serializable id) {
		baseDao.deleteById(entityClass, id);// 删除一个对象
	}

	@Override
	public void delete(Class<Category> entityClass, Serializable[] ids) {
		for (Serializable id : ids) {
			this.deleteById(Category.class, id);
		}
	}

}
