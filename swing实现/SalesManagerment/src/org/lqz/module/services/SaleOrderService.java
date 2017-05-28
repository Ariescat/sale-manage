package org.lqz.module.services;

import java.util.Vector;

public interface SaleOrderService {

	// 根据条件查询销售单
	public Vector<Vector> selectByCondition(Object[] paraArray) throws Exception;

	// 添加销售单
	public int insert(Object[] paraArray) throws Exception;

}
