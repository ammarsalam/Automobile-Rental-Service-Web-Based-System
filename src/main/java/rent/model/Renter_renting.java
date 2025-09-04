package rent.model;

import java.io.Serializable;

/**
 * Author: FES
 */

public class Renter_renting implements Serializable {
	private static final long serialVersionUID = 1L;
	private int rr_id,	user_id;
	private String rr_address,rr_pNum,rr_license,rr_experience;
	
	public Renter_renting() {
		
	}

	public int getRr_id() {
		return rr_id;
	}

	public void setRr_id(int rr_id) {
		this.rr_id = rr_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
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
	
}