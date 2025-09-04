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
import rent.dao.BridgeDAO;
import rent.model.Bridge;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet implementation class UpdateCarController
 */
public class updateProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public updateProfileController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//get id from input parameter
		int rr_id=Integer.parseInt(request.getParameter("rr_id"));

		//set attribute to a servlet request. Set the attribute name to shawl and call getUserProfile() from BridgeDAO class
		request.setAttribute("bridge", BridgeDAO.getUserProfile(rr_id));

		//Obtain the RequestDispatcher from the request object. The pathname to the resource is updateProfile.jsp
		RequestDispatcher req=request.getRequestDispatcher("updateProfile.jsp");

		//Dispatch the request to another resource using forward() methods of the RequestDispatcher
		req.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//create Bridge object
		Bridge bridge=new Bridge();

		//retrieve input from HTML and set the values to the bridge object
		bridge.setRr_id(Integer.parseInt(request.getParameter("rr_id")));
		bridge.setUser_name(request.getParameter("user_name"));
		bridge.setUser_password(request.getParameter("user_password"));
		bridge.setUser_email(request.getParameter("user_email"));
		bridge.setRr_address(request.getParameter("rr_address"));
		bridge.setRr_pNum(request.getParameter("rr_pNum"));
		bridge.setRr_license(request.getParameter("rr_license"));
		bridge.setRr_experience(request.getParameter("rr_experience"));		

		//call updateCar() from CarDAO class
		try {
			BridgeDAO.updateProfile(bridge);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//set attribute to a servlet request. Set the attribute name to cars and call getAllCars() from CarDAO class
		//request.setAttribute("bridge", BridgeDAO.getAllUser());

		//Obtain the RequestDispatcher from the request object. The the pathname to the resource is index.html
		RequestDispatcher req=request.getRequestDispatcher("viewProfileController");

		//Dispatch the request to another resource using forward() methods of the RequestDispatcher
		req.forward(request, response);
	}
}

