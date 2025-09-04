package rent.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import rent.connection.ConnectionManager;
import rent.model.Renter_renting;

public class Renter_rentingDAO {

	private static Connection con = null;
	private static PreparedStatement ps = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	private int rr_id,user_id;
	private String rr_address,rr_pNum,rr_license,rr_experience;
	private String sql;
	
	
	//insert Renter_renting
	public static void addRenter_renting(Renter_renting Renter_renting) throws SQLException{
		
		//complete the code here
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//3. create statement
			String sql = "INSERT INTO renter_renting(rr_id, rr_address, rr_pNum, rr_license, rr_experience, user_id,)VALUES(?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			//get values from Shawl object and set parameter values
			ps.setInt(1, Renter_renting.getRr_id());
			ps.setString(2, Renter_renting.getRr_address());
			ps.setString(3, Renter_renting.getRr_pNum());
			ps.setString(4, Renter_renting.getRr_license());
			ps.setString(5, Renter_renting.getRr_experience());
			ps.setInt(6, Renter_renting.getUser_id());
			
			
			//4. execute query
			ps.executeUpdate();
			
			//5. close connection
			con.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}	
		
		
	//update shawl
	public static void updateRenter_renting(Renter_renting Renter_renting) throws SQLException{
		//complete the code here
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//3. create statement and get the values from Shawl object
			String sql = "UPDATE renter_renting SET rr_address=?,rr_pNum=?,rr_license=?,rr_experience=?,user_id=? WHERE rr_id=?";
			ps = con.prepareStatement(sql);
			//get values from Shawl object and set parameter values
			ps.setString(1,Renter_renting.getRr_address());
			ps.setString(2, Renter_renting.getRr_pNum());
			ps.setString(3, Renter_renting.getRr_license());
			ps.setString(4, Renter_renting.getRr_experience());
			ps.setInt(5, Renter_renting.getUser_id());
			ps.setInt(6, Renter_renting.getRr_id());
			
			//4. execute query
			ps.executeUpdate();
			
			//5. close connection
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}	
		
		
	//delete shawl
	public static void deleteRenter_renting(int rr_id) throws SQLException{
		//complete the code here
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//3. create statement
			String sql = "DELETE FROM renter_renting WHERE rr_id=?";
			ps = con.prepareStatement(sql);
			//set parameter values
			ps.setInt(1, rr_id);
			
			//4. execute query
			ps.executeUpdate();
			
			//5. close connection
			con.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
		
		
	//get user by id
	public static Renter_renting getRenter_renting(int rr_id) {
		
		Renter_renting renter_renting = new Renter_renting();
		
		//complete the code here
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//3. create statement
			String sql = "SELECT * FROM renter_renting WHERE rr_id=?";
			ps = con.prepareStatement(sql);
			//set parameter values
			ps.setInt(1, rr_id);
			
			//4. execute query
			rs = ps.executeQuery();
			//process ResultSet and set the values to the Shawl object
			if(rs.next()) {
				renter_renting.setRr_id(rs.getInt("rr_id"));
				renter_renting.setRr_address(rs.getString("rr_address"));
				renter_renting.setRr_pNum(rs.getString("rr_pNum"));
				renter_renting.setRr_license(rs.getString("rr_license"));
				renter_renting.setRr_experience(rs.getString("rr_experience"));
				renter_renting.setUser_id(rs.getInt("user_id"));
			}
			
			//5. close connection
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return renter_renting;
	}
		
		
	//get all shawls
	public static List<Renter_renting> getAllUser(){
		List<Renter_renting> renter_rentings = new ArrayList<Renter_renting>();

		//complete the code here
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//3. create statement
			stmt = con.createStatement();
			String sql = "SELECT * FROM renter_renting ORDER BY rr_id";
			
			//4. execute query
			rs = stmt.executeQuery(sql);
			//process ResultSet and set the values to the Shawl object
			while(rs.next()) {
				Renter_renting renter_renting = new Renter_renting();
				renter_renting.setRr_id(rs.getInt("rr_id"));
				renter_renting.setRr_address(rs.getString("rr_address"));
				renter_renting.setRr_pNum(rs.getString("rr_pNum"));
				renter_renting.setRr_license(rs.getString("rr_license"));
				renter_renting.setRr_experience(rs.getString("rr_experience"));
				renter_renting.setUser_id(rs.getInt("user_id"));
				renter_rentings.add(renter_renting);
			}
			
			//5. close connection
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return renter_rentings;
	}
	
	

	
	
}