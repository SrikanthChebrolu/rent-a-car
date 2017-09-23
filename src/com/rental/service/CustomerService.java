package com.rental.service;

import com.rental.beans.Customer;

public interface CustomerService {
public String persistCustomerDetails(Customer cust);
	
	public Customer getCustomerDetails(String userid);
	
	
}
