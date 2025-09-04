package rent.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import rent.connection.ConnectionManager;
import rent.model.Booking;

public class BookingDAO {

	private static Connection con = null;
	private static PreparedStatement ps = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	private int booking_id;
	private String booking_date;
	private String pickup_location;
	private String drop_location;
	private int user_id;
	private int car_id; 
	private String sql;
	private int booking_days;
		
	//insert booking
		public static void addBooking(Booking booking) throws SQLException{
			
			//complete the code here
			try {
				//call getConnection() method
				con = ConnectionManager.getConnection();
				
				//3. create statement
				String sql = "INSERT INTO booking(booking_date,pickup_location,drop_location,rr_id,car_id,booking_days,total_price)VALUES(?,?,?,?,?,?,?)";
				ps = con.prepareStatement(sql);
				//get values from Booking object and set parameter values
				ps.setString(1, booking.getBooking_date());
				ps.setString(2, booking.getPickup_location());
				ps.setString(3, booking.getDrop_location());
				ps.setInt(4, booking.getRr_id());
				ps.setInt(5, booking.getCar_id());
				ps.setInt(6, booking.getBooking_days());
				ps.setDouble(7, booking.getTotal_price());

				//4. execute query
				ps.executeUpdate();
				
				//5. close connection
				con.close();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}	
	
	//update booking
		public static void updateBooking(Booking booking) throws SQLException{
			//complete the code here
			try {
				//call getConnection() method
				con = ConnectionManager.getConnection();
				
				//3. create statement and get the values from Shawl object
				String sql = "UPDATE booking SET booking_date=?,pickup_location=?,drop_location=?,rr_id=?,car_id=?,booking_days=?, end_date=? WHERE booking_id=?";
				ps = con.prepareStatement(sql);
				//get values from Shawl object and set parameter values
				ps.setString(1, booking.getBooking_date());
				ps.setString(2, booking.getPickup_location());
				ps.setString(3, booking.getDrop_location());
				ps.setInt(4, booking.getRr_id());
				ps.setInt(5, booking.getCar_id());
				ps.setInt(6, booking.getBooking_days());
				ps.setString(7, booking.getEnd_date());
				ps.setInt(8, booking.getBooking_id());
				
				//4. execute query
				ps.executeUpdate();
				
				//5. close connection
				con.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		//delete booking
		public static void deleteBooking(int booking_id) throws SQLException{
			//complete the code here
			try {
				//call getConnection() method
				con = ConnectionManager.getConnection();
				
				//3. create statement
				String sql = "DELETE FROM booking WHERE booking_id=?";
				ps = con.prepareStatement(sql);
				//set parameter values
				ps.setInt(1, booking_id);
				
				//4. execute query
				ps.executeUpdate();
				
				//5. close connection
				con.close();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	//get all bookings
	public static List<Booking> getAllBooking(){
		List<Booking> bookings = new ArrayList<Booking>();

		//complete the code here
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
				
			//3. create statement
			stmt = con.createStatement();
			String sql = "SELECT * FROM booking";	
			
			//4. execute query
			rs = stmt.executeQuery(sql);
			//process ResultSet and set the values to the Booking object
			while(rs.next()) {
				Booking booking = new Booking();
				booking.setBooking_id(rs.getInt("booking_id"));
				booking.setBooking_date(rs.getString("booking_date"));
				booking.setEnd_date(rs.getString("end_date"));
				booking.setPickup_location(rs.getString("pickup_location"));
				booking.setDrop_location(rs.getString("drop_location"));
				booking.setRr_id(rs.getInt("rr_id"));
				booking.setCar_id(rs.getInt("car_id"));
				booking.setBooking_days(rs.getInt("booking_days"));
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
	
	//get booking by id
	public static Booking getBooking(int booking_id) {
		
		Booking booking= new Booking();
		
		//complete the code here
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//3. create statement
			String sql = "SELECT * FROM booking WHERE booking_id=?";
			ps = con.prepareStatement(sql);
			//set parameter values
			ps.setInt(1, booking_id);
			
			//4. execute query
			rs = ps.executeQuery();
			//process ResultSet and set the values to the Shawl object
			if(rs.next()) {
				booking.setBooking_id(rs.getInt("booking_id"));
				booking.setBooking_date(rs.getString("booking_date"));
				booking.setEnd_date(rs.getString("end_date"));
				booking.setPickup_location(rs.getString("pickup_location"));
				booking.setDrop_location(rs.getString("drop_location"));
				booking.setRr_id(rs.getInt("rr_id"));
				booking.setCar_id(rs.getInt("car_id"));
				booking.setBooking_days(rs.getInt("booking_days"));
				booking.setTotal_price(rs.getDouble("total_price"));
				
			}
			
			//5. close connection
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return booking;
	}
		
	//get booking by id
		public static int getLatestBookingID() {
			
			int id =0;
			
			//complete the code here
			try {
				//call getConnection() method
				con = ConnectionManager.getConnection();
				
				//3. create statement
				String sql = "SELECT * FROM booking ORDER BY booking_id DESC LIMIT 1;";
				ps = con.prepareStatement(sql);
				//set parameter values
				
				
				//4. execute query
				rs = ps.executeQuery();
				//process ResultSet and set the values to the Shawl object
				if(rs.next()) {
					id=rs.getInt("booking_id");					
				}
				
				//5. close connection
				con.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return id;
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
}