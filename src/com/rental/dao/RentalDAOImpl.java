package com.rental.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.rental.beans.BookingDetails;
import com.rental.beans.CarDetails;
import com.rental.beans.Customer;
import com.rental.beans.Employee;
import com.rental.beans.LocationDetails;
@Repository
public class RentalDAOImpl implements RentalDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate ;

	@Override
	public List<LocationDetails> getLocationIds(String state) {
		List<LocationDetails>  ls = jdbcTemplate.query("select * from location_details where state = ?", new Object[]{state}, new BeanPropertyRowMapper<LocationDetails>(LocationDetails.class));
		return ls;	}

	@Override
	public List<CarDetails> getCarsFromLocationId(String locId) {
		List<CarDetails>  ls = jdbcTemplate.query("select * from cardetails where location_id = ?", new Object[]{locId}, new BeanPropertyRowMapper<CarDetails>(CarDetails.class));
		return ls;
	}

	@Override
	public List<BookingDetails> getBookingDetails(String locId) {
		List<BookingDetails>  ls = jdbcTemplate.query("select * from booking_details where location_id = ?", new Object[]{locId}, new BeanPropertyRowMapper<BookingDetails>(BookingDetails.class));
		return ls;
	}

	@Override
	public String validateUser(String userid, String pwd) {
		
		Customer cust;
		try{
		 cust = jdbcTemplate.queryForObject("select * from user_details where user_emailid = ? and user_password = ?", new Object[]{userid,pwd}, new BeanPropertyRowMapper<Customer>(Customer.class));
		}
		catch(Exception e){
			return "";
		}
		return cust.getUser_id();
	}
	/*if(cust != null){
		
	}
	return "";
	}
*/
	@Override
	public CarDetails getCarDetails(String carId) {
		CarDetails car = jdbcTemplate.queryForObject("select * from cardetails where car_id = ? ", new Object[]{carId}, new BeanPropertyRowMapper<CarDetails>(CarDetails.class));
		
		return car;
	}

	@Override
	public BookingDetails getConformationData(String bookingId) {
		BookingDetails bd = jdbcTemplate.queryForObject("select * from booking_details where booking_id = ? ", new Object[]{bookingId}, new BeanPropertyRowMapper<BookingDetails>(BookingDetails.class));
		
		return bd;
	}

	@Override
	public String persistCustomerDetails(Customer cust) {
		cust.setUser_id(String.valueOf(System.nanoTime()));
		String insertSql = "INSERT INTO user_details(user_password, user_id, user_firstname, user_lastname, user_emailid, user_phonenumber, user_city, user_cardno, user_cardexp) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
		
		int out=jdbcTemplate.update(insertSql,new Object[]{cust.getUser_password(),cust.getUser_id(),cust.getUser_firstname(),cust.getUser_lastname()
				,cust.getUser_emailid(),cust.getUser_password(),cust.getUser_city(),cust.getUser_cardno(),cust.getUser_cardexp()});
		if(out==0){
			return "";
		}
		return cust.getUser_id();
	}

	@Override
	public Map<String, Integer> getBookingAggregateOnLoc(String locId,
			Date from, Date to) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean rentalModification(BookingDetails bookingDetails) {
		
		String insertSql = "INSERT INTO booking_details(booking_id, user_id, car_id, location_id, booking_date, from_date, to_date, total_cost, rental_ext)  VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
		
		int out=jdbcTemplate.update(insertSql,new Object[]{bookingDetails.getBooking_id(),bookingDetails.getUser_id(),bookingDetails.getCar_id(),bookingDetails.getLocation_id()
				,bookingDetails.getBooking_date(),bookingDetails.getFrom_date(),bookingDetails.getTo_date(),bookingDetails.getTotal_cost(),bookingDetails.isRental_ext()});
		if(out==0){
			return false;
		}
		return true;
	}

	@Override
	public String validateEmployee(String userid, String pwd) {
		Employee cust = jdbcTemplate.queryForObject("select * from user_details where emp_id = ? and emp_password = ?", new Object[]{userid,pwd}, new BeanPropertyRowMapper<Employee>(Employee.class));
		if(cust != null){
			return cust.getEmp_id();
		}
		return "";
	}

	@Override
	public Customer getCustomerDetails(String userid) {
		Customer bd = jdbcTemplate.queryForObject("select * from user_details where user_id = ? ", new Object[]{userid}, new BeanPropertyRowMapper<Customer>(Customer.class));
		
		return bd;
	}

	@Override
	public String persistBooking(BookingDetails bookingDetails) {
		bookingDetails.setBooking_id(String.valueOf(System.nanoTime()));
		String insertSql = "INSERT INTO booking_details(booking_id, user_id, car_id, location_id, booking_date, from_date, to_date, total_cost, rental_ext)  VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
		
		int out=jdbcTemplate.update(insertSql,new Object[]{bookingDetails.getBooking_id(),bookingDetails.getUser_id(),bookingDetails.getCar_id(),bookingDetails.getLocation_id()
				,bookingDetails.getBooking_date(),bookingDetails.getFrom_date(),bookingDetails.getTo_date(),bookingDetails.getTotal_cost(),bookingDetails.isRental_ext()});
		if(out==0){
			return bookingDetails.getBooking_id();
		}
		return "";
	}
	
	@Override
	public LocationDetails getLocationDetailsFromLocationId(String locId) {
		// TODO Auto-generated method stub
		LocationDetails ld = jdbcTemplate.queryForObject("select * from location_details where location_id = ? ", new Object[]{locId}, new BeanPropertyRowMapper<LocationDetails>(LocationDetails.class));
		return ld;
	}

}
