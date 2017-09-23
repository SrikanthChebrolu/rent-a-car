package com.rental.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rental.beans.BookingDetails;
import com.rental.beans.CarDetails;
import com.rental.beans.Customer;
import com.rental.beans.LocationDetails;
import com.rental.dao.RentalDAO;
@Service
public class BookingServiceImpl implements BookingService {
	@Autowired
	private RentalDAO rentalDAO;

	@Override
	public List<LocationDetails> getLocationIds(String state) {
		return rentalDAO.getLocationIds(state);
	}
	

	@Override
	public CarDetails getCarDetails(String carId) {
		// TODO Auto-generated method stub
		return rentalDAO.getCarDetails(carId);
	}

	@Override
	public boolean rentalModification(BookingDetails bookingDetails) {
		// TODO Auto-generated method stub
		return rentalDAO.rentalModification(bookingDetails);
	}

	@Override
	public String persistBooking(BookingDetails bookingDetails) {
		// TODO Auto-generated method stub
		return rentalDAO.persistBooking(bookingDetails);
	}
	
	@Override
	public BookingDetails getConformationData(String bookingId) {
		// TODO Auto-generated method stub
		return rentalDAO.getConformationData(bookingId);
	}
	
	@Override
	public LocationDetails getLocationDetailsFromLocationId(String locId) {
		// TODO Auto-generated method stub
		return rentalDAO.getLocationDetailsFromLocationId(locId);
	}
	
	@Override
	public String persistCustomerDetails(Customer cust) {
		// TODO Auto-generated method stub
		return rentalDAO.persistCustomerDetails(cust);
	}

	@Override
	public String validateUser(String userid, String pwd) {
		// TODO Auto-generated method stub
		  return rentalDAO.validateUser(userid,pwd);
	}
		
	@Override
	public String validateEmployee(String userid, String pwd) {
		// TODO Auto-generated method stub
		return rentalDAO.validateEmployee(userid, pwd);
	}
}
