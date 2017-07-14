package org.lqz.module.dao;

import java.sql.SQLException;
import java.util.List;


/**
 * 说明：基础Dao数据库操作接口
 * 
 * @author Administrator
 * 
 */
public interface BaseDao {

	public List select(String sql, int columnNum, Object[] paraArray)
			throws SQLException;

	public int insert(String sql, Object[] paraArray) throws SQLException;

	public int update(String sql, Object[] paraArray) throws SQLException;

	public int delete(String sql, Object[] paraArray) throws SQLException;

}
