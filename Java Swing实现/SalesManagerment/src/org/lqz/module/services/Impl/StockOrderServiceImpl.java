package org.lqz.module.services.Impl;

import java.util.List;
import java.util.Vector;

import org.lqz.module.dao.Impl.BaseDaoImpl;
import org.lqz.module.services.StockOrderService;

public class StockOrderServiceImpl implements StockOrderService {
	
	//条件查询入库单
	@Override
	public Vector<Vector> selectStockInputByCondition(Object[] paraArray) throws Exception {
		Vector<Vector> rows = new Vector<Vector>();
		BaseDaoImpl dao = new BaseDaoImpl();
		StringBuilder sqlBuilder = new StringBuilder(
				"select s.id,s.bill_no,g.name,s.amount,c.name,w.name,u.name,c.id,w.id "
						+ " from stock_order s,goods g,user u,category c,warehouse w "
						+ " where s.handler_id=u.id and s.goods_id=g.id and s.category_id=c.id and s.warehouse_id=w.id and s.sign='0' and s.del_flag='0' and g.del_flag='0' and c.del_flag=0 and w.del_flag='0' ");
		String name = paraArray[0].toString().trim();
		if (!name.isEmpty()) {
			sqlBuilder.append(" and g.name like '%" + paraArray[0] + "%' ");
		}
		if (!"全部".equals(paraArray[1])) {
			sqlBuilder.append(" and s.category_id='" + paraArray[1] + "' ");
		}
		if (!"全部".equals(paraArray[2])) {
			sqlBuilder.append(" and s.warehouse_id='" + paraArray[2] + "' ");
		}
		if (!"全部".equals(paraArray[3])) {
			sqlBuilder.append(" and s.handler_id='" + paraArray[3] + "' ");
		}
		String sql = sqlBuilder.toString();
		List<Object[]> list = dao.select(sql, 9, null);
		if (!list.isEmpty()) {
			for (Object[] object : list) {
				Vector temp = new Vector<String>();
				for (int i = 0; i < object.length; i++) {
					temp.add(object[i]);
				}
				rows.add(temp);
			}
		}

		return rows;
	}
	
	//通过id逻辑删除入库单
	@Override
	public int deleteStockInputById(Object[] paraArray) throws Exception {
		BaseDaoImpl dao = new BaseDaoImpl();
		int result = 0;
		result = dao.update("update stock_order set del_flag='1' where id=?", paraArray);
		return result;
	}
	
	//通过id修改入库单
	@Override
	public int updateStockInputById(Object[] paraArray) throws Exception {
		BaseDaoImpl dao = new BaseDaoImpl();
		int result = 0;
		result = dao.update("update stock_order set amount=? where id=?", paraArray);
		return result;
	}
	
	//插入入库单
	@Override
	public int insertStockInput(Object[] paraArray) throws Exception {
		BaseDaoImpl dao = new BaseDaoImpl();
		int result = 0;
		result = dao.insert(
				"insert into stock_order(id,bill_no,handler_id,warehouse_id,category_id,amount,goods_id,sign)  values(?,?,?,?,?,?,?,'0')",
				paraArray);
		return result;
	}
	
	//条件查询出库单
	@Override
	public Vector<Vector> selectStockOutputByCondition(Object[] paraArray) throws Exception {
		Vector<Vector> rows = new Vector<Vector>();
		BaseDaoImpl dao = new BaseDaoImpl();
		StringBuilder sqlBuilder = new StringBuilder(
				"select s.id,s.bill_no,g.name,s.amount,c.name,w.name,u.name,c.id,w.id "
						+ " from stock_order s,goods g,user u,category c,warehouse w "
						+ " where s.handler_id=u.id and s.goods_id=g.id and s.category_id=c.id and s.warehouse_id=w.id and s.sign='1' and s.del_flag='0' and g.del_flag='0' and c.del_flag=0 and w.del_flag='0' ");
		String name = paraArray[0].toString().trim();
		if (!name.isEmpty()) {
			sqlBuilder.append(" and g.name like '%" + paraArray[0] + "%' ");
		}
		if (!"全部".equals(paraArray[1])) {
			sqlBuilder.append(" and s.category_id='" + paraArray[1] + "' ");
		}
		if (!"全部".equals(paraArray[2])) {
			sqlBuilder.append(" and s.warehouse_id='" + paraArray[2] + "' ");
		}
		if (!"全部".equals(paraArray[3])) {
			sqlBuilder.append(" and s.handler_id='" + paraArray[3] + "' ");
		}
		String sql = sqlBuilder.toString();
		List<Object[]> list = dao.select(sql, 9, null);
		if (!list.isEmpty()) {
			for (Object[] object : list) {
				Vector temp = new Vector<String>();
				for (int i = 0; i < object.length; i++) {
					temp.add(object[i]);
				}
				rows.add(temp);
			}
		}

		return rows;
	}
	
	//通过id逻辑删除出库单
	@Override
	public int deleteStockOutputById(Object[] paraArray) throws Exception {
		BaseDaoImpl dao = new BaseDaoImpl();
		int result = 0;
		result = dao.update("update stock_order set del_flag='1' where id=?", paraArray);
		return result;
	}
	
	//通过id修改出库单
	@Override
	public int updateStockOutputById(Object[] paraArray) throws Exception {
		BaseDaoImpl dao = new BaseDaoImpl();
		int result = 0;
		result = dao.update("update stock_order set amount=? where id=?", paraArray);
		return result;
	}
	
	//插入出库单
	@Override
	public int insertStockOutput(Object[] paraArray) throws Exception {
		BaseDaoImpl dao = new BaseDaoImpl();
		int result = 0;
		result = dao.insert(
				"insert into stock_order(id,bill_no,handler_id,warehouse_id,category_id,amount,goods_id,sign)  values(?,?,?,?,?,?,?,'1')",
				paraArray);
		return result;
	}

}
