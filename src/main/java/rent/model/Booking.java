package rent.model;

import java.io.Serializable;

/**
 * Author: FES
 */
public class Booking implements Serializable{
	private static final long serialVersionUID = 1L;
	private int booking_id;
	private String booking_date,end_date;
	private String pickup_location;
	private String drop_location;
	private int booking_days;
	private int rr_id;
	private int car_id; 
	private double total_price; 
	
	public Booking() {
	}
	
	public int getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}
	
	public String getBooking_date() {
		return booking_date;
	}
	public void setBooking_date(String booking_date) {
		this.booking_date = booking_date;
	}
	
	public String getPickup_location() {
		return pickup_location;
	}
	public void setPickup_location(String pickup_location) {
		this.pickup_location = pickup_location;
	}
	
	public String getDrop_location() {
		return drop_location;
	}
	public void setDrop_location(String drop_location) {
		this.drop_location = drop_location;
	}
	
	public int getRr_id() {
		return rr_id;
	}
	public void setRr_id(int rr_id) {
		this.rr_id = rr_id;
	}
	
	public int getCar_id() {
		return car_id;
	}
	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}

	public int getBooking_days() {
		return booking_days;
	}

	public void setBooking_days(int booking_days) {
		this.booking_days = booking_days;
	}

	public double getTotal_price() {
		return total_price;
	}

	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	
	
	
}