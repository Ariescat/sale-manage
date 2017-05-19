package org.lqz.sale.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.lqz.sale.dao.BaseDao;
import org.lqz.sale.domain.Role;
import org.lqz.sale.service.RoleService;
import org.lqz.sale.utils.Page;

public class RoleServiceImpl implements RoleService {

	private BaseDao baseDao;

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public List<Role> find(String hql, Class<Role> entityClass, Object[] params) {
		return baseDao.find(hql, entityClass, params);
	}

	@Override
	public Role get(Class<Role> entityClass, Serializable id) {
		return baseDao.get(entityClass, id);
	}

	@Override
	public Page<Role> findPage(String hql, Page<Role> page, Class<Role> entityClass, Object[] params) {
		return baseDao.findPage(hql, page, entityClass, params);
	}

	@Override
	public void saveOrUpdate(Role entity) {
		baseDao.saveOrUpdate(entity);
	}

	@Override
	public void saveOrUpdateAll(Collection<Role> entitys) {
		baseDao.saveOrUpdateAll(entitys);
	}

	@Override
	public void deleteById(Class<Role> entityClass, Serializable id) {
		baseDao.deleteById(entityClass, id);// 删除一个对象
	}

	@Override
	public void delete(Class<Role> entityClass, Serializable[] ids) {
		for (Serializable id : ids) {
			this.deleteById(Role.class, id);
		}
	}

}
