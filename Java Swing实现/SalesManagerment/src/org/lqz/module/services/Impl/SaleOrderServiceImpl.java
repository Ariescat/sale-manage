package org.lqz.module.services.Impl;

import java.util.List;
import java.util.Vector;

import org.lqz.module.dao.Impl.BaseDaoImpl;
import org.lqz.module.services.SaleOrderService;

public class SaleOrderServiceImpl implements SaleOrderService {
	
	//条件查询销售单
	@Override
	public Vector<Vector> selectByCondition(Object[] paraArray) throws Exception {
		Vector<Vector> rows = new Vector<Vector>();
		BaseDaoImpl dao = new BaseDaoImpl();
		StringBuilder sqlBuilder = new StringBuilder(
				"select s.id,s.bill_no,g.name,s.amount,c.name,w.name,u.name,c.id,w.id "
						+ " from sale_order s,user u,goods g,category c,warehouse w "
						+ " where s.handler_id=u.id and s.category_id=c.id and s.warehouse_id=w.id and s.goods_id=g.id and s.del_flag='0' and g.del_flag='0' and c.del_flag='0' and w.del_flag='0'");
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
	
	//插入销售单
	@Override
	public int insert(Object[] paraArray) throws Exception {
		BaseDaoImpl dao = new BaseDaoImpl();
		int result = 0;
		result = dao.insert(
				"insert into sale_order(id,bill_no,handler_id,category_id,warehouse_id,amount,goods_id)  values(?,?,?,?,?,?,?)",
				paraArray);
		return result;
	}

}
