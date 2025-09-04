package rent.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import rent.connection.ConnectionManager;
import rent.model.User;

public class UserDAO {

	private static Connection con = null;
	private static PreparedStatement ps = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	private int user_id;
	private String user_name, user_password, user_address, user_pNum, user_email, user_license,user_experience;
	private String sql;
	
	
	//insert shawl
	public static void addUser(User user) throws SQLException{
		
		//complete the code here
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//3. create statement
			String sql = "INSERT INTO user(user_name, user_password, user_email,user_role)VALUES(?,?,?,?)";
			ps = con.prepareStatement(sql);
			//get values from Shawl object and set parameter values
			ps.setString(1, user.getUser_name());
			ps.setString(2, user.getUser_password());
			ps.setString(3, user.getUser_email());
			ps.setString(4, user.getUser_role());
			
			//4. execute query
			ps.executeUpdate();
			
			//5. close connection
			con.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}	
		
		
	//update shawl
	public static void updateUser(User user) throws SQLException{
		//complete the code here
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//3. create statement and get the values from Shawl object
			String sql = "UPDATE user SET user_name=?,user_password=?,user_email=?,user_email=?,user_role=? WHERE user_id=?";
			ps = con.prepareStatement(sql);
			//get values from Shawl object and set parameter values
			ps.setString(1, user.getUser_name());
			ps.setString(2, user.getUser_password());
			ps.setString(3, user.getUser_email());
			ps.setString(4, user.getUser_role());
			ps.setInt(5, user.getUser_id());
			
			//4. execute query
			ps.executeUpdate();
			
			//5. close connection
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}	
		
		
	//delete shawl
	public static void deleteUser(int user_id) throws SQLException{
		//complete the code here
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//3. create statement
			String sql = "DELETE FROM user WHERE user_id=?";
			ps = con.prepareStatement(sql);
			//set parameter values
			ps.setInt(1, user_id);
			
			//4. execute query
			ps.executeUpdate();
			
			//5. close connection
			con.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
		
		
	//get user by id
	public static User getUser(int user_id) {
		
		User user = new User();
		
		//complete the code here
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//3. create statement
			String sql = "SELECT * FROM user WHERE user_id=?";
			ps = con.prepareStatement(sql);
			//set parameter values
			ps.setInt(1, user_id);
			
			//4. execute query
			rs = ps.executeQuery();
			//process ResultSet and set the values to the Shawl object
			if(rs.next()) {
				user.setUser_id(rs.getInt("user_id"));
				user.setUser_name(rs.getString("user_name"));
				user.setUser_password(rs.getString("user_password"));
				user.setUser_email(rs.getString("user_email"));
				user.setUser_role(rs.getString("user_role"));
				}
			
			//5. close connection
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}
		
		
	//get all shawls
	public static List<User> getAllUser(){
		List<User> users = new ArrayList<User>();

		//complete the code here
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//3. create statement
			stmt = con.createStatement();
			String sql = "SELECT * FROM user ORDER BY user_id";
			
			//4. execute query
			rs = stmt.executeQuery(sql);
			//process ResultSet and set the values to the Shawl object
			while(rs.next()) {
				User user = new User();
				user.setUser_id(rs.getInt("user_id"));
				user.setUser_name(rs.getString("user_name"));
				user.setUser_password(rs.getString("user_password"));
				user.setUser_email(rs.getString("user_email"));
				user.setUser_role(rs.getString("user_role"));
				users.add(user);
			}
			
			//5. close connection
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return users;
	}
	
	public static boolean validateUser(String user_name, String user_password) throws SQLException {
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
    }
	
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
}