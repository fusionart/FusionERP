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
import com.google.gson.Gson;

/**
 * Servlet implementation class PopulateDropDownMenusServlet
 */
@WebServlet("/PopulateDropDownMenusServlet")
public class PopulateDropDownMenusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DropDownMenuProject ddm = new DropDownMenuProject();
	DropDownMenuCables ddmc = new DropDownMenuCables();
	DropDownMenuTerminals ddmt = new DropDownMenuTerminals();
	DropDownMenuSeals ddms = new DropDownMenuSeals();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PopulateDropDownMenusServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Object infoMenu = request.getParameter("infoMenu");
		Object project = request.getParameter("project");
		Object section = request.getParameter("section");
		Object terminal = request.getParameter("terminal");
		Object seal = request.getParameter("seal");

		if (infoMenu != null || project != null) {
			Map<String, String> projects = ddm.dropDownMenu();
			String jsonG = new Gson().toJson(projects);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(jsonG);
		}

		if (section != null) {
			Map<String, String> dropMenuCables = ddmc.dropDownMenuCables();
			String jsonG = new Gson().toJson(dropMenuCables);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(jsonG);
		}

		if (terminal != null) {
			Map<String, String> dropMenuTerminals = ddmt.dropDownMenu();
			String jsonG = new Gson().toJson(dropMenuTerminals);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(jsonG);
		}

		if (seal != null) {
			Map<String, String> dropMenuSeals = ddms.dropDownMenu();
			String jsonG = new Gson().toJson(dropMenuSeals);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(jsonG);
		}
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
