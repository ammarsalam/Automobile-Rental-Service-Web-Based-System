


package user.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import rent.dao.BridgeDAO;
import rent.dao.UserDAO;
import rent.model.User;

import java.io.IOException;
import java.sql.SQLException;

public class loginController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public loginController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward the request to loginPage.html (assuming you have this page)
        RequestDispatcher req = request.getRequestDispatcher("loginPage.html");
        req.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve user input from the login form
        String user_name = request.getParameter("user_name");
        String user_password = request.getParameter("user_password");

        try {
            // Validate user credentials and retrieve user ID
            int user_id = BridgeDAO.validateUser(user_name, user_password);

            if (user_id != -1) { // Assuming validateUser returns -1 if credentials are invalid
                // If credentials are valid, store the user ID in the session
                HttpSession session = request.getSession();
                session.setAttribute("user_id", user_id);
                session.setAttribute("user_name", user_name);

                // Redirect to homePage.html
                RequestDispatcher req = request.getRequestDispatcher("homePage.jsp");
                req.forward(request, response);
            } else {
                // If credentials are invalid, redirect back to loginPage.html with an error message
                RequestDispatcher req = request.getRequestDispatcher("loginPage.jsp");
                request.setAttribute("errorMessage", "Wrong Username or Password");
                req.forward(request, response);
            }
        } catch (SQLException e) {
            // Handle the SQLException appropriately 
            e.printStackTrace();
            // Set an error message and forward to an error page
            request.setAttribute("errorMessage", "Database error, please try again later.");
            RequestDispatcher req = request.getRequestDispatcher("loginPage.html");
            req.forward(request, response);
        }
    }
}

