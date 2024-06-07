<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
  }
  form {
    background-color: #fff;
    border-radius: 8px;
    padding: 20px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    width: 300px;
  }
  h1 {
    text-align: center;
    margin-bottom: 20px;
  }
  label {
    display: block;
    margin-bottom: 5px;
    font-weight: bold;
  }
  input[type="email"],
  input[type="password"] {
    width: calc(100% - 10px);
    padding: 8px;
    margin-bottom: 10px;
    border: 1px solid #ccc;
    border-radius: 4px;
  }
  input[type="checkbox"] {
    display: inline-block;
    margin-right: 5px;
    vertical-align: middle;
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
  a {
    color: #007bff;
    text-decoration: none;
  }
  a:hover {
    text-decoration: underline;
  }</style>
</head>
<body>
 <form action="logincon" method="get">
 <h1>Welcome back!</h1>
 <p>Please enter your details</p>
  <label for="name">Email</label>
  <input id="name" name="name"type="email" required> 
  <label for="password">Password</label>
  <input id="password" name="password" type="password" required>
  <input type="checkbox" id="remember" style="display: inline-block; margin-right: 5px;"><label for="remember" style="display: inline-block;">Remember</label>
  <a href="#" style="margin-left: 5px; margin-right: 5px;">Forget Password</a>
  <button type="submit">Sign in</button>
  <p>Don't have an account? <a href="signup.jsp">Sign Up</a></p>
 </form>
</html>
