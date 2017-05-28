package org.lqz.module.services;

import java.util.List;
import java.util.Vector;

import org.lqz.module.entity.Warehouse;

public interface WarehouseService {

	// 列出所有仓库
	public List<Warehouse> selectAll() throws Exception;

	// 查询所有仓库（返回Vector）
	public Vector<Vector> selectAllVexctor() throws Exception;

	// 根据id修改仓库
	public int updateById(Object[] paramArray) throws Exception;

	// 根据id逻辑删除仓库
	public int deleteById(Object[] paramArray) throws Exception;

	// 添加仓库
	public int insertById(Object[] paramArray) throws Exception;
}
