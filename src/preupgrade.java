package com.Tracker;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class preupgrade {
public static void upgrade(Connection con,int id ,HttpServletRequest request,HttpServletResponse response) throws SQLException, ServletException, IOException
{
	 List<Expense>expense=fetch(con,id);
	 request.setAttribute("expense", expense);
	 request.getRequestDispatcher("index.jsp").forward(request, response);
}
private static List<Expense> fetch(Connection con,int id) throws SQLException
{  String query = "SELECT DateOfPurchase,Item, price FROM userdata WHERE userID = ?";
PreparedStatement pstmt = con.prepareStatement(query);
pstmt.setInt(1, id);
ResultSet rs = pstmt.executeQuery();
	List<Expense> expenses=new ArrayList<>();
	 while (rs.next()) {
            String item = rs.getString("Item");
            String date = rs.getString("DateOfPurchase");
            int cost = rs.getInt("price");
            expenses.add(new Expense(item, date, cost));
        }

        rs.close();
        pstmt.close();
        return expenses;
	
}
}