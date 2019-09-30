package com.item.finalTest.atom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.item.finalTest.atom.interfaces.IUserAtom;
import com.item.finalTest.collectionUtils.StringUtil;
import com.item.finalTest.collectionUtils.sqlUtil;
import com.item.finalTest.domain.userVO;



public class userAtomImpl implements IUserAtom {

	@Override
	public void saveUser(userVO user) {
		// TODO Auto-generated method stub

	}

	@Override
	public userVO queryUserById(long userId) throws SQLException {
		Connection connection=sqlUtil.getConnect();
		String sql="select * from user where userid=?";
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setLong(1, userId);
		ResultSet resultSet=preparedStatement.executeQuery();
		List<userVO> list=new ArrayList<userVO>();
		while (resultSet.next()) {
			userVO user=new userVO();
			long id=resultSet.getLong("userid");
			String email=resultSet.getString("email");
			String name=resultSet.getString("username");
			int status=resultSet.getInt("status");
			String sex=resultSet.getString("sex");
			String address=resultSet.getString("address");
			if(id!=0&&!StringUtil.isBlank(name)&&!StringUtil.isBlank(email)&&!StringUtil.isBlank(sex)&&!StringUtil.isBlank(address)) {
				user.setUserId(id);
				user.setEmail(email);
				user.setName(name);
				user.setSex(sex);
				user.setAddress(address);
				System.out.println(user.getAddress());
			}
			list.add(user);
		}
		return list.get(0);
	}

	@Override
	public void updateUser(userVO user, long id) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser(long Id) {
		// TODO Auto-generated method stub

	}

}
