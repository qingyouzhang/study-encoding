package com.liujiameng.servicesImpl;

import com.liujiameng.dao.LoginDao;
import com.liujiameng.pojo.User;
import com.liujiameng.services.LoginServices;

public class LoginServicesImpl implements  LoginServices{
	
	private LoginDao loginDao = new LoginDao();

	@Override
	public boolean queryByUserName(String username) {	
		String str =  loginDao.queryByUserName(username);
		
		if(str == null || str == "") {
			return false;
		}
		
		return true;
	}

	@Override
	public String queryByUser(User user) {
		
		User userservice = new User();
	
		userservice = loginDao.queryByUser(user);
		return userservice.getUserid();
	}
	
	public static void main(String[] args) {
		LoginServicesImpl logindao = new LoginServicesImpl();

		User user = new User();
		
		user.setUserName("admin");
		user.setPsw("123456");
		
		
		System.out.println(logindao.queryByUser(user));
		
		logindao.queryByUserName("≤‚ ‘5");
	}

}
