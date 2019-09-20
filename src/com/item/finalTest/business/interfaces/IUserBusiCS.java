package com.item.finalTest.business.interfaces;

import com.item.finalTest.domain.userVO;

public interface IUserBusiCS {
	
	void saveUser(userVO user) throws Exception;
	
	userVO queryUserById(long userId) throws Exception;
	
	void updateUser(userVO user, long id) throws Exception;
	
	void deleteUser(long Id);

}
