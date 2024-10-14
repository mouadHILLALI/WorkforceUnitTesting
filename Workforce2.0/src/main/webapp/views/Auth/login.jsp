<%--
  Created by IntelliJ IDEA.
  User: MD
  Date: 10/10/2024
  Time: 11:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="/static/css/login.css">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
</head>
<body>
<div class="login-container">
    <h2>Welcome Back!</h2>
    <form action="/user" method="post">
        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" id="email" name="email" required>
            <input type="hidden" id="action" name="action" value="login">
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" id="password" name="password" required>
        </div>
        <div class="form-group">
            <label for="userType">Are you an employee?</label>
            <select id="userType" name="userType" required>
                <option value="employee">Employee</option>
                <option value="nonEmployee">Non-Employee</option>
            </select>
        </div>
        <button type="submit" class="login-button">Log In</button>
        <div class="error-message">
            <c:if test="${not empty loginError}">
                <p>${loginError}</p>
            </c:if>
        </div>
    </form>
    <div class="register-link">
        <p>Don't have an account? <a href="/views/Auth/register.jsp">Sign Up</a></p>
    </div>
</div>
</body>
</html>
