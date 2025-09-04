package rent.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import rent.connection.ConnectionManager;
import rent.model.Payment;

public class PaymentDAO {
	
	private static Connection con = null;
	private static PreparedStatement ps = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	private int payment_id, booking_id;
	private String payment_type;
	private String sql;
	
	
	// insert payment
	public static void addPayment(Payment payment) throws SQLException{
		
		//complete the code here
		try {
			//call getConnection() method 
			con = ConnectionManager.getConnection();
			
			//3. create statement
			String sql = "INSERT INTO Payment(payment_type,booking_id)VALUES(?,?)";
			ps = con.prepareStatement(sql);
			//get values from Payment object and set parameter values
			ps.setString(1, payment.getPayment_type());
			ps.setInt(2, payment.getBooking_id());

			//4. execute query
			ps.executeUpdate();
			
			//5. close connection
			con.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static List<Payment> getEveryRRPayment(int rr_id){
		List<Payment> payments= new ArrayList<Payment>();

		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
				
			//3. create statement
			stmt = con.createStatement();
			String sql = "SELECT * FROM payment WHERE rr_id=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, rr_id);
			//4. execute query
			rs = ps.executeQuery();
			//process ResultSet and set the values to the Car object
			while(rs.next()) {
				Payment payment = new Payment();
				payment.setPayment_id(rs.getInt("payment_id"));
				payment.setPayment_type(rs.getString("payment_type"));
				payment.setBooking_id(rs.getInt("booking_id"));
				payments.add(payment);
			}
				
			//5. close connection
			con.close();
				
		}catch(Exception e) {
			e.printStackTrace();
		}
			
		return payments;
	}
}
