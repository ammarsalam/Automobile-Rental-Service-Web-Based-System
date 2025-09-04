package rent.model;

import java.io.Serializable;

/**
 * Author: FES
 */
public class Car implements Serializable{
	private static final long serialVersionUID = 1L;
	private int car_id;
	private String car_type;
	private String car_brand;
	private String car_model;
	private String car_color;
	private int no_of_seats;
	private String availability;
	private double price_per_day;
	private int rr_id;
	private String car_plate;
	private String ownerBusy;
	
	public Car() {
	}
	
	public int getCar_id() {
		return car_id;
	}
	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}
	
	public String getCar_type() {
		return car_type;
	}
	public void setCar_type(String car_type) {
		this.car_type = car_type;
	}
	
	public String getCar_brand() {
		return car_brand;
	}
	public void setCar_brand(String car_brand) {
		this.car_brand = car_brand;
	}
	
	public String getCar_model() {
		return car_model;
	}
	public void setCar_model(String car_model) {
		this.car_model = car_model;
	}
	
	public String getCar_color() {
		return car_color;
	}
	public void setCar_color(String car_color) {
		this.car_color = car_color;
	}
	
	public int getNo_of_seats() {
		return no_of_seats;
	}
	public void setNo_of_seats(int no_of_seats) {
		this.no_of_seats = no_of_seats;
	}
	
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	
	public double getPrice_per_day() {
		return price_per_day;
	}
	public void setPrice_per_day(double price_per_day) {
		this.price_per_day = price_per_day;
	}
	
	public int getRr_id() {
		return rr_id;
	}
	public void setRr_id(int rr_id) {
		this.rr_id = rr_id;
	}

	public String getCar_plate() {
		return car_plate;
	}

	public void setCar_plate(String car_plate) {
		this.car_plate = car_plate;
	}

	public String getOwnerBusy() {
		return ownerBusy;
	}

	public void setOwnerBusy(String ownerAvailability) {
		this.ownerBusy = ownerAvailability;
	}
	
	
	
}