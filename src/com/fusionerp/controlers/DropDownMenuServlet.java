package com.fusionerp.controlers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fusionerp.models.DropDownMenu;

/**
 * Servlet implementation class DropDownMenuServlet
 */
@WebServlet("/DropDownMenuServlet")
public class DropDownMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DropDownMenu ddm = new DropDownMenu();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DropDownMenuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String project = request.getParameter("project");
		String dropMenu = ddm.dropDownMenu();
		request.setAttribute("dropMenu", dropMenu);
		System.out.println(dropMenu);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/JSPs/cable.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
