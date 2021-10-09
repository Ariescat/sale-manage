package org.ariescat.module.services;

import java.util.List;

import org.ariescat.module.entity.Category;

/**
 * 商品种类接口
 * 
 * @author Administrator
 * 
 */
public interface CategoryService {

	// 列出所有商品种类
	public List<Category> selectAll() throws Exception;

}
