package com.Tracker;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.http.HttpServletResponse;

public class signup {

	public static int sign(String name,String password, Connection con,HttpServletResponse response) throws SQLException, IOException
	{
		String query = "INSERT INTO login (username, password) VALUES (?, ?)";

        // Create PreparedStatement with the SQL query
        PreparedStatement pstmt = con.prepareStatement(query);

        // Set parameters for PreparedStatement
        pstmt.setString(1, name);
        pstmt.setString(2, password);

        // Execute the PreparedStatement to insert data
        int rowsAffected = pstmt.executeUpdate();
        // Close PreparedStatement and Connection
        pstmt.close();
        con.close();
        return rowsAffected;
	}
}
