package com.rental.beans;

import java.io.Serializable;

public class CarDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -286212876181068434L;
	private String car_name;
	private String car_type;
	private String location_id;
	private int car_year;
	private String car_imageurl;
	private int car_price;
	private String car_id;

	public String getCar_name() {
		return car_name;
	}

	public void setCar_name(String car_name) {
		this.car_name = car_name;
	}

	public String getCar_type() {
		return car_type;
	}

	public void setCar_type(String car_type) {
		this.car_type = car_type;
	}

	
	public String getLocation_id() {
		return location_id;
	}

	public void setLocation_id(String location_id) {
		this.location_id = location_id;
	}

	public int getCar_year() {
		return car_year;
	}

	public void setCar_year(int car_year) {
		this.car_year = car_year;
	}

	public String getCar_imageurl() {
		return car_imageurl;
	}

	public void setCar_imageurl(String car_imageurl) {
		this.car_imageurl = car_imageurl;
	}

	public int getCar_price() {
		return car_price;
	}

	public void setCar_price(int car_price) {
		this.car_price = car_price;
	}

	public String getCar_id() {
		return car_id;
	}

	public void setCar_id(String car_id) {
		this.car_id = car_id;
	}

}
