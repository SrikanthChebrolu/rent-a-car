package com.rental.service;

import java.util.List;

import com.rental.beans.BookingDetails;
import com.rental.beans.CarDetails;
import com.rental.beans.Customer;
import com.rental.beans.LocationDetails;

public interface BookingService {

	public List<LocationDetails> getLocationIds(String state);

	public String persistBooking(BookingDetails bookingDetails);

	public boolean rentalModification(BookingDetails bookingDetails);

	public CarDetails getCarDetails(String carId);

	public BookingDetails getConformationData(String bookingId);
	

	public LocationDetails getLocationDetailsFromLocationId(String locId);

	public String persistCustomerDetails(Customer cust);

	public String validateUser(String userid, String pwd);

	public String validateEmployee(String userid, String pwd);
}
