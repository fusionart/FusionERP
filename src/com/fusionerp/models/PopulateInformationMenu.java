package com.fusionerp.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.fusionerp.sqlConn.SqlConnection;

public class PopulateInformationMenu {
	private SqlConnection sqlConn = new SqlConnection();
	private Connection conn = sqlConn.getConn();

	public List<CableModel> generateInfo(int gr) {
		List<CableModel> cables = new ArrayList<>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = null;
			if (gr == -1) {
				rs = stmt.executeQuery("SELECT * FROM cutcables;");
			} else {
				rs = stmt.executeQuery("SELECT * FROM cutcables WHERE project LIKE '" + projectShortName(gr) + "' ;");
			}

			while (rs.next()) {
				CableModel currentCable = new CableModel();
				String operation = rs.getString("operation");
				String project = rs.getString("project");
				String groupe = rs.getString("groupe");
				String sequence = rs.getString("sequence");
				String section = rs.getString("section");
				String color = rs.getString("color");
				int length = rs.getInt("length");
				String prLoc = rs.getString("prloc");
				String desLoc = rs.getString("desloc");
				String nextOperation = rs.getString("nextop");
				String terminalL = rs.getString("terminall");
				String sealL = rs.getString("seall");
				String terminalR = rs.getString("terminalr");
				String sealR = rs.getString("sealR");

				currentCable.setProjectLongName(projectName(project));
				currentCable.setNumber(operation + project + groupe + sequence);
				currentCable.setGroup(groupe);
				currentCable.setSection(section);
				currentCable.setColor(color);
				currentCable.setLength(length);
				currentCable.setProductionLocation(prLoc);
				currentCable.setDestiationLocation(desLoc);
				currentCable.setNextOperation(nextOperation);
				currentCable.setTerminalLeft(terminalL);
				if (sealL.equals("null")){
					currentCable.setSealLeft("-");
				} else{
					currentCable.setSealLeft(sealL);
				}
				if (terminalR.equals("null")){
					currentCable.setTerminalRigth("-");
				} else{
					currentCable.setTerminalRigth(terminalR);
				}
				if (sealR.equals("null")){
					currentCable.setSealRight("-");
				} else{
					currentCable.setSealRight(sealR);
				}
				cables.add(currentCable);
			}
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cables;
	}

	private String projectShortName(int gr) {
		String projectName = null;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM project where id='" + gr + "';");
			while (rs.next()) {
				projectName = rs.getString("shortName");
			}
			stmt.close();
		} catch (

		SQLException e) {
			System.out.println("not queried shortName");
			e.printStackTrace();
		}
		return projectName;
	}

	private String projectName(String project) {
		String projectName = null;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM project WHERE shortName='" + project + "';");
			while (rs.next()) {
				projectName = rs.getString("projectName");
			}
			stmt.close();
		} catch (

		SQLException e) {
			System.out.println("not queried projectName");
			e.printStackTrace();
		}
		return projectName;
	}

}
