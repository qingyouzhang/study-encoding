package com.liujiameng.services;

import com.liujiameng.pojo.User;

public interface LoginServices {
	
	public boolean queryByUserName ( String username );
	
	public String   queryByUser ( User user );

}
