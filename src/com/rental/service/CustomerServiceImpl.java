package com.rental.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rental.beans.Customer;
import com.rental.dao.RentalDAO;
@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private RentalDAO rentalDao;
	
	@Override
	public String persistCustomerDetails(Customer cust) {
		// TODO Auto-generated method stub
		return rentalDao.persistCustomerDetails(cust);
	}

	@Override
	public Customer getCustomerDetails(String userid) {
		// TODO Auto-generated method stub
		return rentalDao.getCustomerDetails(userid);
	}
}
