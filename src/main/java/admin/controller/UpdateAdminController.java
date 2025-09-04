package admin.controller;

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
import rent.dao.AdminDAO;
import rent.dao.BridgeDAO;
import rent.model.Admin;
import rent.model.Bridge;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet implementation class UpdateAdminController
 */
public class UpdateAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateAdminController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//get id from input parameter
		int id=Integer.parseInt(request.getParameter("admin_id"));
		//set attribute to a servlet request. Set the attribute name to admins and call getAllAdmin() from AdminDAO class
		request.setAttribute("admin", AdminDAO.getAdmin(id));

		//Obtain the RequestDispatcher from the request object. The the pathname to the resource is index.html
		RequestDispatcher req=request.getRequestDispatcher("updateAdmin.jsp");

		//Dispatch the request to another resource using forward() methods of the RequestDispatcher
		req.forward(request, response);

	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//create Admin object
		Admin admin=new Admin();

		//retrieve input from HTML and set the values to the admin object
		admin.setAdmin_id(Integer.parseInt(request.getParameter("admin_id")));
		admin.setAdmin_address(request.getParameter("admin_address"));
		admin.setAdmin_pNum(request.getParameter("admin_pNum"));
		admin.setAdmin_title(request.getParameter("admin_title"));
		admin.setAdmin_department(request.getParameter("admin_department"));
		admin.setUser_id(Integer.parseInt(request.getParameter("user_id")));
		
		
		

		//call updateAdmin() from AdminDAO class
		try {
			AdminDAO.updateAdmin(admin);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//set attribute to a servlet request. Set the attribute name to admins and call getAllAdmin() from AdminDAO class
		request.setAttribute("bridges", BridgeDAO.AllAdminUserBridge());

		//Obtain the RequestDispatcher from the request object. The the pathname to the resource is index.html
		RequestDispatcher req=request.getRequestDispatcher("listOfAdmin.jsp");

		//Dispatch the request to another resource using forward() methods of the RequestDispatcher
		req.forward(request, response);
	}
}