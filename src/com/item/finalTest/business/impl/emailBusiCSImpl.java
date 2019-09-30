package com.item.finalTest.business.impl;

import java.io.FileInputStream;
import java.util.Properties;

import com.hemaobin.sendemail.emailAssit;
import com.item.finalTest.business.interfaces.IEmailBusiCS;
import com.item.finalTest.collectionUtils.StringUtil;
import com.item.finalTest.domain.emailVO;

public class emailBusiCSImpl implements IEmailBusiCS {

	@Override
	public boolean sendEmail(emailVO emailVO) throws Exception {
		boolean result = false;
		if (emailVO == null) {
			throw new Exception("param is null");
		}
		// ��ȡ�����ļ�
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/configuration/email.properties"));
		String smtpHost = prop.getProperty("smtpHost");
		String yourEmail = prop.getProperty("yourEmail");
		String secretKey = prop.getProperty("secretKey");
		if (!StringUtil.isBlank(smtpHost) && !StringUtil.isBlank(yourEmail) && !StringUtil.isBlank(secretKey)) {
			String hisEmail = emailVO.getHisEmail();
			String content = emailVO.getContent();
			String theme = emailVO.getTheme();
			if (!StringUtil.isBlank(hisEmail) && !StringUtil.isBlank(content) && !StringUtil.isBlank(theme)) {
				// �ŷ�
				emailAssit assit = new emailAssit();
				// �����������Ϣ
				assit.setSmtpHost(smtpHost);// ���ʹ��163���䣬�޸�Ϊsmtp.163.com
				assit.setFromEmail(yourEmail);
				assit.setPassword(secretKey);
				// �����˼������ʽ
				assit.sendMessage(hisEmail, content, theme);
				result = true;
			}
		} else {
			throw new Exception("�ʼ����ò���������");
		}
		return result;
	}
}
