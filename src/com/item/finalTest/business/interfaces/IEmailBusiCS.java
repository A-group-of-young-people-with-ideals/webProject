package com.item.finalTest.business.interfaces;

import com.item.finalTest.domain.emailVO;

public interface IEmailBusiCS {

	boolean sendEmail(emailVO emailVO) throws Exception;

}
