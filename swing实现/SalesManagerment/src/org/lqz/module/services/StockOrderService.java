package org.lqz.module.services;

import java.util.Vector;

public interface StockOrderService {

	// 根据条件查询入库单
	public Vector<Vector> selectStockInputByCondition(Object[] paraArray) throws Exception;

	// 根据id逻辑删除入库单
	public int deleteStockInputById(Object[] paraArray) throws Exception;

	// 根据id更新入库单
	public int updateStockInputById(Object[] paraArray) throws Exception;

	// 添加入库单
	public int insertStockInput(Object[] paraArray) throws Exception;

	// 根据条件查询出库单
	public Vector<Vector> selectStockOutputByCondition(Object[] paraArray) throws Exception;

	// 根据id逻辑删除出库单
	public int deleteStockOutputById(Object[] paraArray) throws Exception;

	// 根据id更新出库单
	public int updateStockOutputById(Object[] paraArray) throws Exception;

	// 添加出库单
	public int insertStockOutput(Object[] paraArray) throws Exception;
}
