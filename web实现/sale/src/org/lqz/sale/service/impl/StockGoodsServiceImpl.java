package org.lqz.sale.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.lqz.sale.dao.BaseDao;
import org.lqz.sale.domain.StockGoods;
import org.lqz.sale.service.StockGoodsService;
import org.lqz.sale.utils.Page;

public class StockGoodsServiceImpl implements StockGoodsService {

	private BaseDao baseDao;

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public List<StockGoods> find(String hql, Class<StockGoods> entityClass, Object[] params) {
		return baseDao.find(hql, entityClass, params);
	}

	@Override
	public StockGoods get(Class<StockGoods> entityClass, Serializable id) {
		return baseDao.get(entityClass, id);
	}

	@Override
	public Page<StockGoods> findPage(String hql, Page<StockGoods> page, Class<StockGoods> entityClass, Object[] params) {
		return baseDao.findPage(hql, page, entityClass, params);
	}

	@Override
	public void saveOrUpdate(StockGoods entity) {
		baseDao.saveOrUpdate(entity);
	}

	@Override
	public void saveOrUpdateAll(Collection<StockGoods> entitys) {
		baseDao.saveOrUpdateAll(entitys);
	}

	@Override
	public void deleteById(Class<StockGoods> entityClass, Serializable id) {
		baseDao.deleteById(entityClass, id);// 删除一个对象
	}

	@Override
	public void delete(Class<StockGoods> entityClass, Serializable[] ids) {
		for (Serializable id : ids) {
			this.deleteById(StockGoods.class, id);
		}
	}

}
