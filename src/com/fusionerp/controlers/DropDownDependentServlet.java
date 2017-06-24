package com.fusionerp.controlers;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.fusionerp.models.DropDownCableColor;
import com.fusionerp.models.DropDownDependent;

/**
 * Servlet implementation class DropDownDependentServlet
 */
@WebServlet("/DropDownDependentServlet")
public class DropDownDependentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DropDownDependent ddd = new DropDownDependent();
	DropDownCableColor ddcc = new DropDownCableColor();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DropDownDependentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Object project = request.getParameter("project");
		Object cables = request.getParameter("colors");
		//System.out.println("pr "+project);
		//System.out.println("name "+request.getParameter("project"));
		//System.out.println("name "+request.getParameter("colors"));
		
		if (project!=null){
			int gr = Integer.valueOf((String) project);
			//System.out.println(gr);
			Map<String, String> groups = ddd.dropDownMenu(gr);
			String jsonG = new Gson().toJson(groups);
			response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(jsonG);
		}
		
		if (cables!=null){
			int col = Integer.valueOf((String) cables);
			Map<String, String> cablesColor = ddcc.dropDownMenu(col);
			String jsonC = new Gson().toJson(cablesColor);
			response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(jsonC);
		}

		
//		request.setAttribute("groups", groups);
//		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/JSPs/cable.jsp");
//		view.forward(request, response);

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
