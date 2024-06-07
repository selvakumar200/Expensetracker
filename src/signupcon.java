package com.Tracker;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class signupcon extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        // Retrieve data from request parameters
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        try {
            // Load the MySQL JDBC driver
            // Define SQL INSERT statement
        	Connection con=connection.connect();
        	int t=signup.sign(name,password,con,response);
            if (t> 0) {
            	response.sendRedirect("login.jsp");
            } 
            else
            {
            	response.sendRedirect("login.jsp");
            }
        
        } catch (ClassNotFoundException | SQLException e) {
            // Handle exceptions
            e.printStackTrace();
        } 
    }
}
