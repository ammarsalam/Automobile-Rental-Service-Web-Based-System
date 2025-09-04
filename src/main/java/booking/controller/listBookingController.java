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

import rent.connection.ConnectionManager;
import rent.dao.BookingDAO;
import rent.model.Booking;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class ListAdminController
 */
public class listBookingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listBookingController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		//set attribute to a servlet request. Set the attribute name to admin and call getAllAdmin() from AdminDAO class
				request.setAttribute("bookings", BookingDAO.getAllBooking());
						
				//Obtain the RequestDispatcher from the request object. The the pathname to the resource is index.html
				RequestDispatcher req=request.getRequestDispatcher("listOfBooking.jsp");
								
				//Dispatch the request to another resource using forward() methods of the RequestDispatcher
				req.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
