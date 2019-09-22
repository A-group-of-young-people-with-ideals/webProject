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
		// 读取配置文件
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
				// 信封
				emailAssit assit = new emailAssit();
				// 发信人相关信息
				assit.setSmtpHost(smtpHost);// 如果使用163邮箱，修改为smtp.163.com
				assit.setFromEmail(yourEmail);
				assit.setPassword(secretKey);
				// 收信人及邮箱格式
				assit.sendMessage(hisEmail, content, theme);
				result = true;
			}
		} else {
			throw new Exception("邮件配置参数不完整");
		}
		return result;
	}
}
