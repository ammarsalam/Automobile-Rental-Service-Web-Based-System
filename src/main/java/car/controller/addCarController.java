package car.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import rent.dao.CarDAO;
import rent.dao.UserDAO;
import rent.model.Car;
import rent.model.User;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet implementation class addCarController
 */
public class addCarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addCarController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//create Shawl object
		Car car=new Car();
		
		//retrieve input from HTML and set the values to the car object
	    car.setCar_type(request.getParameter("carType"));
	    car.setCar_brand(request.getParameter("carBrand"));
	    car.setCar_model(request.getParameter("carModel"));
	    car.setCar_color(request.getParameter("carColor"));
	    car.setNo_of_seats(Integer.parseInt(request.getParameter("noSeat")));
	    car.setAvailability(request.getParameter("availability"));
	    car.setPrice_per_day(Double.parseDouble(request.getParameter("pricePerDay")));
	    car.setRr_id(Integer.parseInt(request.getParameter("userID")));
	    car.setCar_plate(request.getParameter("carPlate"));
	    car.setOwnerBusy(request.getParameter("ownerBusy"));
		
		//call addCar() from CarDAO class
	    try {
	        CarDAO.addCar(car);
	    }
	    catch(SQLException e) {
	        e.printStackTrace();
	    }
		
		//set attribute to a servlet request. Set the attribute name to shawls and call getAllShawls() from ShawlDAO class
	    request.setAttribute("cars", CarDAO.getAllCars());
		
		//Obtain the RequestDispatcher from the request object. The pathname to the resource is listShawl.jsp
	    RequestDispatcher req=request.getRequestDispatcher("homePage.jsp");
		
		//Dispatch the request to another resource using forward() methods of the RequestDispatcher
	    req.forward(request, response);
	}

}
