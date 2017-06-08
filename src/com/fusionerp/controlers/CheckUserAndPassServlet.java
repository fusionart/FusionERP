package com.fusionerp.controlers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fusionerp.models.CheckUserAndPass;

/**
 * Servlet implementation class CheckUserAndPass
 */
@WebServlet("/CheckUserAndPassServlet")
public class CheckUserAndPassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CheckUserAndPass checkUserPass = new CheckUserAndPass();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckUserAndPassServlet() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Boolean isTrue = checkUserPass.checkUserAndPass(username, password);

		if (isTrue) {
			RequestDispatcher redirect = request.getRequestDispatcher("/WEB-INF/JSPs/mainMenu.jsp");
			redirect.forward(request, response);
		} else {
			request.setAttribute("message", "��������� ����");
			RequestDispatcher view = request.getRequestDispatcher("index.jsp");
			view.forward(request, response);
		}
	}

}
