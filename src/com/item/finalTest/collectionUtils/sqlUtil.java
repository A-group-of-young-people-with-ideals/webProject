package com.item.finalTest.collectionUtils;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * ���ݿ��װ��
 * @author hemb
 * @date   2019��9��14��
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
	        	throw  new Exception("jdbc���ò�������������"); 
	        }
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return conn;
	}
}
