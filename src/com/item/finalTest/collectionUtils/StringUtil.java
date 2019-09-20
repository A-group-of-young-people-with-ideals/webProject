package com.item.finalTest.collectionUtils;

import java.util.concurrent.ThreadLocalRandom;

/**
 * String��װ��
 * @author hemb
 * @date   2019��9��14��
 */
public final class StringUtil {
	/**
	 * �ж��ַ����Ƿ�Ϊ��
	 * @param str
	 * @return true/false
	 */
	public static boolean isBlank(String str) {
		if (null == str) {
			return true;
		}
		if ("".equals(str.trim())) {
			return true;
		}
		return false;
	}
	/**
	 * ��ȡ�ַ���
	 * @strSrc Ŀ���ַ���
	 * @iMaxLength  ��ȡ��ĳ���
	 */
	public static String trim(String strSrc, int iMaxLength) {
		if (strSrc == null) {
			return null;
		}
		if (iMaxLength <= 0) {
			return strSrc;
		}
		String strResult = strSrc;
		byte[] b = null;
		int iLength = strSrc.length();
		if (iLength > iMaxLength) {
			strResult = strResult.substring(0, iMaxLength);
			iLength = iMaxLength;
		}
		while (true) {
			b = strResult.getBytes();
			if (b.length <= iMaxLength) {
				break;
			}
			iLength--;
			strResult = strResult.substring(0, iLength);
		}
		return strResult;
	}
	/**
	 * ��ȡ����ַ���
	 */
	public static String getRandomString(int length) {
		String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		int n = str.length();
		StringBuilder buf = new StringBuilder();

		for (int i = 0; i < length; i++) {
			buf.append(str.charAt(ThreadLocalRandom.current().nextInt(n)));
		}

		return buf.toString();
	}
	/**
	 * ����
	 * 
	 * @param target
	 *            Ŀ���ַ���
	 * @param fix
	 *            �����ַ�
	 * @param length
	 *            Ŀ�곤��
	 * @return
	 */
	public static String lPad(String target, String fix, int length) {
		if (target == null || fix == null || !(target.length() < length)) {
			return target;
		}
		StringBuilder newStr = new StringBuilder();
		for (int i = 0; i < length - target.length(); i++) {
			newStr.append(fix);
		}
		return newStr.append(target).toString();
	}

	/**
	 * �Ҳ���
	 * 
	 * @param target
	 *            Ŀ���ַ���
	 * @param fix
	 *            �����ַ�
	 * @param length
	 *            Ŀ�곤��
	 * @return
	 */
	public static String rPad(String target, String fix, int length) {
		if (target == null || fix == null || !(target.length() < length)) {
			return target;
		}
		StringBuilder newStr = new StringBuilder();
		newStr.append(target);
		for (int i = 0; i < length - target.length(); i++) {
			newStr.append(fix);
		}
		return newStr.toString();
	}
	/**
	 * ��ȡ�ַ�����Ӧ���ֽڳ��ȣ�Ӣ��ռһ���ֽڣ�����3���ֽڣ�UTF-8���룩
	 * @param str
	 * @return �ַ�����ռ�ֽ�
	 */
	public static int getByteLength(String str) {
		try {
			byte[] b = str.getBytes("UTF-8");
			return b.length;
		} catch (Exception ex) {
			return 0;
		}
	}
	/**
	 * ����ĸ��д
	 * @param value
	 * @return
	 */
	public static String upperCaseFirstChar(String value) {
		char[] cs = value.toCharArray();
		// ASCII��ǰ��32λ
		cs[0] -= 32;
		return String.valueOf(cs);
	}
	/**
	 * �ж��ַ����Ƿ�Ϊ��ֵ���ַ���
	 * @param numberStr
	 * @return
	 */
	public static boolean isNum(String numberStr) {
		if (isBlank(numberStr)) {
			return false;
		} else {
			int sz = numberStr.length();

			for (int i = 0; i < sz; ++i) {
				if (!Character.isDigit(numberStr.charAt(i))) {
					return false;
				}
			}

			return true;
		}
	}

}
