package car.controller;

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
import rent.dao.CarDAO;
import rent.model.Car;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet implementation class deleteCarController
 */
public class deleteCarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteCarController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//get id from input parameter
		int id=Integer.parseInt(request.getParameter("car_id"));
		
		//call deleteCar() from CarDAO class
		try {
			CarDAO.deleteCar(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		//set attribute to a servlet request. Set the attribute name to cars and call getAllCars() from CarDAO class
		request.setAttribute("cars", CarDAO.getAllCars());
				
		//Obtain the RequestDispatcher from the request object. The the pathname to the resource is index.html
		RequestDispatcher req=request.getRequestDispatcher("listOfCar.jsp");
						
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
