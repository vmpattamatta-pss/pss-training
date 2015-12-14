package com.sample.training;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public CalQueryServlet() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer intA = Integer.parseInt(request.getParameter("intA"));
		Integer intB = Integer.parseInt(request.getParameter("intB"));
		Integer op = Integer.parseInt(request.getParameter("op"));
		Calculator cal = new Calculator(intA, intB, op);
		response.getOutputStream()
				.print("<html><body><table><tr><td>Calculated Result ::</td><td>" + cal.calculate()
						+ "</td></tr><tr><td>Context Root</td><td>" + request.getContextPath()
						+ "</td></tr></table></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
