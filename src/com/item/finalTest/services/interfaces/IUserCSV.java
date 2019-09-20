package com.item.finalTest.services.interfaces;

import com.item.finalTest.domain.userVO;

/**
 * �û��˻�����
 * @author hemb
 * @date   2019��9��14��
 */
public interface IUserCSV {
	
	/**
	 * ����û�
	 * @throws Exception 
	 */
	public void saveUser(userVO user) throws Exception;
	
	/**
	 * ����ID��ѯ�û�
	 * @throws Exception 
	 */
	public userVO queryUserById(long userId) throws Exception;
	
	/**
	 * ����Id�޸��û���Ϣ
	 * @throws Exception 
	 */
	public void updateUser(userVO user,long id) throws Exception;
	
	/**
	 * ͨ��Idɾ���û�
	 */
	public void deleteUser(long Id);
}
