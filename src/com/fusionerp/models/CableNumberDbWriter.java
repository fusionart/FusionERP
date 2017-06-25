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

	public void writeInDb() {
		Connection conn = sqlConn.getConn();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM project;");
			while (rs.next()) {
				
			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println("not queried");
			e.printStackTrace();
		}
	}
}
