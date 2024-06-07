package com.Tracker;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class logincon extends HttpServlet {
	public int id;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String un=request.getParameter("name");
		String psd=request.getParameter("password");
		
		PrintWriter out=response.getWriter() ;
	   try {
		Connection con=connection.connect();
		String query = "select userID from login where username=? and password=? ";

        // Create PreparedStatement with the SQL query
        PreparedStatement pstmt = con.prepareStatement(query);

        // Set parameters for PreparedStatement
        pstmt.setString(1, un);
        pstmt.setString(2, psd);
        ResultSet rs=pstmt.executeQuery();
        
        if(rs.next())
        {
        	 int id=rs.getInt("userId");
        	 
        	  HttpSession session = request.getSession();
              session.setAttribute("userID",id);
              preupgrade.upgrade(con,id,request,response);
        	
        }
         else
         {
        	 response.sendRedirect("login.jsp"); 
         }
;		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

}

