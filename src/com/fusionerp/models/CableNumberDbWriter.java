package com.fusionerp.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.Map;

import com.fusionerp.sqlConn.SqlConnection;

public class CableNumberDbWriter {
	SqlConnection sqlConn = new SqlConnection();

	public void writeInDb(CableModel cableModel) {
		Connection conn = sqlConn.getConn();
		try {
			Statement stmt = conn.createStatement();
			String sql = "INSERT INTO cutCables (operation, project, groupe, sequence, prloc, desloc, nextop, section, color, length, terminall, seall, terminalr, sealr) VALUES('"
					+ cableModel.getOperation() + "', '" + cableModel.getProject() + "', '" + cableModel.getGroup()
					+ "', '" + cableModel.getNumber() + "', '" + cableModel.getProductionLocation() + "', '"
					+ cableModel.getDestiationLocation() + "', '" + cableModel.getNextOperation() + "', '"
					+ cableModel.getSection() + "', '" + cableModel.getColor() + "', '" + cableModel.getLength()
					+ "', '" + cableModel.getTerminalLeft() + "', '" + cableModel.getSealLeft() + "', '"
					+ cableModel.getTerminalRigth() + "', '" + cableModel.getSealRight() + "');";
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			System.out.println("not insert");
			e.printStackTrace();
		}
	}
}
