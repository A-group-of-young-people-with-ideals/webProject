package com.item.finalTest.services.impl;

import com.item.finalTest.business.impl.userBusiCSImpl;
import com.item.finalTest.business.interfaces.IUserBusiCS;
import com.item.finalTest.domain.userVO;
import com.item.finalTest.services.interfaces.IUserCSV;

public class userCSVImpl implements IUserCSV {

	@Override
	public void saveUser(userVO user) throws Exception {
		IUserBusiCS  iUserBusiCS=new userBusiCSImpl();
		iUserBusiCS.saveUser(user);
	}

	@Override
	public userVO queryUserById(long userId) throws Exception {
		IUserBusiCS  iUserBusiCS=new userBusiCSImpl();
		return iUserBusiCS.queryUserById(userId);
	}

	@Override
	public void updateUser(userVO user, long id) throws Exception {
		IUserBusiCS  iUserBusiCS=new userBusiCSImpl();
		iUserBusiCS.updateUser(user, id);
	}

	@Override
	public void deleteUser(long Id) {
		IUserBusiCS  iUserBusiCS=new userBusiCSImpl();
		iUserBusiCS.deleteUser(Id);
	}

}
