package com.item.finalTest.domain;

import java.io.Serializable;

/**
 * 用户信息
 * @author hemb
 * @date   2019年9月14日
 */

public class userVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 用户id
	 */
	private Long userId;
	
	/**
	 * 用户姓名
	 */
	private String name;
	
	/**
	 * 用户年龄
	 */
	private int age;
	
	/**
	 * 用户性别
	 */
	private String sex;
	
	/**
	 * 用户邮箱
	 */
	private String email;
	
	/**
	 * 用户电话
	 */
	private String telephone;
	
	/**
	 * 用户地址
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

	@Override
	public String toString() {
		return "userVO [userId=" + userId + ", name=" + name + ", age=" + age + ", sex=" + sex + ", email=" + email
				+ ", telephone=" + telephone + ", address=" + address + "]";
	}
	
}