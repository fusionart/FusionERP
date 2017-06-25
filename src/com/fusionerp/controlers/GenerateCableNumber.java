package com.fusionerp.controlers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fusionerp.models.SetCableFieldValues;

import sun.security.action.GetBooleanAction;

/**
 * Servlet implementation class GenerateCableNumber
 */
@WebServlet("/GenerateCableNumber")
public class GenerateCableNumber extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SetCableFieldValues scfv = new SetCableFieldValues();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GenerateCableNumber() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String category = request.getParameter("category");
		int projectGroup = Integer.valueOf(request.getParameter("projectGroup"));
		int project = Integer.valueOf(request.getParameter("project"));
		String nextOperation = request.getParameter("nextoperation");
		int moq = Integer.valueOf(request.getParameter("moq"));
		String prLocation = request.getParameter("prlocation");
		String forLocation = request.getParameter("forlocation");
		int cSection = Integer.valueOf(request.getParameter("csection"));
		int cableColor = Integer.valueOf(request.getParameter("cable-c"));
		int clength = Integer.valueOf(request.getParameter("clength"));
		int lSideTerminal = Integer.valueOf(request.getParameter("lsideterminal"));
		int lSideSeal = Integer.valueOf(request.getParameter("lsideseal"));
		int rSideTerminal = 0;
		int rSideSeal = 0;
		if (request.getParameter("rsideterminal")!=null){
			rSideTerminal = Integer.valueOf(request.getParameter("rsideterminal"));
			rSideSeal = Integer.valueOf(request.getParameter("rsideseal"));			
		}


		scfv.getValues(category, projectGroup, project, nextOperation, moq, prLocation, forLocation, cSection,
				cableColor, clength, lSideTerminal, lSideSeal, rSideTerminal, rSideSeal);

		// System.out.println("name "+request.getParameter("project")+" /
		// "+request.getParameter("category"));
		//System.out.println("category " + category + " projectGroup " + projectGroup + " project " + project
		//		+ " nextOperation " + nextOperation + " moq " + moq + " prLocation " + prLocation + " forLocation "
		//		+ forLocation + " cSection " + cSection + " cableColor " + cableColor + " clength " + clength);
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
