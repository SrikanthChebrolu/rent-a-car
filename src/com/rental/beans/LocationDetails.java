package com.rental.beans;

import java.io.Serializable;

public class LocationDetails implements Serializable{

	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1135871218306714285L;
	private String location_id;
	  private String state ;
	 private Double lat ;
	  private Double longitudinal ;
	 private int  zoom ;
	 private String  location_name;
	public String getLocation_id() {
		return location_id;
	}
	public void setLocation_id(String location_id) {
		this.location_id = location_id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	
	public Double getLongitudinal() {
		return longitudinal;
	}
	public void setLongitudinal(Double longitudinal) {
		this.longitudinal = longitudinal;
	}
	public int getZoom() {
		return zoom;
	}
	public void setZoom(int zoom) {
		this.zoom = zoom;
	}
	public String getLocation_name() {
		return location_name;
	}
	public void setLocation_name(String location_name) {
		this.location_name = location_name;
	}
	@Override
	public String toString() {
		return "LocationDetails [location_id=" + location_id + ", state="
				+ state + ", lat=" + lat + ", longitude=" + longitudinal
				+ ", zoom=" + zoom + ", location_name=" + location_name + "]";
	}
	

	
}
