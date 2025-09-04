package admin.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import rent.dao.AdminDAO;
import java.io.IOException;
import java.sql.SQLException;

public class loginAdminController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public loginAdminController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward the request to loginPage.html (assuming you have this page)
     
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve user input from the login form
        String user_name = request.getParameter("admin_name");
        String user_password = request.getParameter("admin_password");

        // Validate user credentials
        boolean isValidUser = false;
        try {
            isValidUser = AdminDAO.validateUser(user_name, user_password);
        } catch (SQLException e) {
            // Handle the SQLException appropriately (e.g., log the error)
            e.printStackTrace(); // This should be replaced with proper error handling
        }

        if (isValidUser) {
            // If credentials are valid, redirect to homePage.html
        	RequestDispatcher req=request.getRequestDispatcher("DashboardController");
            req.forward(request, response);
        } else {
            // If credentials are invalid, redirect back to loginPage.html (with an error message if needed)
            RequestDispatcher req = request.getRequestDispatcher("loginAdmin.html");
            // You can set an error attribute on the request to display an error message on the login page
            request.setAttribute("errorMessage", "Invalid login credentials");
            req.forward(request, response);
        }
    }


   
}