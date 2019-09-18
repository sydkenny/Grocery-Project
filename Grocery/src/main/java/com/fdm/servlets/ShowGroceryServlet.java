package com.fdm.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdm.model.Grocery;
import com.fdm.model.GroceryDao;



public class ShowGroceryServlet extends HttpServlet {
	
	private static final long serialVersionUID = -3065773948210900540L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("oracleDBconnect");
		GroceryDao groceryDao = new GroceryDao(emf);

		List<Grocery> groceries = groceryDao.getAll();
		request.setAttribute("groceries", groceries);
		PrintWriter pr = response.getWriter();
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/ShowGroceries.jsp");
		 
		try {
			requestDispatcher.forward(request, response);
		} catch (ServletException e) {
			ExceptionHandler.printExceptionMessage(request, response, e, pr);
		}
	}


}
