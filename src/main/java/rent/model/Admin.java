package rent.model;

import java.io.Serializable;

/**
 * Author: FES
 */
public class Admin implements Serializable{
	private static final long serialVersionUID = 1L;
	private int admin_id;
	private String admin_address;
	private String admin_pNum;
	private String admin_title;
	private String admin_department;
	private int user_id;
	
	public Admin() {
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

	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}