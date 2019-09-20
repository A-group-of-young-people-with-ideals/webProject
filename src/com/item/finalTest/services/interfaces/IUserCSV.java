package com.item.finalTest.services.interfaces;

import com.item.finalTest.domain.userVO;

/**
 * 用户账户操作
 * @author hemb
 * @date   2019年9月14日
 */
public interface IUserCSV {
	
	/**
	 * 添加用户
	 * @throws Exception 
	 */
	public void saveUser(userVO user) throws Exception;
	
	/**
	 * 根据ID查询用户
	 * @throws Exception 
	 */
	public userVO queryUserById(long userId) throws Exception;
	
	/**
	 * 根据Id修改用户信息
	 * @throws Exception 
	 */
	public void updateUser(userVO user,long id) throws Exception;
	
	/**
	 * 通过Id删除用户
	 */
	public void deleteUser(long Id);
}
