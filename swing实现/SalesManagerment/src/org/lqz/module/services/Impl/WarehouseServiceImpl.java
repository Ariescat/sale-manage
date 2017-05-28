package org.lqz.module.services.Impl;

import java.util.List;
import java.util.Vector;

import org.lqz.module.dao.Impl.BaseDaoImpl;
import org.lqz.module.services.WarehouseService;

public class WarehouseServiceImpl implements WarehouseService {
	
	//遍历所有仓库
	@Override
	public List selectAll() throws Exception {
		BaseDaoImpl dao = new BaseDaoImpl();
		List list = dao.select("select id,name from warehouse where 1=1 and del_flag='0' ", 2, null);
		if (!list.isEmpty()) {
			return list;
		}
		return null;
	}
	
	//遍历所有仓库返回Vector
	@Override
	public Vector<Vector> selectAllVexctor() throws Exception {
		Vector<Vector> rows = new Vector<Vector>();
		BaseDaoImpl dao = new BaseDaoImpl();
		List<Object[]> list = dao.select("select id,sort,name from warehouse where 1=1 and del_flag='0'  order by sort",
				3, null);
		if (!list.isEmpty()) {
			int number = 1;
			for (Object[] object : list) {
				Vector temp = new Vector<String>();
				for (int i = 0; i < object.length; i++) {
					if (i == 1) {
						temp.add(number);
					} else {
						temp.add(object[i]);
					}
				}
				rows.add(temp);
				number++;
			}
		}
		return rows;
	}
	
	//通过Id修改仓库
	@Override
	public int updateById(Object[] paramArray) throws Exception {
		int result = 0;
		BaseDaoImpl dao = new BaseDaoImpl();
		result = dao.update("update warehouse set name=? where id=?", paramArray);
		return result;
	}
	
	//通过Id逻辑删除仓库
	@Override
	public int deleteById(Object[] paramArray) throws Exception {
		BaseDaoImpl dao = new BaseDaoImpl();
		int result = 0;
		result = dao.update("update warehouse set del_flag='1' where id=?", paramArray);
		return result;
	}
	
	//插入仓库
	@Override
	public int insertById(Object[] paramArray) throws Exception {
		BaseDaoImpl dao = new BaseDaoImpl();
		int result = 0;
		result = dao.insert("insert into warehouse(id,name) values(?,?) ", paramArray);
		return result;
	}

}
