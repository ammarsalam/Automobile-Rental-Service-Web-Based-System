package payment.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import rent.connection.ConnectionManager;
import rent.dao.AdminDAO;
import rent.dao.BookingDAO;
import rent.model.Admin;
import rent.dao.BridgeDAO;
import rent.model.Bridge;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Servlet implementation class ViewShawlController
 */
public class invoiceController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public invoiceController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//set attribute to a servlet request. Set the attribute name to session and call getSession() from HttpSession class
		//HttpSession session = request.getSession();
        
        // Retrieve user_id from the session
        //Integer user_id = (Integer) session.getAttribute("user_id");
        
        int payment_id = Integer.parseInt(request.getParameter("payment_id"));
        
        // Set attribute to a servlet request. Set the attribute name to rr and call getUserProfile() from BridgeDAO class
        request.setAttribute("bridges", BridgeDAO.viewInvoice(payment_id));
        request.setAttribute("user_id", payment_id);
        

        // Obtain the RequestDispatcher from the request object. The pathname to the resource is profile.jsp
        RequestDispatcher req = request.getRequestDispatcher("invoice.jsp");

        // Dispatch the request to another resource using forward() methods of the RequestDispatcher
        req.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}