package com.fusionerp.controlers;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fusionerp.models.DropDownMenuCables;
import com.fusionerp.models.DropDownMenuProject;
import com.fusionerp.models.DropDownMenuSeals;
import com.fusionerp.models.DropDownMenuTerminals;

/**
 * Servlet implementation class DropDownMenuServlet
 */
@WebServlet("/DropDownMenuServlet")
public class DropDownMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DropDownMenuProject ddm = new DropDownMenuProject();
	DropDownMenuCables ddmc = new DropDownMenuCables();
	DropDownMenuTerminals ddmt = new DropDownMenuTerminals();
	DropDownMenuSeals ddms = new DropDownMenuSeals();
       
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
		Map<String, String> dropMenu = ddm.dropDownMenu();
		request.setAttribute("dropMenu", dropMenu);
		Map<String, String> dropMenuCables = ddmc.dropDownMenuCables();
		request.setAttribute("dropMenuCables", dropMenuCables);
		Map<String, String> dropMenuTerminals = ddmt.dropDownMenu();
		request.setAttribute("dropMenuTerminals", dropMenuTerminals);
		Map<String, String> dropMenuSeals = ddms.dropDownMenu();
		request.setAttribute("dropMenuSeals", dropMenuSeals);
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
