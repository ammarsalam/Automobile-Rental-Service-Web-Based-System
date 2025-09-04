package rent.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import rent.connection.ConnectionManager;
import rent.model.Car;


public class CarDAO {

	private static Connection con = null;
	private static PreparedStatement ps = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	private int car_id, no_of_seats,rr_id;
	private double price_per_day;
	private String car_type, car_brand, car_model, car_color, availability, car_plate;
	private String sql;
		
	
	//insert car
		public static void addCar(Car car) throws SQLException{
			
			//complete the code here
			try {
				//call getConnection() method
				con = ConnectionManager.getConnection();
				
				//3. create statement
				String sql = "INSERT INTO cars(car_type,car_brand,car_model,car_color,no_of_seats,availability,price_per_day,rr_id,car_plate,ownerBusy)VALUES(?,?,?,?,?,?,?,?,?,?)";
				ps = con.prepareStatement(sql);
				//get values from Shawl object and set parameter values
				ps.setString(1, car.getCar_type());
				ps.setString(2, car.getCar_brand());
				ps.setString(3, car.getCar_model());
				ps.setString(4, car.getCar_color());
				ps.setInt(5, car.getNo_of_seats());
				ps.setString(6, car.getAvailability());
				ps.setDouble(7, car.getPrice_per_day());
				ps.setInt(8, car.getRr_id());
				ps.setString(9, car.getCar_plate());
				ps.setString(10, car.getOwnerBusy());
				
				//4. execute query
				ps.executeUpdate();
				
				//5. close connection
				con.close();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		//update car
		public static void updateCar(Car car) throws SQLException{
			//complete the code here
			try {
				//call getConnection() method
				con = ConnectionManager.getConnection();
				
				//3. create statement and get the values from Shawl object
				String sql = "UPDATE cars SET car_type=?,car_brand=?,car_model=?,car_color=?,no_of_seats=?,availability=?,price_per_day=?,car_plate=?,rr_id=?,ownerBusy=? WHERE car_id=?";
				ps = con.prepareStatement(sql);
				//get values from Shawl object and set parameter values
				ps.setString(1, car.getCar_type());
				ps.setString(2, car.getCar_brand());
				ps.setString(3, car.getCar_model());
				ps.setString(4, car.getCar_color());
				ps.setInt(5, car.getNo_of_seats());
				ps.setString(6, car.getAvailability());
				ps.setDouble(7,car.getPrice_per_day());
				ps.setString(8, car.getCar_plate());
				ps.setInt(9,car.getRr_id());
				ps.setString(10, car.getOwnerBusy());
		        ps.setInt(11, car.getCar_id());
				
				
				//4. execute query
				ps.executeUpdate();
				
				//5. close connection
				con.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		public static void updateCarAvailability() {
			try {
				//call getConnection() method
				con = ConnectionManager.getConnection();
				
				//3. create statement and get the values from Shawl object
				String sql = "UPDATE cars c LEFT JOIN (SELECT b.car_id, b.booking_date, b.end_date FROM booking b INNER JOIN (SELECT car_id, MAX(booking_date) AS latest_booking_date FROM booking GROUP BY car_id) lb ON b.car_id = lb.car_id AND b.booking_date = lb.latest_booking_date) AS latest_booking ON c.car_id = latest_booking.car_id SET c.availability = CASE WHEN latest_booking.car_id IS NULL THEN 'Available' WHEN DATE(NOW()) + INTERVAL 1 DAY BETWEEN latest_booking.booking_date AND latest_booking.end_date THEN 'Unavailable' ELSE 'Available' END;";
				ps = con.prepareStatement(sql);
				//get values from Shawl object and set parameter values
				
				
				
				//4. execute query
				ps.executeUpdate();
				
				//5. close connection
				con.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		//delete car
		public static void deleteCar(int car_id) throws SQLException{
			//complete the code here
			try {
				//call getConnection() method
				con = ConnectionManager.getConnection();
				
				//3. create statement
				String sql = "DELETE FROM cars WHERE car_id=?";
				ps = con.prepareStatement(sql);
				//set parameter values
				ps.setInt(1, car_id);
				
				//4. execute query
				ps.executeUpdate();
				
				//5. close connection
				con.close();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
public static Double getPrice(int car_id) {
			double totalPrice=0;
			
			//complete the code here
			try {
				//call getConnection() method
				con = ConnectionManager.getConnection();
				
				//3. create statement
				String sql = "SELECT price_per_day FROM cars WHERE car_id = ?;";
				ps = con.prepareStatement(sql);
				//set parameter values
				ps.setInt(1, car_id);
				
				//4. execute query
				rs = ps.executeQuery();
				//process ResultSet and set the values to the Shawl object
				if(rs.next()) {
					
					totalPrice=rs.getDouble("price_per_day");
					
					
				}
				
				//5. close connection
				con.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return totalPrice;
		}
		//get car by id
		public static Car getCar(int car_id) {
			
			Car car= new Car();
			
			//complete the code here
			try {
				//call getConnection() method
				con = ConnectionManager.getConnection();
				
				//3. create statement
				String sql = "SELECT * FROM cars WHERE car_id=?";
				ps = con.prepareStatement(sql);
				//set parameter values
				ps.setInt(1, car_id);
				
				//4. execute query
				rs = ps.executeQuery();
				//process ResultSet and set the values to the Shawl object
				if(rs.next()) {
					car.setCar_id(rs.getInt("car_id"));
					car.setCar_type(rs.getString("car_type"));
					car.setCar_brand(rs.getString("car_brand"));
					car.setCar_model(rs.getString("car_model"));
					car.setCar_color(rs.getString("car_color"));
					car.setNo_of_seats(rs.getInt("no_of_seats"));
					car.setAvailability(rs.getString("availability"));
					car.setPrice_per_day(rs.getDouble("price_per_day"));
					car.setRr_id(rs.getInt("rr_id"));
					car.setCar_plate(rs.getString("car_plate"));
					car.setOwnerBusy(rs.getString("ownerBusy"));
				}
				
				//5. close connection
				con.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return car;
		}
		
	//get all cars
	public static List<Car> getAllCars(){
		List<Car> cars = new ArrayList<Car>();

		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
				
			//3. create statement
			stmt = con.createStatement();
			String sql = "SELECT * FROM cars";
			
			//4. execute query
			rs = stmt.executeQuery(sql);
			//process ResultSet and set the values to the Car object
			while(rs.next()) {
				Car car = new Car();
				car.setCar_id(rs.getInt("car_id"));
				car.setCar_type(rs.getString("car_type"));
				car.setCar_brand(rs.getString("car_brand"));
				car.setCar_model(rs.getString("car_model"));
				car.setCar_color(rs.getString("car_color"));
				car.setNo_of_seats(rs.getInt("no_of_seats"));
				car.setAvailability(rs.getString("availability"));
				car.setPrice_per_day(rs.getDouble("price_per_day"));
				car.setRr_id(rs.getInt("rr_id"));
				car.setCar_plate(rs.getString("car_plate"));
				car.setOwnerBusy(rs.getString("ownerBusy"));
				cars.add(car);
			}
				
			//5. close connection
			con.close();
				
		}catch(Exception e) {
			e.printStackTrace();
		}
			
		return cars;
	}
	
	//get all bezza 
	public static List<Car> getAllBezza(int rr_id){
		List<Car> cars = new ArrayList<Car>();

		try {
			//call getConnection() method
			

			con = ConnectionManager.getConnection();
			//3. create statement
			stmt = con.createStatement();
			String sql = "SELECT * FROM cars WHERE rr_id != ? AND car_model = 'Bezza'";
			ps = con.prepareStatement(sql);
			ps.setInt(1, rr_id);
			//4. execute query
			rs = ps.executeQuery();
			//process ResultSet and set the values to the Car object
			while(rs.next()) {
				Car car = new Car();
				car.setCar_id(rs.getInt("car_id"));
				car.setCar_type(rs.getString("car_type"));
				car.setCar_brand(rs.getString("car_brand"));
				car.setCar_model(rs.getString("car_model"));
				car.setCar_color(rs.getString("car_color"));
				car.setNo_of_seats(rs.getInt("no_of_seats"));
				car.setAvailability(rs.getString("availability"));
				car.setPrice_per_day(rs.getDouble("price_per_day"));
				car.setRr_id(rs.getInt("rr_id"));
				car.setOwnerBusy(rs.getString("ownerBusy"));
				
				
				cars.add(car);
			}
			
			//5. close connection
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return cars;
	}
	
	//get all Myvi
	public static List<Car> getAllMyvi(int rr_id){
		List<Car> cars = new ArrayList<Car>();

		try {
			//call getConnection() method
			

			con = ConnectionManager.getConnection();
			//3. create statement
			stmt = con.createStatement();
			String sql = "SELECT * FROM cars WHERE rr_id != ? AND car_model = 'Myvi'";
			ps = con.prepareStatement(sql);
			ps.setInt(1, rr_id);
			//4. execute query
			rs = ps.executeQuery();
			//process ResultSet and set the values to the Car object
			while(rs.next()) {
				Car car = new Car();
				car.setCar_id(rs.getInt("car_id"));
				car.setCar_type(rs.getString("car_type"));
				car.setCar_brand(rs.getString("car_brand"));
				car.setCar_model(rs.getString("car_model"));
				car.setCar_color(rs.getString("car_color"));
				car.setNo_of_seats(rs.getInt("no_of_seats"));
				car.setAvailability(rs.getString("availability"));
				car.setPrice_per_day(rs.getDouble("price_per_day"));
				car.setRr_id(rs.getInt("rr_id"));
				car.setOwnerBusy(rs.getString("ownerBusy"));
				
				
				cars.add(car);
			}
			
			//5. close connection
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return cars;
	} 
	
	// get all Axia
	
	
	// get all kancil
	public static List<Car> getAllKancil(int rr_id){
		List<Car> cars = new ArrayList<Car>();

		try {
			//call getConnection() method
			

			con = ConnectionManager.getConnection();
			//3. create statement
			stmt = con.createStatement();
			String sql = "SELECT * FROM cars WHERE rr_id != ? AND car_model = 'Kancil'";
			ps = con.prepareStatement(sql);
			ps.setInt(1, rr_id);
			//4. execute query
			rs = ps.executeQuery();
			//process ResultSet and set the values to the Car object
			while(rs.next()) {
				Car car = new Car();
				car.setCar_id(rs.getInt("car_id"));
				car.setCar_type(rs.getString("car_type"));
				car.setCar_brand(rs.getString("car_brand"));
				car.setCar_model(rs.getString("car_model"));
				car.setCar_color(rs.getString("car_color"));
				car.setNo_of_seats(rs.getInt("no_of_seats"));
				car.setAvailability(rs.getString("availability"));
				car.setPrice_per_day(rs.getDouble("price_per_day"));
				car.setRr_id(rs.getInt("rr_id"));
				car.setOwnerBusy(rs.getString("ownerBusy"));
				
				
				cars.add(car);
			}
			
			//5. close connection
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return cars;
	}
	
	//get all persona
	public static List<Car> getAllPersona(int rr_id){
		List<Car> cars = new ArrayList<Car>();

		try {
			//call getConnection() method
			

			con = ConnectionManager.getConnection();
			//3. create statement
			stmt = con.createStatement();
			String sql = "SELECT * FROM cars WHERE rr_id != ? AND car_model = 'Persona'";
			ps = con.prepareStatement(sql);
			ps.setInt(1, rr_id);
			//4. execute query
			rs = ps.executeQuery();
			//process ResultSet and set the values to the Car object
			while(rs.next()) {
				Car car = new Car();
				car.setCar_id(rs.getInt("car_id"));
				car.setCar_type(rs.getString("car_type"));
				car.setCar_brand(rs.getString("car_brand"));
				car.setCar_model(rs.getString("car_model"));
				car.setCar_color(rs.getString("car_color"));
				car.setNo_of_seats(rs.getInt("no_of_seats"));
				car.setAvailability(rs.getString("availability"));
				car.setPrice_per_day(rs.getDouble("price_per_day"));
				car.setRr_id(rs.getInt("rr_id"));
				car.setOwnerBusy(rs.getString("ownerBusy"));
				
				
				cars.add(car);
			}
			
			//5. close connection
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return cars;
	}
	
	//get all wira
	public static List<Car> getAllWira(int rr_id){
		List<Car> cars = new ArrayList<Car>();

		try {
			//call getConnection() method
			

			con = ConnectionManager.getConnection();
			//3. create statement
			stmt = con.createStatement();
			String sql = "SELECT * FROM cars WHERE rr_id != ? AND car_model = 'Wira'";
			ps = con.prepareStatement(sql);
			ps.setInt(1, rr_id);
			//4. execute query
			rs = ps.executeQuery();
			//process ResultSet and set the values to the Car object
			while(rs.next()) {
				Car car = new Car();
				car.setCar_id(rs.getInt("car_id"));
				car.setCar_type(rs.getString("car_type"));
				car.setCar_brand(rs.getString("car_brand"));
				car.setCar_model(rs.getString("car_model"));
				car.setCar_color(rs.getString("car_color"));
				car.setNo_of_seats(rs.getInt("no_of_seats"));
				car.setAvailability(rs.getString("availability"));
				car.setPrice_per_day(rs.getDouble("price_per_day"));
				car.setRr_id(rs.getInt("rr_id"));
				car.setOwnerBusy(rs.getString("ownerBusy"));
				
				
				cars.add(car);
			}
			
			//5. close connection
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return cars;
	}
	
	public static List<Car> getAllAxia(int rr_id){
		List<Car> cars = new ArrayList<Car>();

		try {
			//call getConnection() method
			

			con = ConnectionManager.getConnection();
			//3. create statement
			stmt = con.createStatement();
			String sql = "SELECT * FROM cars WHERE rr_id != ? AND car_model = 'Axia'";
			ps = con.prepareStatement(sql);
			ps.setInt(1, rr_id);
			//4. execute query
			rs = ps.executeQuery();
			//process ResultSet and set the values to the Car object
			while(rs.next()) {
				Car car = new Car();
				car.setCar_id(rs.getInt("car_id"));
				car.setCar_type(rs.getString("car_type"));
				car.setCar_brand(rs.getString("car_brand"));
				car.setCar_model(rs.getString("car_model"));
				car.setCar_color(rs.getString("car_color"));
				car.setNo_of_seats(rs.getInt("no_of_seats"));
				car.setAvailability(rs.getString("availability"));
				car.setPrice_per_day(rs.getDouble("price_per_day"));
				car.setRr_id(rs.getInt("rr_id"));
				car.setOwnerBusy(rs.getString("ownerBusy"));
				
				
				cars.add(car);
			}
			
			//5. close connection
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return cars;
	}
	
	public static List<Car> getEveryRRCar(int rr_id){
		List<Car> cars = new ArrayList<Car>();

		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
				
			//3. create statement
			stmt = con.createStatement();
			String sql = "SELECT * FROM cars WHERE rr_id=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, rr_id);
			//4. execute query
			rs = ps.executeQuery();
			//process ResultSet and set the values to the Car object
			while(rs.next()) {
				Car car = new Car();
				car.setCar_id(rs.getInt("car_id"));
				car.setCar_type(rs.getString("car_type"));
				car.setCar_brand(rs.getString("car_brand"));
				car.setCar_model(rs.getString("car_model"));
				car.setCar_color(rs.getString("car_color"));
				car.setNo_of_seats(rs.getInt("no_of_seats"));
				car.setAvailability(rs.getString("availability"));
				car.setPrice_per_day(rs.getDouble("price_per_day"));
				car.setCar_plate(rs.getString("car_plate"));
				car.setRr_id(rs.getInt("rr_id"));
				car.setOwnerBusy(rs.getString("ownerBusy"));
				cars.add(car);
			}
				
			//5. close connection
			con.close();
				
		}catch(Exception e) {
			e.printStackTrace();
		}
			
		return cars;
	}
	
	
	
	
		
}