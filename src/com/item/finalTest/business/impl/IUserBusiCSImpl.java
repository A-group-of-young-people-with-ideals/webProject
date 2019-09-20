package com.item.finalTest.business.impl;

import java.sql.SQLException;

import com.item.finalTest.atom.impl.userAtomImpl;
import com.item.finalTest.atom.interfaces.IUserAtom;
import com.item.finalTest.business.interfaces.IUserBusiCS;
import com.item.finalTest.domain.userVO;


public class IUserBusiCSImpl implements IUserBusiCS {

	@Override
	public void saveUser(userVO user) throws Exception {
		if(user==null) {
			throw new Exception("param is null");
		}
		

	}

	@Override
	public userVO queryUserById(long userId) throws Exception {
		IUserAtom iUserAtom=new userAtomImpl();
		userVO  user=new userVO();
		if (userId != 0) {
			user=iUserAtom.queryUserById(userId);
		}
		return user;
	}

	@Override
	public void updateUser(userVO user, long id) throws Exception {
		if(user==null) {
			throw new Exception("param is null");
		}
		if(id!=0){
			
		}
		
	}

	@Override
	public void deleteUser(long Id) {
		if (Id != 0) {

		}
	}

}
