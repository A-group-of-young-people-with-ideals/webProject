package com.item.finalTest.domain;

import java.io.Serializable;
/**
 * �ʼ����塢���Ͷ��󡢷�������
 * @author hemb
 * @date   2019��9��22��
 */
public class emailVO implements Serializable {
	/**
	 * ����������
	 */
	private String hisEmail;
	
	/**
	 * �ʼ�����
	 * @return
	 */
	private String content;
	
	/**
	 * �ʼ�����
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
