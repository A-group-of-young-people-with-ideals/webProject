package com.item.finalTest.services.impl;

import com.item.finalTest.business.impl.emailBusiCSImpl;
import com.item.finalTest.business.interfaces.IEmailBusiCS;
import com.item.finalTest.domain.emailVO;
import com.item.finalTest.services.interfaces.IEmailCSV;

public class emailCSVImpl implements IEmailCSV {

	@Override
	public boolean sendEmail(emailVO emailVO) throws Exception {
		IEmailBusiCS  iEmailBusiCS=new emailBusiCSImpl();
		return iEmailBusiCS.sendEmail(emailVO);
	}

}
