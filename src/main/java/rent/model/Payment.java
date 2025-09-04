package rent.model;

import java.io.Serializable;

/**
 * Author: FES
 */
public class Payment implements Serializable{
	private static final long serialVersionUID = 1L;
	private int payment_id;
	private String payment_type;
	private int booking_id;
	
	public Payment() {
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
	
	public int getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}
}