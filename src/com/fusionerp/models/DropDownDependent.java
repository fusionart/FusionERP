package com.fusionerp.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.Map;

import com.fusionerp.sqlConn.SqlConnection;

public class DropDownDependent {
	SqlConnection sqlConn = new SqlConnection();

	// public String dropDownMenu() {
	public Map dropDownMenu(int projectId) {
		Connection conn = sqlConn.getConn();
		int gr = 1;
		Map<String, String> projectGrpoups = new LinkedHashMap<String, String>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM project where id='" + projectId + "';");
			while (rs.next()) {
				for (int i = 1; i < 11; i++) {
					String grStr = "group" + i;
					if (rs.getString(grStr) != null) {
						System.out.println(rs.getString(grStr));
						projectGrpoups.put(i+"", rs.getString(grStr));
					}
				}

			}
			stmt.close();
		} catch (

		SQLException e) {
			System.out.println("not queried");
			e.printStackTrace();
		}
		for (Map.Entry<String, String> pair : projectGrpoups.entrySet()) {
			System.out.println(pair.getValue());
		}
		return projectGrpoups;
	}
}
