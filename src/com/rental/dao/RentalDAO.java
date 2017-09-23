package com.rental.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.rental.beans.BookingDetails;
import com.rental.beans.CarDetails;
import com.rental.beans.Customer;
import com.rental.beans.LocationDetails;

public interface RentalDAO {

	
	public List<LocationDetails> getLocationIds(String state);
	public List<CarDetails> getCarsFromLocationId(String locId);
	public List<BookingDetails> getBookingDetails(String locId);
	public String validateUser(String userid,String pwd);
	public String validateEmployee(String userid,String pwd);
	public CarDetails getCarDetails(String carId);
	public Customer getCustomerDetails(String userid);
	
	public BookingDetails getConformationData(String bookingId);
	public String persistCustomerDetails(Customer cust);
	public Map<String,Integer> getBookingAggregateOnLoc(String locId,Date from,Date to);
	public boolean rentalModification(BookingDetails bookingDetails);
	public String persistBooking(BookingDetails bookingDetails);
	public LocationDetails getLocationDetailsFromLocationId(String locId);
	
}
