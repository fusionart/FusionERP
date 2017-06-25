package com.fusionerp.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.Map;

import com.fusionerp.sqlConn.SqlConnection;

public class DropDownMenuSeals {
	SqlConnection sqlConn = new SqlConnection();

	//public String dropDownMenu() {
	public Map dropDownMenu() {
		Connection conn = sqlConn.getConn();
		Map <String, String> terminals = new LinkedHashMap<String, String>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM seals;");
			while (rs.next()) {
				terminals.put(rs.getString("id"), rs.getString("sealname"));
			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println("not queried");
			e.printStackTrace();
		}
//		for (Map.Entry<String, String> pair : cables.entrySet()) {
//			System.out.println(pair.getValue());
//		}
		return terminals;
	}
}
