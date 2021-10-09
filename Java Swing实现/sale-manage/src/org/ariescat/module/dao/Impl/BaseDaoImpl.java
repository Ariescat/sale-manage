package org.ariescat.module.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.ariescat.framework.util.JdbcUtil;
import org.ariescat.module.dao.BaseDao;

/**
 * 说明：基础Dao数据库操作实现
 * 
 * @author Administrator
 * 
 */
public class BaseDaoImpl implements BaseDao {

	private static Logger logger = Logger.getLogger(BaseDaoImpl.class);
	private JdbcUtil jdbcUtil;
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;

	// 构造方法获取数据库连接
	public BaseDaoImpl() {
		jdbcUtil = new JdbcUtil();
		conn = jdbcUtil.getJdbcUtil().getConnection();
	}

	// 重写查询数据方法
	@Override
	public List select(String sql, int columnNum, Object[] paraArray)
			throws SQLException {
		List list = new ArrayList();
		pst = conn.prepareStatement(sql);
		if (paraArray != null) {
			for (int i = 0, length = paraArray.length; i < length; i++) {
				pst.setObject(i + 1, paraArray[i]);
			}
		}
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			Object[] array = new Object[columnNum];
			for (int i = 0; i < columnNum; i++) {
				array[i] = rs.getObject(i + 1);
			}
			list.add(array);
		}
		jdbcUtil.getJdbcUtil().release(rs, pst, conn);
		return list;
	}

	// 重写插入数据方法
	@Override
	public int insert(String sql, Object[] paraArray) throws SQLException {
		pst = conn.prepareStatement(sql);
		for (int i = 0, length = paraArray.length; i < length; i++) {
			pst.setObject(i + 1, paraArray[i]);
		}
		// 指示受影响的行数（即更新计数）
		int i = pst.executeUpdate();
		jdbcUtil.getJdbcUtil().release(rs, pst, conn);
		return i;
	}

	// 重写更新数据方法
	@Override
	public int update(String sql, Object[] paraArray) throws SQLException {
		pst = conn.prepareStatement(sql);
		for (int i = 0, length = paraArray.length; i < length; i++) {
			pst.setObject(i + 1, paraArray[i]);
		}
		int i = pst.executeUpdate();
		jdbcUtil.getJdbcUtil().release(rs, pst, conn);
		return i;
	}

	// 重写删除数据方法
	@Override
	public int delete(String sql, Object[] paraArray) throws SQLException {
		pst = conn.prepareStatement(sql);
		for (int i = 0, length = paraArray.length; i < length; i++) {
			pst.setObject(i + 1, paraArray[i]);
		}
		int i = pst.executeUpdate();
		jdbcUtil.getJdbcUtil().release(rs, pst, conn);
		return i;
	}

}
