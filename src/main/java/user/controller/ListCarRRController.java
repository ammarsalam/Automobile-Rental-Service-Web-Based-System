package user.controller;

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
import jakarta.servlet.http.HttpSession;
import rent.connection.ConnectionManager;
import rent.dao.BridgeDAO;	
import rent.dao.CarDAO;
import rent.model.Car;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class ListCarController
 */
public class ListCarRRController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListCarRRController() {
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
        
        // Check if user_id is not null
        if (user_id != null) {
            // Set attribute to a servlet request. Set the attribute name to rr and call getUserProfile() from BridgeDAO class
            request.setAttribute("cars", CarDAO.getEveryRRCar(user_id));

            // Obtain the RequestDispatcher from the request object. The pathname to the resource is profile.jsp
            RequestDispatcher req = request.getRequestDispatcher("listCarRR.jsp");

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
		doGet(request, response);
	}

}