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
import rent.model.Admin;
import rent.dao.BridgeDAO;
import rent.model.Bridge;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet implementation class DeleteShawlController
 */
public class DeleteAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAdminController() {
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
		
		//call deleteShawl() from ShawlDAO class
		try {
			AdminDAO.deleteAdmin(id);
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
