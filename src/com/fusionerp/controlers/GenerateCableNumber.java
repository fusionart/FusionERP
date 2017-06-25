package com.fusionerp.controlers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GenerateCableNumber
 */
@WebServlet("/GenerateCableNumber")
public class GenerateCableNumber extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenerateCableNumber() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Object category = request.getParameter("category");
		Object projectGroup = request.getParameter("projectGroup");
		Object project = request.getParameter("project");
		Object nextOperation = request.getParameter("nextoperation");
		Object moq = request.getParameter("moq");
		
		
		
		
		
		
		
		
		int gr1 = Integer.valueOf((String) project);
		int gr = Integer.valueOf((String) projectGroup);
		System.out.println("name "+request.getParameter("project")+" / "+request.getParameter("category"));
		System.out.println("moq "+request.getParameter("moq"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
