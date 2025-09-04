package rent.model;


import java.io.Serializable;
public class Bridge implements Serializable {
	private static final long serialVersionUID = 1L;
	private int car_id,rr_id,booking_id,no_of_seats,user_id,admin_id,booking_days,payment_id;
	private String end_date,error_message,payment_type,rr_address,rr_pNum,rr_license,rr_experience,car_type,car_model,car_color,availability,car_plate,car_brand,booking_date,pickup_location,drop_location,admin_address,admin_pNum,admin_title,admin_department,user_name,user_password,user_email,user_role;
	private double price_per_day,totalPrice;
	private double maxAxia,minAxia,maxBezza,minBezza,maxKancil,minKancil,maxMyvi,minMyvi,maxPersona,minPersona,maxWira,minWira;
    
    public Bridge() {
    	
    }


	public int getCar_id() {
		return car_id;
	}


	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}


	public int getRr_id() {
		return rr_id;
	}

	public void setRr_id(int rr_id) {
		this.rr_id = rr_id;
	}

	public int getBooking_id() {
		return booking_id;
	}


	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}

	public String getCar_type() {
		return car_type;
	}


	public void setCar_type(String car_type) {
		this.car_type = car_type;
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

	public String getCar_plate() {
		return car_plate;
	}

	public void setCar_plate(String car_plate) {
		this.car_plate = car_plate;
	}

	public String getCar_brand() {
		return car_brand;
	}

	public void setCar_brand(String car_brand) {
		this.car_brand = car_brand;
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


	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	public int getAdmin_id() {
		return admin_id;
	}


	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}


	public String getAdmin_address() {
		return admin_address;
	}


	public void setAdmin_address(String admin_address) {
		this.admin_address = admin_address;
	}


	public String getAdmin_pNum() {
		return admin_pNum;
	}


	public void setAdmin_pNum(String admin_pNum) {
		this.admin_pNum = admin_pNum;
	}


	public String getAdmin_title() {
		return admin_title;
	}


	public void setAdmin_title(String admin_title) {
		this.admin_title = admin_title;
	}


	public String getAdmin_department() {
		return admin_department;
	}


	public void setAdmin_department(String admin_department) {
		this.admin_department = admin_department;
	}


	public String getUser_name() {
		return user_name;
	}


	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}


	public String getUser_password() {
		return user_password;
	}


	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}


	public String getUser_email() {
		return user_email;
	}


	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}


	public String getUser_role() {
		return user_role;
	}


	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}


	public String getRr_address() {
		return rr_address;
	}


	public void setRr_address(String rr_address) {
		this.rr_address = rr_address;
	}


	public String getRr_pNum() {
		return rr_pNum;
	}


	public void setRr_pNum(String rr_pNum) {
		this.rr_pNum = rr_pNum;
	}


	public String getRr_license() {
		return rr_license;
	}


	public void setRr_license(String rr_license) {
		this.rr_license = rr_license;
	}


	public String getRr_experience() {
		return rr_experience;
	}


	public void setRr_experience(String rr_experience) {
		this.rr_experience = rr_experience;
	}


	public int getBooking_days() {
		return booking_days;
	}


	public void setBooking_days(int booking_days) {
		this.booking_days = booking_days;
	}


	public int getPayment_id() {
		return payment_id;
	}


	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}


	public String getPayment_type() {
		return payment_type;
	}


	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}


	public String getError_message() {
		return error_message;
	}


	public void setError_message(String error_message) {
		this.error_message = error_message;
	}


	public double getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}


	public String getEnd_date() {
		return end_date;
	}


	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}


	public double getMaxAxia() {
		return maxAxia;
	}


	public void setMaxAxia(double maxAxia) {
		this.maxAxia = maxAxia;
	}


	public double getMinAxia() {
		return minAxia;
	}


	public void setMinAxia(double minAxia) {
		this.minAxia = minAxia;
	}


	public double getMaxBezza() {
		return maxBezza;
	}


	public void setMaxBezza(double maxBezza) {
		this.maxBezza = maxBezza;
	}


	public double getMinBezza() {
		return minBezza;
	}


	public void setMinBezza(double minBezza) {
		this.minBezza = minBezza;
	}


	public double getMaxKancil() {
		return maxKancil;
	}


	public void setMaxKancil(double maxKancil) {
		this.maxKancil = maxKancil;
	}


	public double getMinKancil() {
		return minKancil;
	}


	public void setMinKancil(double minKancil) {
		this.minKancil = minKancil;
	}


	public double getMaxMyvi() {
		return maxMyvi;
	}


	public void setMaxMyvi(double maxMyvi) {
		this.maxMyvi = maxMyvi;
	}


	public double getMinMyvi() {
		return minMyvi;
	}


	public void setMinMyvi(double minMyvi) {
		this.minMyvi = minMyvi;
	}


	public double getMaxPersona() {
		return maxPersona;
	}


	public void setMaxPersona(double maxPersona) {
		this.maxPersona = maxPersona;
	}


	public double getMinPersona() {
		return minPersona;
	}


	public void setMinPersona(double minPersona) {
		this.minPersona = minPersona;
	}


	public double getMaxWira() {
		return maxWira;
	}


	public void setMaxWira(double maxWira) {
		this.maxWira = maxWira;
	}


	public double getMinWira() {
		return minWira;
	}


	public void setMinWira(double minWira) {
		this.minWira = minWira;
	}  
}
