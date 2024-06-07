package com.Tracker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connection {
	public static Connection connect() throws  SQLException, ClassNotFoundException
	{
	Class.forName("com.mysql.cj.jdbc.Driver");

    // Establish connection to MySQL database
    String url = "jdbc:mysql://localhost:3306/expensetracker";
    String username = "root";
    String passwordDB = "9942559481"; // Replace with your MySQL password
    Connection con = DriverManager.getConnection(url, username, passwordDB);
	return con;
	}
}
