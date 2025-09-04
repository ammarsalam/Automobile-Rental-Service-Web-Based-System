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
 * Servlet implementation class UpdateCarController
 */
public class updateCarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public updateCarController() {
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
		//set attribute to a servlet request. Set the attribute name to cars and call getAllAdmin() from AdminDAO class
		request.setAttribute("car", CarDAO.getCar(id));

		//Obtain the RequestDispatcher from the request object. The the pathname to the resource is index.html
		RequestDispatcher req=request.getRequestDispatcher("updateCar.jsp");
		//Dispatch the request to another resource using forward() methods of the RequestDispatcher
		req.forward(request, response);

	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//create Admin object
		Car car=new Car();

		//retrieve input from HTML and set the values to the admin object
		car.setCar_id(Integer.parseInt(request.getParameter("car_id")));
		car.setCar_plate(request.getParameter("car_plate"));
		car.setCar_brand(request.getParameter("car_brand"));
		car.setCar_model(request.getParameter("car_model"));
		car.setCar_type(request.getParameter("car_type"));
		car.setCar_color(request.getParameter("car_color"));
		car.setNo_of_seats(Integer.parseInt(request.getParameter("no_of_seats")));
		car.setPrice_per_day(Double.parseDouble(request.getParameter("price_per_day")));
		car.setAvailability(request.getParameter("availability"));
		car.setRr_id(Integer.parseInt(request.getParameter("rr_id")));
		car.setOwnerBusy(request.getParameter("ownerBusy"));

		//call updateCar() from CarDAO class
		try {
			CarDAO.updateCar(car);
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
}

