package com.iot.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.iot.util.GetterSetter;
import com.iot.util.PropertiesFile;

public class ConnectionDB {

	GetterSetter gs = new GetterSetter();
	public static final PropertiesFile propsFileLoader = new PropertiesFile("IOT");

	public Connection getConnection(){
		Connection conn = null;
		try {
			Class.forName(propsFileLoader.getValue("JDBCDriver"));
			conn = DriverManager.getConnection(propsFileLoader.getValue("DBConnectionString"),propsFileLoader.getValue("DBUsername"),propsFileLoader.getValue("DBPassword"));
			return conn;		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;	
	}
	

}
