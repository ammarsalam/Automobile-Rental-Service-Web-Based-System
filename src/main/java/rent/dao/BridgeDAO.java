package rent.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import rent.connection.ConnectionManager;
import rent.model.Admin;
import rent.model.Booking;
import rent.model.Bridge;
import rent.model.Car;
import rent.model.User;


public class BridgeDAO {

	private static Connection con = null;
	private static PreparedStatement ps = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	private String sql;

	//get booking by id
	public static Bridge   getCarsBookingDetailsById(int booking_id) {

		Bridge bridge = new Bridge ();

		//complete the code here
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//3. create statement
			String sql = "SELECT b.booking_id,b.booking_date,b.end_date,b.pickup_location,b.drop_location,b.rr_id ,b.car_id,b.booking_days,c.car_type,c.car_brand,c.car_model,c.car_color,c.no_of_seats,c.availability,c.price_per_day,c.rr_id ,c.car_plate FROM booking b JOIN cars c ON b.car_id = c.car_id WHERE booking_id=?;";
			ps = con.prepareStatement(sql);
			//set parameter values
			ps.setInt(1, booking_id);

			//4. execute query
			rs = ps.executeQuery();
			//process ResultSet and set the values to the Shawl object
			if (rs.next()) {
				bridge = new Bridge ();
				// Populate DTO with ResultSet data
				// car_id,user_id
				bridge.setBooking_id(rs.getInt("booking_id"));
				bridge.setBooking_date(rs.getString("booking_date"));
				bridge.setEnd_date(rs.getString("end_date"));
				bridge.setPickup_location(rs.getString("pickup_location"));
				bridge.setDrop_location(rs.getString("drop_location"));
				bridge.setBooking_days(rs.getInt("booking_days"));
				bridge.setRr_id(rs.getInt("rr_id"));
				bridge.setCar_id(rs.getInt("car_id"));
				bridge.setCar_type(rs.getString("car_type"));
				bridge.setCar_brand(rs.getString("car_brand"));
				bridge.setCar_model(rs.getString("car_model"));
				bridge.setCar_color(rs.getString("car_color"));
				bridge.setNo_of_seats(rs.getInt("no_of_seats"));
				bridge.setAvailability(rs.getString("availability"));
				bridge.setPrice_per_day(rs.getDouble("price_per_day"));
				bridge.setCar_plate(rs.getString("car_plate"));
				bridge.setTotalPrice(bridge.getPrice_per_day()*bridge.getBooking_days());
			}
			
			//5. close connection
			con.close();

		}catch(Exception e) {
			e.printStackTrace();
		}

		return bridge;
	}


	public static List<Bridge> AllAdminUserBridge(){
		List<Bridge> bridges= new ArrayList<Bridge>();

		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();

			//3. create statement
			stmt = con.createStatement();
			String sql = "SELECT a.admin_id, a.admin_address, a.admin_pNum, a.admin_title, a.admin_department, a.user_id, u.user_name, u.user_email, u.user_role FROM admin a INNER JOIN user u ON a.user_id = u.user_id;";

			//4. execute query
			rs = stmt.executeQuery(sql);
			//process ResultSet and set the values to the Car object
			while(rs.next()) {
				Bridge bridge = new Bridge ();
				// Populate DTO with ResultSet data
				// car_id,user_id
				bridge.setAdmin_id(rs.getInt("admin_id"));
				bridge.setAdmin_address(rs.getString("admin_address"));
				bridge.setAdmin_pNum(rs.getString("admin_pNum"));
				bridge.setAdmin_title(rs.getString("admin_title"));
				bridge.setUser_id(rs.getInt("user_id"));
				bridge.setAdmin_department(rs.getString("admin_department"));
				bridge.setUser_name(rs.getString("user_name"));
				bridge.setUser_email(rs.getString("user_email"));
				bridge.setUser_role(rs.getString("user_role"));
				bridges.add(bridge);
			}

			//5. close connection
			con.close();

		}catch(Exception e) {
			e.printStackTrace();
		}

		return bridges;
	}

	public static Bridge   AdminUserBridge(int admin_id) {

		Bridge bridge = new Bridge ();

		//complete the code here
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();

			//3. create statement
			String sql = "SELECT a.admin_id, a.admin_address, a.admin_pNum, a.admin_title, a.admin_department, a.user_id, u.user_name, u.user_email, u.user_role FROM admin a INNER JOIN user u ON a.user_id = u.user_id WHERE admin_id=?;";
			ps = con.prepareStatement(sql);
			//set parameter values
			ps.setInt(1, admin_id);

			//4. execute query
			rs = ps.executeQuery();
			//process ResultSet and set the values to the Shawl object
			if (rs.next()) {
				bridge = new Bridge ();
				// Populate DTO with ResultSet data
				// car_id,user_id
				bridge.setAdmin_id(rs.getInt("admin_id"));
				bridge.setAdmin_address(rs.getString("admin_address"));
				bridge.setAdmin_pNum(rs.getString("admin_pNum"));
				bridge.setAdmin_title(rs.getString("admin_title"));
				bridge.setAdmin_department("admin_department");
				bridge.setUser_id(rs.getInt("user_id"));
				bridge.setUser_name(rs.getString("user_name"));
				bridge.setUser_email(rs.getString("user_email"));
				bridge.setUser_role(rs.getString("user_role"));
			}

			//5. close connection
			con.close();

		}catch(Exception e) {
			e.printStackTrace();
		}

		return bridge;
	}

	public static Bridge storeConfirmDetails(int user_id,int car_id) {

		Bridge bridge = new Bridge ();

		//complete the code here
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();

			
			String sql2="SELECT car_id, car_type, car_brand, car_model, car_color, no_of_seats, availability, price_per_day, car_plate FROM cars WHERE car_id = ?;";
			ps = con.prepareStatement(sql2);
			ps.setInt(1, car_id);
			
			rs = ps.executeQuery();
			bridge.setRr_id(user_id);
			if (rs.next()) {
				
				bridge.setCar_id(rs.getInt("car_id"));
				bridge.setCar_type(rs.getString("car_type"));
				bridge.setCar_brand(rs.getString("car_brand"));
				bridge.setCar_model(rs.getString("car_model"));
				bridge.setCar_color(rs.getString("car_color"));
				bridge.setNo_of_seats(rs.getInt("no_of_seats"));
				bridge.setAvailability(rs.getString("availability"));
				bridge.setPrice_per_day(rs.getDouble("price_per_day"));
				bridge.setCar_plate(rs.getString("car_plate"));

			}
			//5. close connection
			con.close();

		}catch(Exception e) {
			e.printStackTrace();
		}

		return bridge;
	}


	public static Bridge getRRCarDetailsById(int car_id) {

		Bridge bridge = new Bridge ();

		//complete the code here
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();

			//3. create statement
			String sql = "SELECT r.rr_id,r.rr_address,r.rr_pNum, r.rr_license,r.rr_experience,c.car_id,c.car_type,c.car_brand,c.car_model,c.car_color,c.no_of_seats,c.availability,c.price_per_day,c.rr_id ,c.car_plate FROM renter_renting r JOIN cars c ON r.rr_id = c.rr_id WHERE car_id =?;";
			ps = con.prepareStatement(sql);
			//set parameter values
			ps.setInt(1, car_id);

			//4. execute query
			rs = ps.executeQuery();
			//process ResultSet and set the values to the Shawl object
			if (rs.next()) {
				bridge = new Bridge ();
				// Populate DTO with ResultSet data
				// car_id,user_id
				bridge.setRr_id(rs.getInt("rr_id"));
				bridge.setRr_address(rs.getString("rr_address"));
				bridge.setRr_pNum(rs.getString("rr_pNUm"));
				bridge.setRr_license(rs.getString("rr_license"));
				bridge.setRr_experience(rs.getString("rr_experience"));
				bridge.setCar_id(rs.getInt("car_id"));
				bridge.setCar_type(rs.getString("car_type"));
				bridge.setCar_brand(rs.getString("car_brand"));
				bridge.setCar_model(rs.getString("car_model"));
				bridge.setCar_color(rs.getString("car_color"));
				bridge.setNo_of_seats(rs.getInt("no_of_seats"));
				bridge.setAvailability(rs.getString("availability"));
				bridge.setPrice_per_day(rs.getDouble("price_per_day"));
				bridge.setCar_plate(rs.getString("car_plate"));
			}

			//5. close connection
			con.close();

		}catch(Exception e) {
			e.printStackTrace();
		}

		return bridge;
	}

	/*public static boolean validateUser(String user_name, String user_password) throws SQLException {
    boolean isValidUser = false;

    try {
        con = ConnectionManager.getConnection();
        String sql = "SELECT * FROM user WHERE user_name = ? AND user_password = ?";
        ps = con.prepareStatement(sql);
        ps.setString(1, user_name);
        ps.setString(2, user_password);

        rs = ps.executeQuery();

        if (rs.next()) {
            // User exists with matching credentials
            isValidUser = true;
        }
    } finally {
        // Close resources in finally block
        if (rs != null) {
            rs.close();
        }
        if (ps != null) {
            ps.close();
        }
        if (con != null) {
            con.close();
        }
    }
    return isValidUser;
}*/

	public static int getUserId(boolean isValidUser,String user_name,String user_password) throws SQLException {

		int user_id=-1;
		try { 

			con = ConnectionManager.getConnection();
			String sql = "SELECT user_id FROM user WHERE user_name = ? AND user_password = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, user_name);
			ps.setString(2, user_password);

			rs = ps.executeQuery();

			if (rs.next()) {
				// User exists with matching credentials
				if(isValidUser) {
					user_id=rs.getInt("user_id");
				}
			}
		} finally {
			// Close resources in finally block
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return user_id;
	}


	public static int validateUser(String user_name, String user_password) throws SQLException {
		int user_id = -1;

		try { 

			con = ConnectionManager.getConnection();
			String sql = "SELECT rr_id FROM user u join renter_renting rr on u.user_id = rr.user_id where u.user_name=? AND u.user_password=?;";
			ps = con.prepareStatement(sql);
			ps.setString(1, user_name);
			ps.setString(2, user_password);

			rs = ps.executeQuery();

			if (rs.next()) {
				user_id = rs.getInt("rr_id");
			}
			con.close();

		}
		catch (SQLException e) {
			e.printStackTrace();
			throw e; // Rethrow the exception to be handled in the servlet
		}

		return user_id;
	} 
	
	
	//get user by id
	public static Bridge getUserProfile(int rr_id) {
		
		Bridge bridge = new Bridge();
		
		//complete the code here
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//3. create statement
			String sql = "SELECT user_name,user_password,user_email,rr_address,rr_pNum,rr_license,rr_experience FROM user u join renter_renting rr on u.user_id = rr.user_id where rr_id=?;";
			ps = con.prepareStatement(sql);
			//set parameter values
			ps.setInt(1, rr_id);
			
			//4. execute query
			rs = ps.executeQuery();
			//process ResultSet and set the values to the Bridge object
			if(rs.next()) {
				bridge.setUser_name(rs.getString("user_name"));
				bridge.setUser_password(rs.getString("user_password"));
				bridge.setUser_email(rs.getString("user_email"));
				bridge.setRr_address(rs.getString("rr_address"));
				bridge.setRr_pNum(rs.getString("rr_pNum"));
				bridge.setRr_license(rs.getString("rr_license"));
				bridge.setRr_experience(rs.getString("rr_experience"));
			}
			
			//5. close connection
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return bridge;
	}
	
	//update profile
	public static void updateProfile(Bridge bridge) throws SQLException{
		//complete the code here
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//3. create statement and get the values from Shawl object
			String sql = "UPDATE renter_renting SET rr_address=?,rr_pNum=?,rr_license=?,rr_experience=? WHERE rr_id=?";
			ps = con.prepareStatement(sql);
			//get values from Shawl object and set parameter values
			ps.setString(1, bridge.getRr_address());
			ps.setString(2, bridge.getRr_pNum());
			ps.setString(3, bridge.getRr_license());
			ps.setString(4, bridge.getRr_experience());
			ps.setInt(5, bridge.getRr_id());
			
			//4. execute query
			ps.executeUpdate();
			
			//5. close connection
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}	
	
	
	

	public static List<Bridge> getEveryRRPayment(int rr_id){
		List<Bridge> bridges= new ArrayList<Bridge>();

		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
				
			//3. create statement
			stmt = con.createStatement();
			String sql = "SELECT p.payment_id, p.payment_type, p.booking_id, b.total_price, b.booking_days, c.car_brand, c.car_model FROM payment p JOIN booking b ON p.booking_id = b.booking_id JOIN cars c ON b.car_id = c.car_id WHERE b.rr_id = ?;";
			ps = con.prepareStatement(sql);
			ps.setInt(1, rr_id);
			//4. execute query
			rs = ps.executeQuery();
			//process ResultSet and set the values to the Car object
			while(rs.next()) {
				Bridge bridge = new Bridge();
				bridge.setPayment_id(rs.getInt("payment_id"));
				bridge.setPayment_type(rs.getString("payment_type"));
				bridge.setBooking_id(rs.getInt("booking_id"));
				bridge.setTotalPrice(rs.getDouble("total_price"));
				bridge.setBooking_days(rs.getInt("booking_days"));
				bridge.setCar_brand(rs.getString("car_brand"));
				bridge.setCar_model(rs.getString("car_model"));
				bridges.add(bridge);
			}
				
			//5. close connection
			con.close();
				
		}catch(Exception e) {
			e.printStackTrace();
		}
			
		return bridges;
	}
	
	public static List<Booking> getEveryRRBooking(int rr_id){
		List<Booking> bookings= new ArrayList<Booking>();

		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
				
			//3. create statement
			stmt = con.createStatement();
			String sql = "SELECT booking_id, booking_date,end_date, pickup_location, drop_location, booking_days, rr_id, car_id,total_price FROM booking WHERE rr_id = ?;";
			ps = con.prepareStatement(sql);
			ps.setInt(1, rr_id);
			//4. execute query
			rs = ps.executeQuery();
			//process ResultSet and set the values to the Car object
			while(rs.next()) {
				Booking booking= new Booking();
				booking.setBooking_id(rs.getInt("booking_id"));
				booking.setBooking_date(rs.getString("booking_date"));
				booking.setEnd_date(rs.getString("end_date"));
				booking.setPickup_location(rs.getString("pickup_location"));
				booking.setDrop_location(rs.getString("drop_location"));
				booking.setBooking_days(rs.getInt("booking_days"));
				booking.setRr_id(rs.getInt("rr_id"));
				booking.setCar_id(rs.getInt("car_id"));
				booking.setTotal_price(rs.getDouble("total_price"));
				bookings.add(booking);
			}
				
			//5. close connection
			con.close();
				
		}catch(Exception e) {
			e.printStackTrace();
		}
			
		return bookings;
	}
	
public static Bridge viewSpecificPayment(int payment_id) {
		
	Bridge bridge= new Bridge();
		
		//complete the code here
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//3. create statement
			String sql = "SELECT p.payment_id, p.booking_id, p.payment_type, b.total_price, b.booking_days, c.car_brand, c.car_model FROM payment p JOIN booking b ON p.booking_id = b.booking_id JOIN cars c ON b.car_id = c.car_id WHERE p.payment_id = ?;";
			ps = con.prepareStatement(sql);
			//set parameter values
			ps.setInt(1, payment_id);
			
			//4. execute query
			rs = ps.executeQuery();
			//process ResultSet and set the values to the Shawl object
			if(rs.next()) {
				bridge.setPayment_id(rs.getInt("payment_id"));
				bridge.setBooking_id(rs.getInt("booking_id"));
				bridge.setPayment_type(rs.getString("payment_type"));
				bridge.setTotalPrice(rs.getDouble("total_price"));
				bridge.setBooking_days(rs.getInt("booking_days"));
				bridge.setCar_brand(rs.getString("car_brand"));
				bridge.setCar_model(rs.getString("car_model"));
			}
			
			//5. close connection
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return bridge;
	}

	public static Bridge PriceRangeCarModel(int rr_id) {
	
		Bridge bridge= new Bridge();
		
		//complete the code here
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//3. create statement
			String sql = "SELECT car_model, MAX(CASE WHEN c.rr_id != ? AND c.ownerBusy = 'false' THEN price_per_day ELSE NULL END) AS max_price, MIN(CASE WHEN c.rr_id != ? AND c.ownerBusy = 'false' THEN price_per_day ELSE NULL END) AS min_price FROM cars c GROUP BY car_model;";
			ps = con.prepareStatement(sql);
			//set parameter values
			ps.setInt(1, rr_id);
			ps.setInt(2, rr_id);
			
			//4. execute query
			rs = ps.executeQuery();
			bridge.setMaxAxia(0);
			bridge.setMinAxia(0);
			bridge.setMaxBezza(0);
			bridge.setMinBezza(0);
			bridge.setMaxKancil(0);
			bridge.setMinKancil(0);
			bridge.setMaxMyvi(0);
			bridge.setMinMyvi(0);
			bridge.setMaxPersona(0);
			bridge.setMinPersona(0);
			bridge.setMaxWira(0);
			bridge.setMinWira(0);

			//process ResultSet and set the values to the Shawl object
			while (rs.next()) {
                String carModel = rs.getString("car_model");
                double maxPrice = rs.getDouble("max_price");
                double minPrice = rs.getDouble("min_price");

                // Set the corresponding field in CarModelStats based on car_model
                switch (carModel) {
                    case "Axia":
                    	bridge.setMaxAxia(maxPrice);
                    	bridge.setMinAxia(minPrice);
                        break;
                    case "Bezza":
                    	bridge.setMaxBezza(maxPrice);
                    	bridge.setMinBezza(minPrice);
                        break;
                    case "Kancil":
                    	bridge.setMaxKancil(maxPrice);
                    	bridge.setMinKancil(minPrice);
                        break;
                    case "Myvi":
                    	bridge.setMaxMyvi(maxPrice);
                    	bridge.setMinMyvi(minPrice);
                        break;
                    case "Persona":
                    	bridge.setMaxPersona(maxPrice);
                    	bridge.setMinPersona(minPrice);
                        break;
                    case "Wira":
                    	bridge.setMaxWira(maxPrice);
                    	bridge.setMinWira(minPrice);
                        break;
                    // Add cases for other car models as needed
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle SQLException appropriately
        }
		
		return bridge;
	}

	
public static Bridge viewInvoice(int payment_id) {
		
		Bridge bridge= new Bridge();
			
			//complete the code here
			try {
				//call getConnection() method
				con = ConnectionManager.getConnection();
				
				//3. create statement
				String sql = "SELECT rr.rr_id, rr.rr_address, rr.rr_pNum, rr.rr_license, rr.rr_experience, rr.user_id, u.user_name, u.user_password, u.user_email, u.user_role, b.booking_id, b.booking_date, b.end_date, b.pickup_location, b.drop_location, b.booking_days, b.total_price, c.car_id, c.car_type, c.car_brand, c.car_model, c.car_color, c.no_of_seats, c.availability, c.price_per_day, c.car_plate, p.payment_id, p.payment_type FROM renter_renting rr JOIN user u ON rr.user_id = u.user_id JOIN booking b ON rr.rr_id = b.rr_id JOIN cars c ON b.car_id = c.car_id LEFT JOIN payment p ON b.booking_id = p.booking_id WHERE p.payment_id = ?";
				ps = con.prepareStatement(sql);
				//set parameter values 
				ps.setInt(1, payment_id);
				
				//4. execute query
				rs = ps.executeQuery();
				//process ResultSet and set the values to the Shawl object
				if(rs.next()) {
					bridge.setBooking_date(rs.getString("booking_date"));
					bridge.setPayment_id(rs.getInt("payment_id"));
					bridge.setUser_name(rs.getString("user_name"));
					bridge.setRr_address(rs.getString("rr_address"));
					bridge.setUser_email(rs.getString("user_email"));
					
					bridge.setRr_experience(rs.getString("rr_experience"));
					bridge.setRr_license(rs.getString("rr_license"));
					bridge.setRr_pNum(rs.getString("rr_pNum"));
					
					bridge.setCar_id(rs.getInt("car_id"));
					bridge.setCar_type(rs.getString("car_type"));
					bridge.setCar_brand(rs.getString("car_brand"));
					bridge.setCar_model(rs.getString("car_model"));
					bridge.setCar_plate(rs.getString("car_plate"));
					bridge.setEnd_date(rs.getString("end_date"));
					bridge.setPickup_location(rs.getString("pickup_location"));
					bridge.setDrop_location(rs.getString("drop_location"));
					bridge.setPrice_per_day(rs.getDouble("price_per_day"));
					
					bridge.setBooking_days(rs.getInt("booking_days"));
					bridge.setTotalPrice(rs.getDouble("total_price"));
					bridge.setPayment_type(rs.getString("payment_type"));
				}
				
				//5. close connection
				con.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return bridge;
		}
}