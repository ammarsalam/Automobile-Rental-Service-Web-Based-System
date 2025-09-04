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
import rent.model.Dashboard;

public class DashboardDAO {

	private static Connection con = null;
	private static PreparedStatement ps = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	;
		
	//insert booking
		public static Dashboard getDashboard() throws SQLException{
			Dashboard dashboard= new Dashboard();
			try {
	            // Call getConnection() method
	            con = ConnectionManager.getConnection();
	            
	            // Get count of admins
	            String sql = "SELECT COUNT(*) FROM admin";
	            ps = con.prepareStatement(sql);
	            rs = ps.executeQuery();
	            if (rs.next()) {
	                dashboard.setNoOfAdmins(rs.getInt(1)); // Using column index 1
	            }

	            // Get count of users
	            sql = "SELECT COUNT(*) FROM renter_renting";
	            ps = con.prepareStatement(sql);
	            rs = ps.executeQuery();
	            if (rs.next()) {
	                dashboard.setNoOfUsers(rs.getInt(1)); // Using column index 1
	            }

	            // Get count of bookings
	            sql = "SELECT COUNT(*) FROM booking";
	            ps = con.prepareStatement(sql);
	            rs = ps.executeQuery();
	            if (rs.next()) {
	                dashboard.setNoOfBookings(rs.getInt(1)); // Using column index 1
	            }
	            
	            // Get count of users
	            sql = "SELECT COUNT(*) FROM cars";
	            ps = con.prepareStatement(sql);
	            rs = ps.executeQuery();
	            if (rs.next()) {
	                dashboard.setNoOfCars(rs.getInt(1)); // Using column index 1
	            }
	          
	            // Close connection
	            con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return dashboard;
		}
		
		public static List<Dashboard> getAllTopCar(){
			List<Dashboard> dashboards = new ArrayList<Dashboard>();

			//complete the code here
			try {
				//call getConnection() method
				con = ConnectionManager.getConnection();
					
				//3. create statement
				stmt = con.createStatement();
		        String sql = "SELECT rr.rr_id, u.user_name, COUNT(*) AS car_count FROM cars c JOIN renter_renting rr ON c.rr_id = rr.rr_id JOIN user u ON rr.user_id = u.user_id GROUP BY c.rr_id ORDER BY car_count DESC LIMIT 3;";	
				
				//4. execute query
				rs = stmt.executeQuery(sql);
				//process ResultSet and set the values to the Booking object
				while(rs.next()) {
					Dashboard dashboard = new Dashboard();
					dashboard.setRr_id(rs.getInt(1));
					dashboard.setUser_name(rs.getString(2));
					dashboard.setNoTopCar(rs.getInt(3));
					dashboards.add(dashboard);
				}
					
				//5. close connection
				con.close(); 
					
			}catch(Exception e) {
				e.printStackTrace();
			}
				
			return dashboards;
		}
		
		public static List<Dashboard> getAllTopModel(){
			List<Dashboard> dashboards = new ArrayList<Dashboard>();

			//complete the code here
			try {
				//call getConnection() method
				con = ConnectionManager.getConnection();
					
				//3. create statement
				stmt = con.createStatement();
		        String sql = "SELECT car_model, COUNT(*) AS total_count FROM cars GROUP BY car_model ORDER BY total_count DESC LIMIT 3;";	
				
				//4. execute query
				rs = stmt.executeQuery(sql);
				//process ResultSet and set the values to the Booking object
				while(rs.next()) {
					Dashboard dashboard = new Dashboard();
					dashboard.setCar_model(rs.getString(1));
					dashboard.setNoTopModel(rs.getInt(2));
					dashboards.add(dashboard);
				}
					
				//5. close connection
				con.close(); 
					
			}catch(Exception e) {
				e.printStackTrace();
			}
				
			return dashboards;
		}
}