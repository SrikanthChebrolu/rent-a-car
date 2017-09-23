package com.rental.beans;

import java.io.Serializable;
import java.util.Date;

public class BookingDetails implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3946864994067064503L;
	
	private String booking_id;
	private String user_id ;
	private String car_id ;
	private String location_id ;
	private Date booking_date ;
	private  Date from_date ;
	private  Date to_date; 
	private  int total_cost;
	private boolean rental_ext;
	public String getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(String booking_id) {
		this.booking_id = booking_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getCar_id() {
		return car_id;
	}
	public void setCar_id(String car_id) {
		this.car_id = car_id;
	}
	public String getLocation_id() {
		return location_id;
	}
	public void setLocation_id(String location_id) {
		this.location_id = location_id;
	}
	public Date getBooking_date() {
		return booking_date;
	}
	public void setBooking_date(Date booking_date) {
		this.booking_date = booking_date;
	}
	public Date getFrom_date() {
		return from_date;
	}
	public void setFrom_date(Date from_date) {
		this.from_date = from_date;
	}
	public Date getTo_date() {
		return to_date;
	}
	public void setTo_date(Date to_date) {
		this.to_date = to_date;
	}
	public int getTotal_cost() {
		return total_cost;
	}
	public void setTotal_cost(int total_cost) {
		this.total_cost = total_cost;
	}
	public boolean isRental_ext() {
		return rental_ext;
	}
	public void setRental_ext(boolean rental_ext) {
		this.rental_ext = rental_ext;
	}
	@Override
	public String toString() {
		return "BookingDetails [booking_id=" + booking_id + ", user_id="
				+ user_id + ", car_id=" + car_id + ", location_id="
				+ location_id + ", booking_date=" + booking_date
				+ ", from_date=" + from_date + ", to_date=" + to_date
				+ ", total_cost=" + total_cost + ", rental_ext=" + rental_ext
				+ "]";
	}
	


}
