package payment.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import rent.dao.BookingDAO;
import rent.dao.BridgeDAO;

import java.io.IOException;

/**
 * Servlet implementation class makePaymentController
 */
public class makePaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public makePaymentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	request.setAttribute("bridge", BridgeDAO.getCarsBookingDetailsById(BookingDAO.getLatestBookingID()));

    	//Obtain the RequestDispatcher from the request object. The the pathname to the resource is index.html
    	RequestDispatcher req=request.getRequestDispatcher("paymentDetails.jsp");
		
    	//Dispatch the request to another resource using forward() methods of the RequestDispatcher
    	req.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
