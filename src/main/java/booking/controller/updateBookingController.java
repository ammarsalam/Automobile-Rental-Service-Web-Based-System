package booking.controller;

/*
 * Author: FES 
 * March 2024
 */

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import rent.dao.BookingDAO;
import rent.model.Booking;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet implementation class UpdateBookingController
 */
public class updateBookingController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public updateBookingController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//get id from input parameter
		int id=Integer.parseInt(request.getParameter("booking_id"));
		//set attribute to a servlet request. Set the attribute name to bookings and call getAllBooking() from BookingDAO class
		request.setAttribute("booking", BookingDAO.getBooking(id));

		//Obtain the RequestDispatcher from the request object. The the pathname to the resource is index.html
		RequestDispatcher req=request.getRequestDispatcher("updateBooking.jsp");

		//Dispatch the request to another resource using forward() methods of the RequestDispatcher
		req.forward(request, response);

	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//create Booking object
		Booking booking=new Booking();

		//retrieve input from HTML and set the values to the booking object
		booking.setBooking_id(Integer.parseInt(request.getParameter("booking_id")));
		booking.setBooking_date(request.getParameter("booking_date"));
		booking.setEnd_date(request.getParameter("end_date"));
		
		booking.setPickup_location(request.getParameter("pickup_location"));
		booking.setDrop_location(request.getParameter("drop_location"));
		booking.setRr_id(Integer.parseInt(request.getParameter("rr_id")));
		booking.setCar_id(Integer.parseInt(request.getParameter("car_id")));
		
		
		

		//call updateBooking() from BookingDAO class
		try {
			BookingDAO.updateBooking(booking);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//set attribute to a servlet request. Set the attribute name to bookings and call getAllBooking() from BookingDAO class
		request.setAttribute("bookings", BookingDAO.getAllBooking());

		//Obtain the RequestDispatcher from the request object. The the pathname to the resource is index.html
		RequestDispatcher req=request.getRequestDispatcher("listOfBooking.jsp");

		//Dispatch the request to another resource using forward() methods of the RequestDispatcher
		req.forward(request, response);
	}
}

