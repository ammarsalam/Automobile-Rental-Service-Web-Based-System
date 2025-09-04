package booking.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import rent.dao.BookingDAO;
import rent.dao.CarDAO;
import rent.model.Booking;
import rent.model.Car;
import rent.model.User;
import rent.dao.BridgeDAO;
import rent.model.Bridge;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet implementation class addBookingController
 */
public class addBookingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addBookingController() {
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
		//create booking object
		Booking booking=new Booking();
		
		//retrieve input from HTML and set the values to the booking object
	    booking.setBooking_date(request.getParameter("bookingDate"));
	    booking.setPickup_location(request.getParameter("pickupLocation"));
	    booking.setDrop_location(request.getParameter("dropLocation"));
	    booking.setRr_id(Integer.parseInt(request.getParameter("rr_id")));
	    booking.setBooking_days(Integer.parseInt(request.getParameter("booking_days")));
	    booking.setCar_id(Integer.parseInt(request.getParameter("car_id")));
	    double totalPrice=CarDAO.getPrice(booking.getCar_id())*booking.getBooking_days();
	    booking.setTotal_price(totalPrice);
	    
	    
		//call addBooking() from BookingDAO class
	    try {
	        BookingDAO.addBooking(booking);
	    }
	    catch(SQLException e) { 
	        e.printStackTrace();
	    }
	    CarDAO.updateCarAvailability();
		//set attribute to a servlet request. Set the attribute name to bookings and call getAllBooking() from BookingDAO class
	    request.setAttribute("bridge", BookingDAO.getBooking(BookingDAO.getLatestBookingID()));
		
		//Obtain the RequestDispatcher from the request object. The pathname to the resource is listShawl.jsp
	    RequestDispatcher req=request.getRequestDispatcher("paymentDetailsController");
		
		//Dispatch the request to another resource using forward() methods of the RequestDispatcher
	    req.forward(request, response);
	}

}