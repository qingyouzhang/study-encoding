package com.liujiameng.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.liujiameng.pojo.User;
import com.liujiameng.until.ConnectDB;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class LoginDao {

	private static Connection con = ConnectDB.getConnection();
	private PreparedStatement prepared = null;
	private ResultSet result = null;

	public String queryByUserName(String username) {

		String str = null;

		try {
			prepared = (PreparedStatement) con
					.prepareStatement("select username from db_liujiameng.tb_user where username=?");

			prepared.setString(1, username);

			result = prepared.executeQuery();

			while (result.next()) {

				str = result.getString(1);

				System.out.println("����������ѯ"+str);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return str;
	}

	public User queryByUser(User user) {
		
		try {
			prepared = (PreparedStatement) con
					.prepareStatement("select userid from db_liujiameng.tb_user where username=? and psw=?");

			prepared.setString(1, user.getUserName() );
			prepared.setString(2, user.getPsw() );

			result = prepared.executeQuery();

			while (result.next()) {
				user.setUserid( result.getString(1) );
				System.out.println(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				result.close();
				prepared.close();
			} catch (SQLException e) {
				System.out.println("���ݿ�ر��쳣");
				e.printStackTrace();
			}
		}
		return user;
	}

	//����jdbc��ͨ��ѯ��������
	public static void main(String[] args) {
		LoginDao logindao = new LoginDao();

		User user = new User();
		
		user.setUserName("admin");
		user.setPsw("123456");
		
		user = logindao.queryByUser(user);
		System.out.println(user);
		
		//logindao.queryByUserName("����");
	}
}
