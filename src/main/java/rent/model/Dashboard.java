package rent.model;

import java.io.Serializable;

/**
 * Author: FES
 */
public class Dashboard implements Serializable{
	private static final long serialVersionUID = 1L;
	int noOfAdmins,noOfCars,noOfBookings,noOfUsers,rr_id,noTopCar,noTopModel;
	String user_name, car_model;
	
	
	public int getNoTopModel() {
		return noTopModel;
	}
	public void setNoTopModel(int noTopModel) {
		this.noTopModel = noTopModel;
	}
	public String getCar_model() {
		return car_model;
	}
	public void setCar_model(String car_model) {
		this.car_model = car_model;
	}
	public Dashboard() {
	}
	public int getNoOfAdmins() {
		return noOfAdmins;
	}
	public void setNoOfAdmins(int noOfAdmins) {
		this.noOfAdmins = noOfAdmins;
	}
	public int getNoOfCars() {
		return noOfCars;
	}
	public void setNoOfCars(int noOfCars) {
		this.noOfCars = noOfCars;
	}
	public int getNoOfBookings() {
		return noOfBookings;
	}
	public void setNoOfBookings(int noOfBookings) {
		this.noOfBookings = noOfBookings;
	}
	public int getNoOfUsers() {
		return noOfUsers;
	}
	public void setNoOfUsers(int noOfUsers) {
		this.noOfUsers = noOfUsers;
	}
	public int getRr_id() {
		return rr_id;
	}
	public void setRr_id(int rr_id) {
		this.rr_id = rr_id;
	}
	public int getNoTopCar() {
		return noTopCar;
	}
	public void setNoTopCar(int noTopCar) {
		this.noTopCar = noTopCar;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
}