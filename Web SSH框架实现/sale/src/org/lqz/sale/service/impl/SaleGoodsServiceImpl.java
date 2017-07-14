package org.lqz.sale.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.lqz.sale.dao.BaseDao;
import org.lqz.sale.domain.SaleGoods;
import org.lqz.sale.service.SaleGoodsService;
import org.lqz.sale.utils.Page;

public class SaleGoodsServiceImpl implements SaleGoodsService {

	private BaseDao baseDao;

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public List<SaleGoods> find(String hql, Class<SaleGoods> entityClass, Object[] params) {
		return baseDao.find(hql, entityClass, params);
	}

	@Override
	public SaleGoods get(Class<SaleGoods> entityClass, Serializable id) {
		return baseDao.get(entityClass, id);
	}

	@Override
	public Page<SaleGoods> findPage(String hql, Page<SaleGoods> page, Class<SaleGoods> entityClass, Object[] params) {
		return baseDao.findPage(hql, page, entityClass, params);
	}

	@Override
	public void saveOrUpdate(SaleGoods entity) {
		baseDao.saveOrUpdate(entity);
	}

	@Override
	public void saveOrUpdateAll(Collection<SaleGoods> entitys) {
		baseDao.saveOrUpdateAll(entitys);
	}

	@Override
	public void deleteById(Class<SaleGoods> entityClass, Serializable id) {
		baseDao.deleteById(entityClass, id);// 删除一个对象
	}

	@Override
	public void delete(Class<SaleGoods> entityClass, Serializable[] ids) {
		for (Serializable id : ids) {
			this.deleteById(SaleGoods.class, id);
		}
	}

}
