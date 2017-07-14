package org.lqz.module.services;

import java.util.List;
import java.util.Vector;

public interface GoodsService {

	// 根据条件查询商品
	public Vector<Vector> selectByCondition(Object[] paraArray) throws Exception;

	// 根据id逻辑删除商品
	public int deleteById(Object[] paraArray) throws Exception;

	// 根据id更新商品
	public int updateById(Object[] paraArray) throws Exception;

	// 根据id新添商品
	public int insertById(Object[] paraArray) throws Exception;

	// 查询所有商品
	public List selectAll() throws Exception;

	// 根据id查询商品
	public List selectById(Object[] paraArray) throws Exception;

	// 根据id修改库存
	public int updateStockById(Object[] paraArray) throws Exception;
}
