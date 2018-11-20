package com.liujiameng.pojo;

public class User {
	
	private String userName;
	private String psw;
	private String userid;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	@Override
	public String toString() {
		return "User [userName=" + userName + ", psw=" + psw + ", userid=" + userid + "]";
	}
}
