<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.Tracker.Expense" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Expense Tracker</title>
<link rel="icon" type="image/x-icon" href="logo.png">
<style>
  body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f4;
    margin: 0;
    padding: 0;
  }
  h1 {
    text-align: center;
    margin-top: 20px;
  }
  form {
    background-color: #fff;
    border-radius: 8px;
    padding: 20px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    width: 300px;
    margin: 20px auto;
  }
  div {
    margin-bottom: 10px;
  }
  input[type="text"],
  input[type="date"],
  input[type="number"] {
    width: calc(100% - 10px);
    padding: 8px;
    margin-bottom: 10px;
    border: 1px solid #ccc;
    border-radius: 4px;
  }
  button[type="submit"] {
    background-color: #007bff;
    color: #fff;
    border: none;
    border-radius: 4px;
    padding: 10px 20px;
    cursor: pointer;
    width: 100%;
  }
  button[type="submit"]:hover {
    background-color: #0056b3;
  }
  table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 20px;
  }
  th, td {
    border: 1px solid #ddd;
    padding: 8px;
    text-align: left;
  }
  th {
    background-color: #f2f2f2;
  }
  p {
    text-align: center;
  }
</style>
</head>
<body>
 <h1>Expense Tracker</h1>
 <form action="updatedata" method="post"> 
 <div>
 Item:<input type="text"name="item">
 Date:<input type="date" name="date">
 Price:<input type="number" name="price">
 </div>
 <button type="submit">Add</button>
 </form>
 <%
        List<Expense> expense = (List<Expense>) request.getAttribute("expense");
        if (expense != null && !expense.isEmpty()) {
    %>
        <table border="1">
            <tr>
                <th>Item</th>
                <th>Date</th>
                <th>Cost</th>
            </tr>
            <%
                for (Expense exp: expense) {
            %>
                <tr>
                    <td><%= exp.getItem() %></td>
                    <td><%= exp.getDate() %></td>
                    <td><%= exp.getCost() %></td>
                </tr>
            <%
                }
            %>
        </table>
    <%
        } else {
    %>
        <p>No expenses found.</p>
    <%
        }
    %>
 </body>
</html>