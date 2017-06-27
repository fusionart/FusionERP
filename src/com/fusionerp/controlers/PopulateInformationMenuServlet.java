package com.fusionerp.controlers;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fusionerp.models.CableModel;
import com.fusionerp.models.PopulateInformationMenu;
import com.google.gson.Gson;

/**
 * Servlet implementation class PopulateInformationMenuServlet
 */
@WebServlet("/PopulateInformationMenuServlet")
public class PopulateInformationMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PopulateInformationMenu pim = new  PopulateInformationMenu();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PopulateInformationMenuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Object project = request.getParameter("project");
		
		if (project!=null){
			int gr = Integer.valueOf((String) project);
			List<CableModel> groups = pim.generateInfo(gr);
			String jsonG = new Gson().toJson(groups);
			response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(jsonG);
		    //System.out.println(jsonG.toString());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
