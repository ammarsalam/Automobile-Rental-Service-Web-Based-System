package admin.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import rent.dao.UserDAO;
import rent.model.User;
import rent.dao.BridgeDAO;
import rent.model.Bridge;


import java.io.IOException;
import java.sql.SQLException;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet implementation class AddUserController
 */
public class AddAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAdminController() {
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
				User user=new User();
				
				//retrieve input from HTML and set the values to the Shawl object
				user.setUser_name(request.getParameter("user_name"));
			    user.setUser_email(request.getParameter("user_email"));
			    user.setUser_password(request.getParameter("user_password"));
			    user.setUser_role(request.getParameter("user_role"));
				
				//call addUser() from UserDAO class
			    try {
			        UserDAO.addUser(user);
			    }
			    catch(SQLException e) {
			        e.printStackTrace();
			    }
				
				//set attribute to a servlet request. Set the attribute name to users and call getAllUser() from UserDAO class
			    request.setAttribute("bridges", BridgeDAO.AllAdminUserBridge());
				
				//Obtain the RequestDispatcher from the request object. The pathname to the resource is listShawl.jsp
			    RequestDispatcher req=request.getRequestDispatcher("listOfAdmin.jsp");
				
				//Dispatch the request to another resource using forward() methods of the RequestDispatcher
			    req.forward(request, response);
	}

}
