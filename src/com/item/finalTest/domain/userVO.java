package com.item.finalTest.domain;

import java.io.Serializable;

/**
 * �û���Ϣ
 * @author hemb
 * @date   2019��9��14��
 */

public class userVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * �û�id
	 */
	private Long userId;
	
	/**
	 * �û�����
	 */
	private String name;
	
	/**
	 * �û�����
	 */
	private int age;
	
	/**
	 * �û��Ա�
	 */
	private String sex;
	
	/**
	 * �û�����
	 */
	private String email;
	
	/**
	 * �û��绰
	 */
	private String telephone;
	
	/**
	 * �û���ַ
	 */
	private String address;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
