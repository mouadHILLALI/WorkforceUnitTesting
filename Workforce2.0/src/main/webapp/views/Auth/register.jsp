<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration Page</title>
    <link rel="stylesheet" type="text/css" href="/static/css/register.css">
</head>
<body>
<div class="navbar">
    <ul>
        <li><a href="../../index.jsp">Home</a></li>
        <li><a href="login.jsp">Login</a></li>
        <li><a href="register.jsp">Register</a></li>
    </ul>
</div>

<div class="container">
    <h2>Create Your Account</h2>
    <form action="/user" method="post">
        <div class="form-group">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
            <input type="text" name="action" value="register" id=   "action">
        </div>
        <div class="form-group">
            <label for="phone">Phone Number:</label>
            <input type="tel" id="phone" name="phone" required>
        </div>
        <button type="submit" class="btn">Register</button>
    </form>
</div>

<div class="footer">
    <p>&copy; WorkforceLLC. All rights reserved.</p>
</div>
</body>
</html>
