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
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.cj.Session;

public class updatedata extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String time=request.getParameter("date");
		String item=request.getParameter("item");
		String cost=request.getParameter("price");
		int price=Integer.parseInt(cost);
		Date date =Date.valueOf(time);
		int id=0;
		 HttpSession session = request.getSession();
		 if(session.getAttribute("userID")!=null)
		 {
		  id=(int) session.getAttribute("userID");
		 }
		 
		 PrintWriter out=response.getWriter();
			Connection con=null;
			try {
				con = connection.connect();
				String query ="Insert into userdata(userId,DateOfPurchase,Item,Price) values(?,?,?,?)";
				PreparedStatement pst=con.prepareStatement(query);
				pst.setDate(2, date);
				pst.setString(3,item);
				pst.setInt(1, id);
				pst.setInt(4, price);
				int rowsaffected=pst.executeUpdate();
				if(rowsaffected>0)
				{
					 preupgrade.upgrade(con,id,request,response);
				}
				else
				{
					response.sendRedirect("signup.jsp"); 
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}
}
