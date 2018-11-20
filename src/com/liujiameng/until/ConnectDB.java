package com.liujiameng.until;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class ConnectDB {
	
	private static final String URL="jdbc:mysql://localhost:3306/db_liujiameng";//数据库名称为db_liujiameng
	
	private static final String USER="root";
	
	private static final String PASSWORD="123456";
	
	private static Connection conn=null;
	
    static{
	try {
	//加载驱动
	Class.forName("com.mysql.jdbc.Driver");
	//创建连接
	conn = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
	} catch (ClassNotFoundException e) {

	e.printStackTrace();
	} catch (SQLException e) {

	e.printStackTrace();
	}
	}
	public static Connection getConnection(){

	return conn;
	}
	
	public static void closeConnections() {
	
	try {
		conn.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	}

	public static void main(String[] args) {
		System.out.println(conn);
	}
}
