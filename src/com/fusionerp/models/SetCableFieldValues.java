package com.fusionerp.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.fusionerp.sqlConn.SqlConnection;

public class SetCableFieldValues {
	private SqlConnection sqlConn = new SqlConnection();
	private CableModel cableModel = new CableModel();
	private Connection conn = sqlConn.getConn();
	private CableNumberDbWriter cndbw = new CableNumberDbWriter();

	public void getValues(String category, int projectGroup, int project, String nextOperation, int moq,
			String prLocation, String forLocation, int cSection, int cableColor, int clength, int lSideTerminal,
			int lSideSeal, int rSideTerminal, int rSideSeal) {

		cableModel.setOperation(category);
		cableModel.setNextOperation(nextOperation);
		cableModel.setMoq(moq);
		cableModel.setProductionLocation(prLocation);
		cableModel.setDestiationLocation(forLocation);
		cableModel.setLength(clength);

		projectGroupValue(project, projectGroup);
		projectValue(project);
		cableSection(cSection);
		cableColorValue(cSection, cableColor);
		terminalValue(lSideTerminal, rSideTerminal);
		sealValue(lSideSeal, rSideSeal);
		getNumberValue();
		cndbw.writeInDb(cableModel);

	}

	private void getNumberValue() {
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM cutcables WHERE project LIKE '" + cableModel.getProject()
					+ "' AND groupe LIKE '" + cableModel.getGroup() + "' ORDER BY sequence DESC LIMIT 1;");
			if (rs.next()) {
				cableSequence(rs.getString("sequence"));
			} else {
				cableModel.setNumber("001");
			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println("not queried getNumberValue");
			e.printStackTrace();
		}

	}

	private void cableSequence(String num) {
		int sequenceNum = Integer.valueOf(num) + 1;
		if (sequenceNum < 10) {
			cableModel.setNumber("00" + sequenceNum);
		} else if (sequenceNum < 100) {
			cableModel.setNumber("0" + sequenceNum);
		} else {
			cableModel.setNumber(String.valueOf(sequenceNum));
		}

	}

	private void sealValue(int lSideSeal, int rSideSeal) {
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM seals WHERE id LIKE '" + lSideSeal + "';");
			while (rs.next()) {
				cableModel.setSealLeft(rs.getString("sealName"));
			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println("not queried sealValue");
			e.printStackTrace();
		}

		if (rSideSeal != 0) {
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM seals WHERE id LIKE '" + rSideSeal + "';");
				while (rs.next()) {
					cableModel.setSealRight(rs.getString("sealName"));
				}
				stmt.close();
			} catch (SQLException e) {
				System.out.println("not queried sealValue");
				e.printStackTrace();
			}
		}

	}

	private void terminalValue(int lSideTerminal, int rSideTerminal) {
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM terminals WHERE id LIKE '" + lSideTerminal + "';");
			while (rs.next()) {
				cableModel.setTerminalLeft(rs.getString("terminalName"));
			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println("not queried terminalValue");
			e.printStackTrace();
		}

		if (rSideTerminal != 0) {
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM terminals WHERE id LIKE '" + rSideTerminal + "';");
				while (rs.next()) {
					cableModel.setTerminalRigth(rs.getString("terminalName"));
				}
				stmt.close();
			} catch (SQLException e) {
				System.out.println("not queried terminalValue");
				e.printStackTrace();
			}
		}
	}

	private void cableColorValue(int cSection, int cableColor) {
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM cables WHERE id LIKE '" + cSection + "';");
			while (rs.next()) {
				cableModel.setColor(rs.getString("c" + cableColor));
			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println("not queried cableColorValue");
			e.printStackTrace();
		}
	}

	private void cableSection(int cSection) {
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM cables WHERE id LIKE '" + cSection + "';");
			while (rs.next()) {
				cableModel.setSection(rs.getString("section"));
			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println("not queried cableSection");
			e.printStackTrace();
		}

	}

	private void projectValue(int project) {
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM project WHERE id LIKE '" + project + "';");
			while (rs.next()) {
				cableModel.setProject(rs.getString("shortName"));
			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println("not queried projectValue");
			e.printStackTrace();
		}

	}

	private void projectGroupValue(int project, int projectGroup) {
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM project WHERE id LIKE '" + project + "';");
			while (rs.next()) {
				cableModel.setGroup(rs.getString("group" + projectGroup));
			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println("not queried projectGroupValue");
			e.printStackTrace();
		}
	}
}
