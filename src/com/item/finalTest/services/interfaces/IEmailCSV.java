package com.item.finalTest.services.interfaces;

import com.item.finalTest.domain.emailVO;

public interface IEmailCSV {
	
	/**
	 * 发送邮件
	 * @throws Exception 
	 */
	public boolean sendEmail(emailVO emailVO) throws Exception;
}
