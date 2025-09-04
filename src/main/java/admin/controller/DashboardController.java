package admin.controller;

/*
 * Author: FES 
 * March 2024
 */

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import rent.dao.DashboardDAO;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet implementation class ListAdminController
 */
public class DashboardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DashboardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//set attribute to a servlet request. Set the attribute name to admin and call getAllAdmin() from AdminDAO class
		try {
			request.setAttribute("dashboard", DashboardDAO.getDashboard());	//Obtain the RequestDispatcher from the request object. The the pathname to the resource is index.html
			request.setAttribute("dashboards", DashboardDAO.getAllTopCar());
			request.setAttribute("dashboardss", DashboardDAO.getAllTopModel());
			RequestDispatcher req=request.getRequestDispatcher("Dashboard.jsp");
							
			//Dispatch the request to another resource using forward() methods of the RequestDispatcher
			req.forward(request, response);
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}							
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	
}