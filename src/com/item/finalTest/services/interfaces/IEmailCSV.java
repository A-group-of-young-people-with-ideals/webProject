package com.item.finalTest.services.interfaces;

import com.item.finalTest.domain.emailVO;

public interface IEmailCSV {
	
	/**
	 * ·¢ËÍÓÊ¼þ
	 * @throws Exception 
	 */
	public boolean sendEmail(emailVO emailVO) throws Exception;
}
