package booking.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import rent.dao.BookingDAO;
import rent.dao.CarDAO;
import rent.model.Booking;
import rent.model.Car;
import rent.model.User;

import rent.dao.UserDAO;
import rent.dao.BridgeDAO;
import rent.model.Bridge;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet implementation class addBookingController
 */
public class ConfirmBookingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmBookingController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
        
        // Retrieve user_id from the session
        Integer user_id = (Integer) session.getAttribute("user_id");
		Bridge bridge=new Bridge();
		
		//retrieve input from HTML and set the values to the booking object
	    
		//bridge.setUser_name(request.getParameter("user_name"));
		//bridge.setUser_password(request.getParameter("user_password"));
		bridge.setCar_id(Integer.parseInt(request.getParameter("car_id")));	
		
        
        // Check if user_id is not null
        if (user_id != null) {
            // Set attribute to a servlet request. Set the attribute name to rr and call getUserProfile() from BridgeDAO class
            request.setAttribute("bridge",BridgeDAO.storeConfirmDetails(user_id,bridge.getCar_id() ));
            request.setAttribute("user_id", user_id);

            // Obtain the RequestDispatcher from the request object. The pathname to the resource is profile.jsp
            RequestDispatcher req = request.getRequestDispatcher("bookingDetails.jsp");

            // Dispatch the request to another resource using forward() methods of the RequestDispatcher
            req.forward(request, response);
        } 
        else {
            // Redirect to login page if user_id is not found in session
            response.sendRedirect("loginPage.html");
        }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//create booking object
		
	    
	    doGet(request,response);
	}

}