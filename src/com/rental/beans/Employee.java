package com.rental.beans;

import java.io.Serializable;

public class Employee implements Serializable{

	 /**
	 * 
	 */
	private static final long serialVersionUID = -4984597465230323320L;
	private String  emp_id ;
	 private String  emp_name ;
	 private String emp_password ;
	 private String emp_phone ;
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getEmp_password() {
		return emp_password;
	}
	public void setEmp_password(String emp_password) {
		this.emp_password = emp_password;
	}
	public String getEmp_phone() {
		return emp_phone;
	}
	public void setEmp_phone(String emp_phone) {
		this.emp_phone = emp_phone;
	}
	 
	
}
