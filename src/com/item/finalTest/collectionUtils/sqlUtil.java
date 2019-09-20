package com.item.finalTest.collectionUtils;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * 数据库封装类
 * @author hemb
 * @date   2019年9月14日
 */
public final class sqlUtil {
	public static Connection getConnect() {
		 Properties prop = new Properties();
		Connection conn = null;
		try {
			prop.load(new FileInputStream("src/configuration/jdbc.properties"));
	         String driver = prop.getProperty("driver");
	         String user=prop.getProperty("user");
	         String password=prop.getProperty("password");
	         String dataBase=prop.getProperty("datebase");
	        if(!StringUtil.isBlank(driver)&&!StringUtil.isBlank(user)&&!StringUtil.isBlank(password)&&!StringUtil.isBlank(dataBase)) {
	        	Class.forName(driver);
				conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/"+dataBase+"?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8",
						user, password);
	        	
	        }else {
	        	throw  new Exception("jdbc配置不完整，请完善"); 
	        }
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return conn;
	}
}
