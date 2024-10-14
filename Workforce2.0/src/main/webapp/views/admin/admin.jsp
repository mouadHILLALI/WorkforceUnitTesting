<%--
  Created by IntelliJ IDEA.
  User: MD
  Date: 10/10/2024
  Time: 8:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="/static/css/admin.css">
</head>
<body>
<nav class="navbar">
    <div class="logo">Admin Dashboard</div>
    <ul class="nav-links">
        <li><a href="/views/admin/admin.jsp">Home</a></li>
        <li><a href="/user?action=getAll">Manage Employees</a></li>
        <li><a href="/user?action=logout">Logout</a></li>
    </ul>
</nav>


<div class="container">
    <h1>Welcome Admin</h1>
    <section id="form1" class="add-employee-section">
        <h2>Add New Employee</h2>
        <form action="/employee" method="POST">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required>
            <label for="email">email:</label>
            <input type="email" id="email" name="email" required>
            <input type="text" id="action" value="create" name="action" required>
            <label for="phone">phone:</label>
            <input type="text" id="phone" name="phone" required>
            <label for="password">password:</label>
            <input type="password" id="password" name="password" required>
            <label for="dateOfBirth">Date Of Birth:</label>
            <input type="date" id="dateOfBirth" name="dateOfBirth" required>
            <label for="address">Address:</label>
            <input type="text" id="address" name="address" required>
            <label for="position">Position:</label>
            <input type="text" id="position" name="position" required>
            <label for="dateOfHiring">Date Of Hiring:</label>
            <input type="date" id="dateOfHiring" name="dateOfHiring" required>
            <label for="salary">Salary:</label>
            <input type="text" id="salary" name="salary" required>
            <label for="childrenCount">Children Count:</label>
            <input type="number" id="childrenCount" name="childrenCount" min="0" required>
            <label for="socialSecurityNumber">Social Security Number:</label>
            <input type="text" id="socialSecurityNumber" name="socialSecurityNumber" required>
            <label for="role">Role:</label>
            <select id="role" class="role" name="role" required>
                <option value="employee">Employee</option>
                <option value="hr">HR</option>
            </select>
            <button type="submit">Add Employee</button>
        </form>
    </section>
    <section id="form2" class="add-employee-section">
        <h2>Add New Employee</h2>
        <form action="/addEmployee" method="POST">
            <label for="Hrname">Name:</label>
            <input type="text" id="Hrname" name="name" required>
            <label for="HrEmail">phone:</label>
            <input type="email" id="HrEmail" name="email" required>
            <label for="Hrphone">Email:</label>
            <input type="text" id="Hrphone" name="phone" required>
            <label for="HrPassword">password:</label>
            <input type="password" id="HrPassword" name="password" required>
            <label for="HrAddress">Address:</label>
            <input type="text" id="HrAddress" name="address" required>
            <label for="HrRole">Role:</label>
            <select id="HrRole" class="role" name="role" required>
                <option value="employee">Employee</option>
                <option value="hr">HR</option>
            </select>
            <button type="submit">Add HR</button>
        </form>
    </section>
</div>
<script src="/static/JS/admin.js" type="application/javascript"></script>
</body>
</html>
