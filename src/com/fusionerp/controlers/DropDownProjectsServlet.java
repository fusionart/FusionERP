package com.fusionerp.controlers;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fusionerp.models.DropDownMenuProject;
import com.google.gson.Gson;

/**
 * Servlet implementation class DropDownProjectsServlet
 */
@WebServlet("/DropDownProjectsServlet")
public class DropDownProjectsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DropDownMenuProject ddm = new DropDownMenuProject(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DropDownProjectsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> projects = ddm.dropDownMenu();
		String jsonG = new Gson().toJson(projects);
		response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(jsonG); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
