package car.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;


public class rentOutCarController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public rentOutCarController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer user_id = (Integer) session.getAttribute("user_id");

        if (user_id != null) {
            //response.sendRedirect("login.jsp"); // Redirect to login if user is not logged in
        	request.setAttribute("user_id", user_id);
            RequestDispatcher req = request.getRequestDispatcher("rentOut.jsp");
            req.forward(request, response);
        }
        else {
            // Redirect to login page if user_id is not found in session
            response.sendRedirect("loginPage.html");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
