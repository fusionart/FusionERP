package com.fusionerp.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.fusionerp.sqlConn.SqlConnection;

public class DropDownMenu {
	SqlConnection sqlConn = new SqlConnection();

	public String dropDownMenu() {
		Connection conn = sqlConn.getConn();
		StringBuilder dropMenu = new StringBuilder();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM project;");
			while (rs.next()) {
				dropMenu = dropMenu.append(String.format("<option>%s</option>", rs.getString("projectName")));
			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println("not queried");
			e.printStackTrace();
		}
		//System.out.println(dropMenu.toString());
		return dropMenu.toString();

	}
}
