package com.liujiameng.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionLisrtner implements HttpSessionListener {



	@Override
	public void sessionCreated(HttpSessionEvent arg0) {

		ServletContext ctx = arg0.getSession().getServletContext();
		Integer numSessions = (Integer) ctx.getAttribute("numSessions");
		if (numSessions == null) {
			numSessions = new Integer(1);
		} else {
			int count = numSessions.intValue();
			numSessions = new Integer(count + 1);
		}
		ctx.setAttribute("numSessions", numSessions);
		System.out.println("创建成功");
		System.out.println("当前在线人数"+numSessions);

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		ServletContext ctx = arg0.getSession().getServletContext();
		Integer numSessions = (Integer) ctx.getAttribute("numSessions");
	     if(numSessions == null) {
		   numSessions = new Integer(0); 
		 }else{
		int count = numSessions.intValue();
		numSessions = new Integer(count - 1);
	}
		 ctx.setAttribute("numSessions",numSessions);
		 System.out.println("销毁");
			System.out.println("当前在线人数"+numSessions);

   } 

}
