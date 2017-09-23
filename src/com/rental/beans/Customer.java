package com.rental.beans;

import java.io.Serializable;
import java.util.Date;

public class Customer implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3246840379411864068L;
	private String user_password ;
	private String user_id ;
	private String user_firstname ;
	private String user_lastname ;
	private String user_emailid ;
	private String  user_phonenumber ;
	private String user_city ;
	private String  user_cardno ;
	 private Date user_cardexp;
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_firstname() {
		return user_firstname;
	}
	public void setUser_firstname(String user_firstname) {
		this.user_firstname = user_firstname;
	}
	public String getUser_lastname() {
		return user_lastname;
	}
	public void setUser_lastname(String user_lastname) {
		this.user_lastname = user_lastname;
	}
	public String getUser_emailid() {
		return user_emailid;
	}
	public void setUser_emailid(String user_emailid) {
		this.user_emailid = user_emailid;
	}
	public String getUser_phonenumber() {
		return user_phonenumber;
	}
	public void setUser_phonenumber(String user_phonenumber) {
		this.user_phonenumber = user_phonenumber;
	}
	public String getUser_city() {
		return user_city;
	}
	public void setUser_city(String user_city) {
		this.user_city = user_city;
	}
	public String getUser_cardno() {
		return user_cardno;
	}
	public void setUser_cardno(String user_cardno) {
		this.user_cardno = user_cardno;
	}
	public Date getUser_cardexp() {
		return user_cardexp;
	}
	public void setUser_cardexp(Date user_cardexp) {
		this.user_cardexp = user_cardexp;
	}
	
	

}
