package org.lqz.module.services.Impl;

import java.util.List;
import java.util.Vector;

import org.lqz.module.dao.Impl.BaseDaoImpl;
import org.lqz.module.services.GoodsService;

public class GoodsServiceImpl implements GoodsService {
	
	//条件查询商品
	@Override
	public Vector<Vector> selectByCondition(Object[] paraArray) throws Exception {
		Vector<Vector> rows = new Vector<Vector>();
		BaseDaoImpl dao = new BaseDaoImpl();
		StringBuilder sqlBuilder = new StringBuilder(
				"select g.id,g.name,g.price,g.origin,c.name as categoryName,w.name as warehouseName, g.stock,w.id as warehouseId,c.id as categoryId "
						+ "from goods g,warehouse w,category c "
						+ "where 1=1 and g.del_flag='0' and w.del_flag='0' and c.del_flag='0' and g.warehouse_id=w.id and g.category_id=c.id ");
//		System.out.println("paraArray[0] = " + paraArray[0] + ", paraArray[1] = " + paraArray[0]);
		if (!"全部".equals(paraArray[0])) {
			sqlBuilder.append(" and g.category_id='" + paraArray[0] + "'");
		}
		if (!"全部".equals(paraArray[1])) {
			sqlBuilder.append(" and g.warehouse_id='" + paraArray[1] + "'");
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
	
	//逻辑删除商品
	@Override
	public int deleteById(Object[] paraArray) throws Exception {
		BaseDaoImpl dao = new BaseDaoImpl();
		int result = 0;
		result = dao.update("update goods set del_flag='1' where id=?", paraArray);
//		存储过程的写法
//		result = dao.update("call GdeleteById(?)", paraArray);
		return result;
	}
	
	//通过id修改销售单
	@Override
	public int updateById(Object[] paraArray) throws Exception {
		BaseDaoImpl dao = new BaseDaoImpl();
		int result = 0;
		result = dao.update("update goods set name=?,price=?,origin=?,stock=?,warehouse_id=?,category_id=? where id=?",
				paraArray);
		return result;
	}
	
	//插入销售单
	@Override
	public int insertById(Object[] paraArray) throws Exception {
		BaseDaoImpl dao = new BaseDaoImpl();
		int result = 0;
		result = dao.insert(
				"insert into goods(id,name,price,origin,stock,warehouse_id,category_id,del_flag)  values(?,?,?,?,?,?,?,'0')",
				paraArray);
//		存储过程的写法
//		result = dao.insert(
//				"call GinsertById(?,?,?,?,?,?,?)",
//				paraArray);
		return result;
	}
	
	//查询所有商品
	@Override
	public List selectAll() throws Exception {
		BaseDaoImpl dao = new BaseDaoImpl();
		String sql = "select id,name from goods where 1=1 and del_flag='0' ";
//		存储过程的写法
//		String sql = "call GselectAll()";
		List<Object[]> list = dao.select(sql, 2, null);
		return list;
	}
	
	//通过id查询销售单
	@Override
	public List selectById(Object[] paraArray) throws Exception {
		BaseDaoImpl dao = new BaseDaoImpl();
		String sql = "select c.id,c.name,w.id,w.name,g.stock " + "from goods g,category c,warehouse w "
				+ "where g.category_id=c.id and g.warehouse_id=w.id and g.del_flag='0' and c.del_flag='0' and w.del_flag='0' and g.id=?";
		List<Object[]> list = dao.select(sql, 5, paraArray);
		return list;
	}
	
	//通过id修改库存
	@Override
	public int updateStockById(Object[] paraArray) throws Exception {
		BaseDaoImpl dao = new BaseDaoImpl();
		int result = 0;
		result = dao.update("update goods set stock=stock+? where id=?", paraArray);
		return result;
	}

}
