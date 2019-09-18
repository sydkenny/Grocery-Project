package com.fdm.servlets;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// nothing
public class ExceptionHandler {

	public static void printExceptionMessage(HttpServletRequest request, HttpServletResponse response, ServletException e, PrintWriter pr) {
		System.out.println("ServletException - " + e.getMessage());

		pr.println("<html>"
				+ "<head>"
				+ "<title>"
				+ "</title>"
				+ "</head>"
				+ "<body>"
				+ "<h1>ServletException</h1>"
				+ "<h1>Megan's code...</h1>"
				+ "<p>Encountered ServletException - " + e.getMessage() + "</p>"
				+ "</body>"
				+ "</html>");
	}

}
