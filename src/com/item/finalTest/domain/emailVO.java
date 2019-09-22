package com.item.finalTest.domain;

import java.io.Serializable;
/**
 * 邮件主体、发送对象、发送主题
 * @author hemb
 * @date   2019年9月22日
 */
public class emailVO implements Serializable {
	/**
	 * 接受者邮箱
	 */
	private String hisEmail;
	
	/**
	 * 邮件内容
	 * @return
	 */
	private String content;
	
	/**
	 * 邮件主题
	 * @return
	 */
	private String theme;

	public String getHisEmail() {
		return hisEmail;
	}

	public void setHisEmail(String hisEmail) {
		this.hisEmail = hisEmail;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}
}
