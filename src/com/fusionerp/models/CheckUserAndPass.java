package com.fusionerp.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.fusionerp.sqlConn.SqlConnection;

public class CheckUserAndPass {
	SqlConnection sqlConn = new SqlConnection();

	public Boolean checkUserAndPass(String user, String password) {
		Connection conn = sqlConn.getConn();
		String pass = null;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM users1 WHERE username LIKE '%" + user + "%';");
			while (rs.next()) {
				pass = rs.getString("password");
			}
			stmt.close();
			if (pass.equals(password)) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("not queried");
			e.printStackTrace();
		}
		return false;
	}
}
