package com.sample.training;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcJspServlet
 */
public class CalcJspServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CalcJspServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer inpA = Integer.parseInt(request.getParameter("inpA"));
		Integer inpB = Integer.parseInt(request.getParameter("inpB"));
		Integer op = Integer.parseInt(request.getParameter("op"));
		Calculator cal = new Calculator(inpA, inpB, op);
		String opStr = "null";
		switch (op) {
		case 1:
			opStr = "Add";
			break;
		case 2:
			opStr = "Sub";
			break;
		case 3:
			opStr = "Mul";
			break;
		case 4:
			opStr = "Div";
			break;
		case 5:
			opStr = "Mod";
			break;
		}
		request.setAttribute("inpA", inpA);
		request.setAttribute("inpB", inpB);
		request.setAttribute("result", cal.calculate());
		request.setAttribute("opStr", opStr);
		// request.getServletContext().getRequestDispatcher("/calcJspRes.jsp").forward(request,
		// response);
		response.sendRedirect("/NayeemDay6/calcJspRes.jsp");
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
