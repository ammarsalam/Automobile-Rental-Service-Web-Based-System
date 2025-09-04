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

public class AdminDAO {

	private static Connection con = null;
	private static PreparedStatement ps = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	private int admin_id;
	private String admin_address;
	private String admin_pNum;
	private String admin_title;
	private String admin_department;	;
	private String user_id;
	private String sql;
		
	//update shawl
	public static void updateAdmin(Admin admin) throws SQLException{
		//complete the code here
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//3. create statement and get the values from Shawl object
			String sql = "UPDATE admin SET admin_address=?,admin_pNum=?,admin_title=?,admin_department=?,user_id=? WHERE admin_id=?";
			ps = con.prepareStatement(sql);
			//get values from Shawl object and set parameter values
			
			ps.setString(1, admin.getAdmin_address());
			ps.setString(2, admin.getAdmin_pNum());
			ps.setString(3, admin.getAdmin_title());
			ps.setString(4,admin.getAdmin_department());
			ps.setInt(5, admin.getUser_id());
			ps.setInt(6, admin.getAdmin_id());
			
			
			//4. execute query
			ps.executeUpdate();
			
			//5. close connection
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}	
		
		
	//delete admin
	public static void deleteAdmin(int admin_id) throws SQLException{
		//complete the code here
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//3. create statement
			String sql = "DELETE FROM admin WHERE admin_id=?";
			ps = con.prepareStatement(sql);
			//set parameter values
			ps.setInt(1, admin_id);
			
			//4. execute query
			ps.executeUpdate();
			
			//5. close connection
			con.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
		
		
	//get admin by id
	public static Admin getAdmin(int admin_id) {
		
		Admin admin= new Admin();
		
		//complete the code here
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//3. create statement
			String sql = "SELECT * FROM admin WHERE admin_id=?";
			ps = con.prepareStatement(sql);
			//set parameter values
			ps.setInt(1, admin_id);
			
			//4. execute query
			rs = ps.executeQuery();
			//process ResultSet and set the values to the Shawl object
			if(rs.next()) {
				admin.setAdmin_id(rs.getInt("admin_id"));
				admin.setAdmin_address(rs.getString("admin_address"));
				admin.setAdmin_pNum(rs.getString("admin_pNum"));
				admin.setAdmin_title(rs.getString("admin_title"));
				admin.setAdmin_department(rs.getString("admin_department"));
				admin.setUser_id(rs.getInt("user_id"));
			}
			
			//5. close connection
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return admin;
	}
		
		
	//get all 
	public static List<Admin> getAllAdmin(){
		List<Admin> admins= new ArrayList<Admin>();

		//complete the code here
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//3. create statement
			stmt = con.createStatement();
			String sql = "SELECT * FROM admin ";
			
			//4. execute query
			rs = stmt.executeQuery(sql);
			//process ResultSet and set the values to the Shawl object
			while(rs.next()) {
				Admin admin= new Admin();
				admin.setAdmin_id(rs.getInt("admin_id"));
				admin.setAdmin_address(rs.getString("admin_address"));
				admin.setAdmin_pNum(rs.getString("admin_pNum"));
				admin.setAdmin_title(rs.getString("admin_title"));
				admin.setAdmin_department(rs.getString("admin_department"));
				admin.setUser_id(rs.getInt("user_id"));
				admins.add(admin);
			}
			
			//5. close connection
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return admins;
	}
	
	public static boolean validateUser(String user_name, String user_password) throws SQLException {
        boolean isValidUser = false;

        try {
            con = ConnectionManager.getConnection();
            String sql = "SELECT u.user_name, u.user_password FROM admin a INNER JOIN user u ON a.user_id = u.user_id where user_name=? AND user_password = ?;";
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
}