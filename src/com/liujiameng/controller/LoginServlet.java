package com.liujiameng.controller;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liujiameng.pojo.User;
import com.liujiameng.servicesImpl.LoginServicesImpl;


/*
 * Class：LoginServlet
 * autor: liujiameng
 * 
 */
public class LoginServlet extends HttpServlet {

	/**
	 * 生成随机号
	 */
	private static final long serialVersionUID = 7545032851537902663L;

	//重写doget方法
	@Override
	protected void doGet( HttpServletRequest httpreq , HttpServletResponse  httpresponse) 
			throws ServerException, IOException, ServletException{
	//
		System.out.println("1234567");
		logout( httpreq , httpresponse );
	}

	
	/*
	 * @param:httpreq HttpServletRequest对象
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost( HttpServletRequest httpreq , HttpServletResponse  httpresponse) 
			throws ServerException, IOException{
		
		
		System.out.println(httpreq.getMethod());
		
	
		//创建LoginServicesImpl对象，操作数据库
		LoginServicesImpl loginservicesimpl = new LoginServicesImpl();
		
		//定义错误信息
		String msg = null;
		
		//设置请求和响应报文的格式，防止乱码		
		httpreq.setCharacterEncoding("UTF-8");
		httpresponse.setCharacterEncoding("UTF-8");
		
		//创建user对象，以便获取视图传来的数据
		User user = new User();
		
		//httpreq.getParameter("userName")方法获取jsp输入文本的值，userName需要与jsp输入文本的name属性值一致，否则获取不到值，下一句同理
		user.setUserName( httpreq.getParameter("userName") );
		user.setPsw( httpreq.getParameter("psw") );
		
		//loginservicesimpl.queryByUserName(user.getUserName()),这个方法调用服务层查询用户是否存在，当返回为false时执行if大括号里内容
		if(!loginservicesimpl.queryByUserName(user.getUserName())) {
		    
		    try {
		    	msg = "当前用户不存在！！！";
				httpreq.getSession().setAttribute("msg", msg);
				httpreq.getRequestDispatcher("Login.jsp").forward(httpreq, httpresponse);
			} catch (ServletException e) {
				
				e.printStackTrace();
			}
		    
		    
		}else {
			//当用户存在的时候执行下面程序，调用LoginServicesImpl类的queryByUser(user)方法（非静态方法，使用对象调用）
			user.setUserid( loginservicesimpl.queryByUser(user) );
			if(user.getUserid() == null) {
				try {
					msg = "密码输入错误，请重新输入！！！";
					httpreq.getSession().setAttribute("msg", msg);
					httpreq.getRequestDispatcher("Login.jsp").forward(httpreq, httpresponse);
				} catch (ServletException e) {
					
					e.printStackTrace();
				}
				
			}else {
				
				try {
					httpreq.getRequestDispatcher("LoginSuccess.jsp").forward(httpreq, httpresponse);
				} catch (ServletException e) {
					
					e.printStackTrace();
				}
			}	
		}
		
		System.out.println(user);
	 }
	
	public void logout( HttpServletRequest httpreq , HttpServletResponse  httpresponse) throws ServletException, IOException {
		
		System.out.println("void doPost( HttpServletRequest httpreq , HttpServletResponse  httpresponse) ");
		
		httpreq.getSession().removeAttribute("userName");//清空session信息
		httpreq.getSession().invalidate();//清除 session 中的所有信息
		httpreq.getRequestDispatcher("Login.jsp").forward(httpreq, httpresponse);
		
	}
}
