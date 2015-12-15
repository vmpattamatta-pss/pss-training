package com.sample.training;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcQueryServlet
 */
@WebServlet("/calcHtml")
public class CalcQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CalcQueryServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer intA = Integer.parseInt(request.getParameter("inpA"));
		Integer intB = Integer.parseInt(request.getParameter("inpB"));
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
