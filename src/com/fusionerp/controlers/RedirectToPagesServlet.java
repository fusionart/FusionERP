package com.fusionerp.controlers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RedirectToPages
 */
@WebServlet("/RedirectToPages")
public class RedirectToPagesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RedirectToPagesServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// String createNew = request.getParameter("createNew");
		String infoMenu = request.getParameter("infoMenu");
		String buyPart = request.getParameter("buyPart");
		String cable = request.getParameter("cable");
		String twisted = request.getParameter("twisted");
		String splice = request.getParameter("splice");
		String registration = request.getParameter("registration");
		// System.out.println(registration);
		String backBtn = request.getParameter("backBtn");

		if (buyPart != null || twisted != null || splice != null) {
			RequestDispatcher redirect = request.getRequestDispatcher("/WEB-INF/HTML/underConstruction.html");
			redirect.forward(request, response);
		}

		if (infoMenu != null) {
			RequestDispatcher redirect = request.getRequestDispatcher("/WEB-INF/JSPs/informationMenu.jsp");
			redirect.forward(request, response);
		}

		if (cable != null) {
			RequestDispatcher redirect = request.getRequestDispatcher("/WEB-INF/JSPs/cable.jsp");
			redirect.forward(request, response);
		}

		if (registration != null) {
			RequestDispatcher redirect = request.getRequestDispatcher("/WEB-INF/JSPs/createNewUser.jsp");
			redirect.forward(request, response);
		}

		if (backBtn != null) {
			RequestDispatcher redirect = request.getRequestDispatcher("/WEB-INF/JSPs/mainMenu.jsp");
			redirect.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
