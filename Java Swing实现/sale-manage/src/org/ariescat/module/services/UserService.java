package org.ariescat.module.services;

import org.ariescat.module.entity.User;

public interface UserService {
	
	//通过用户名和密码查询用户
	public User selectOne(Object[] paraArray) throws Exception;
	
	//通过用户ID修改用户信息
	public int updateUserById(Object[] paraArray) throws Exception;
}
