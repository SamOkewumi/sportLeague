package com.oke.league;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBHandler {

	
	public static String accessConfig(String property) {
		String configFilePath = "src/config.properties";
		FileInputStream propsInput = null;
		try {
			propsInput = new FileInputStream(configFilePath);
		} catch (FileNotFoundException e) {
			System.out.println("Exception:" + e.getMessage());
		}
		Properties prop = new Properties();
		try {
			prop.load(propsInput);
		} catch (IOException e) {
			System.out.println("Exception:" + e.getMessage());
		}
		
		return prop.getProperty(property);
	}
	
	public Connection createConnection(){
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(accessConfig("DB_URL") + accessConfig("DB_PORT") + "/" + accessConfig("DB_NAME"), 
					accessConfig("DB_USER"), accessConfig("DB_PASSWORD"));
			System.out.println("Opened database successfully");
		} catch (SQLException e) {
			System.out.println("Exception:" + e.getMessage());
		}
		
		return conn;
		
	}
	
	public boolean closeConnection(Connection conn) {
		boolean flag = true;
		try {
			conn.close();
		} catch (SQLException e) {
			flag = false;
			System.out.println("Exception:" + e.getMessage());
		}
		return flag;
	}

}
