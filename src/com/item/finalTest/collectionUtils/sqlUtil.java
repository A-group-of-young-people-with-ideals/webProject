package com.item.finalTest.collectionUtils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 数据库封装类
 * @author hemb
 * @date   2019年9月14日
 */
public final class sqlUtil {

	private static final String USER_ACCOUNT = "root";

	private static final String USER_PASSWORD = "123456";
	
	private static final String DATE_BASE="finaltest";

	public static Connection getConnect() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/"+DATE_BASE+"?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8",
					USER_ACCOUNT, USER_PASSWORD);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return conn;
	}
}
