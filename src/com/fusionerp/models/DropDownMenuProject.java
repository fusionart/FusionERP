package com.fusionerp.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.Map;

import com.fusionerp.sqlConn.SqlConnection;

public class DropDownMenuProject {
	SqlConnection sqlConn = new SqlConnection();

	//public String dropDownMenu() {
	public Map dropDownMenu() {
		Connection conn = sqlConn.getConn();
		Map <String, String> projects = new LinkedHashMap<String, String>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM project;");
			while (rs.next()) {
				projects.put(rs.getString("id"), rs.getString("projectName"));
			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println("not queried");
			e.printStackTrace();
		}
		return projects;
	}
}
