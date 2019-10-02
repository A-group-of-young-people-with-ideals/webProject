package com.item.finalTest.collectionUtils;

import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * String封装类
 * @author hemb
 * @date   2019年9月14日
 */
public final class StringUtil {
	/**
	 * 判断字符串是否为空
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
	 * 截取字符串
	 * @strSrc 目标字符串
	 * @iMaxLength  截取后的长度
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
	 * 获取随机字符串
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
	 * 左补齐
	 * 
	 * @param target
	 *            目标字符串
	 * @param fix
	 *            补齐字符
	 * @param length
	 *            目标长度
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
	 * 右补齐
	 * 
	 * @param target
	 *            目标字符串
	 * @param fix
	 *            补齐字符
	 * @param length
	 *            目标长度
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
	 * 获取字符串对应的字节长度，英文占一个字节，中文3个字节（UTF-8编码）
	 * @param str
	 * @return 字符串所占字节
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
	 * 首字母大写
	 * @param value
	 * @return
	 */
	public static String upperCaseFirstChar(String value) {
		char[] cs = value.toCharArray();
		// ASCII码前移32位
		cs[0] -= 32;
		return String.valueOf(cs);
	}
	/**
	 * 判断字符串是否为数值型字符串
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
	
	
	/**
     * 下划线命名转驼峰命名
     * @param underscore
     * @return
     */
    public static String underscoreToCamelCase(String underscore){
        String[] ss = underscore.split("_");
        if(ss.length ==1){
            return underscore;
        }

        StringBuffer sb = new StringBuffer();
        sb.append(ss[0]);
        for (int i = 1; i < ss.length; i++) {
            sb.append(upperFirstCase(ss[i]));
        }

        return sb.toString();
    }

    /**
     * 驼峰 转下划线
     * @param camelCase
     * @return
     */
    public static String toLine(String camelCase){
        Pattern humpPattern = Pattern.compile("[A-Z]");
        Matcher matcher = humpPattern.matcher(camelCase);
        StringBuffer sb = new StringBuffer();
        while(matcher.find()){
            matcher.appendReplacement(sb, "_"+matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }


    /**
     * 首字母 转小写
     * @param str
     * @return
     */
    @SuppressWarnings("unused")
	private static String lowerFirstCase(String str) {
        char[] chars = str.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }

    /**
     * 首字母 转大写
     * @param str
     * @return
     */
    private static String upperFirstCase(String str) {
        char[] chars = str.toCharArray();
        chars[0] -= 32;
        return String.valueOf(chars);
    }
	

}
