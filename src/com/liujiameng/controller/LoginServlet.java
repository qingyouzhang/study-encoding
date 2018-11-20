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
 * Class��LoginServlet
 * autor: liujiameng
 * 
 */
public class LoginServlet extends HttpServlet {

	/**
	 * ���������
	 */
	private static final long serialVersionUID = 7545032851537902663L;

	//��дdoget����
	@Override
	protected void doGet( HttpServletRequest httpreq , HttpServletResponse  httpresponse) 
			throws ServerException, IOException, ServletException{
	//
		System.out.println("1234567");
		logout( httpreq , httpresponse );
	}

	
	/*
	 * @param:httpreq HttpServletRequest����
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost( HttpServletRequest httpreq , HttpServletResponse  httpresponse) 
			throws ServerException, IOException{
		
		
		System.out.println(httpreq.getMethod());
		
	
		//����LoginServicesImpl���󣬲������ݿ�
		LoginServicesImpl loginservicesimpl = new LoginServicesImpl();
		
		//���������Ϣ
		String msg = null;
		
		//�����������Ӧ���ĵĸ�ʽ����ֹ����		
		httpreq.setCharacterEncoding("UTF-8");
		httpresponse.setCharacterEncoding("UTF-8");
		
		//����user�����Ա��ȡ��ͼ����������
		User user = new User();
		
		//httpreq.getParameter("userName")������ȡjsp�����ı���ֵ��userName��Ҫ��jsp�����ı���name����ֵһ�£������ȡ����ֵ����һ��ͬ��
		user.setUserName( httpreq.getParameter("userName") );
		user.setPsw( httpreq.getParameter("psw") );
		
		//loginservicesimpl.queryByUserName(user.getUserName()),����������÷�����ѯ�û��Ƿ���ڣ�������Ϊfalseʱִ��if������������
		if(!loginservicesimpl.queryByUserName(user.getUserName())) {
		    
		    try {
		    	msg = "��ǰ�û������ڣ�����";
				httpreq.getSession().setAttribute("msg", msg);
				httpreq.getRequestDispatcher("Login.jsp").forward(httpreq, httpresponse);
			} catch (ServletException e) {
				
				e.printStackTrace();
			}
		    
		    
		}else {
			//���û����ڵ�ʱ��ִ��������򣬵���LoginServicesImpl���queryByUser(user)�������Ǿ�̬������ʹ�ö�����ã�
			user.setUserid( loginservicesimpl.queryByUser(user) );
			if(user.getUserid() == null) {
				try {
					msg = "��������������������룡����";
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
		
		httpreq.getSession().removeAttribute("userName");//���session��Ϣ
		httpreq.getSession().invalidate();//��� session �е�������Ϣ
		httpreq.getRequestDispatcher("Login.jsp").forward(httpreq, httpresponse);
		
	}
}
