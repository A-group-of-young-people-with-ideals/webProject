package com.item.finalTest.atom.interfaces;

import java.sql.SQLException;

import com.item.finalTest.domain.userVO;

public interface IUserAtom {

	void saveUser(userVO user);

	userVO queryUserById(long userId) throws SQLException;

	void updateUser(userVO user, long id) throws Exception;

	void deleteUser(long Id);


}
