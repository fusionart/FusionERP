package com.fusionerp.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.Map;

import com.fusionerp.sqlConn.SqlConnection;

public class DropDownCableColor {
	SqlConnection sqlConn = new SqlConnection();

	// public String dropDownMenu() {
	public Map dropDownMenu(int cableId) {
		Connection conn = sqlConn.getConn();
		int gr = 1;
		Map<String, String> cablesColor = new LinkedHashMap<String, String>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM cables where id='" + cableId + "';");
			while (rs.next()) {
				for (int i = 1; i < 8; i++) {
					String grStr = "c" + i;
					if (rs.getString(grStr) != null) {
						//System.out.println(rs.getString(grStr));
						cablesColor.put(i+"", rs.getString(grStr));
					}
				}

			}
			stmt.close();
		} catch (

		SQLException e) {
			System.out.println("not queried");
			e.printStackTrace();
		}
//		for (Map.Entry<String, String> pair : cablesColor.entrySet()) {
//			System.out.println(pair.getValue());
//		}
		return cablesColor;
	}
}
