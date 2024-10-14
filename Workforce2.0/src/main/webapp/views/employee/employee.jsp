<%--
  Created by IntelliJ IDEA.
  User: MD
  Date: 10/12/2024
  Time: 4:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee Dashboard</title>
    <link rel="stylesheet" type="text/css" href="/static/css/employee/employee.css">
</head>
<body>
<nav class="navbar">
    <div class="navbar-brand">
        <h1>Welcome, ${employee.userName}</h1>
    </div>
    <ul class="navbar-links">
        <li><a href="#">Dashboard</a></li>
        <li><a href="#">Profile</a></li>
        <li><a href="#">Apply for Leave</a></li>
        <li><a href="/user?action=logout">Logout</a></li>
    </ul>
</nav>

<div class="content">
    <h2>Apply for Leave</h2>
    <form action="/leave" method="post" class="leave-form">
        <div class="form-group">
            <label for="leaveType">Leave Type:</label>
            <select id="leaveType" name="leaveType" required>
                <option value="sick">Sick Leave</option>
                <option value="vacation">Vacation Leave</option>
                <option value="casual">Casual Leave</option>
            </select>
        </div>
        <div class="form-group">
            <label for="startDate">Start Date:</label>
            <input type="date" id="startDate" name="startDate" required>
            <input type="text" id="" name="action" value="leave" style="display: none" required>
        </div>
        <div class="form-group">
            <label for="endDate">End Date:</label>
            <input type="date" id="endDate" name="endDate" required>
        </div>
        <div class="form-group">
            <label for="reason">Reason for Leave:</label>
            <textarea id="reason" name="reason" rows="4" required></textarea>
        </div>
        <div class="form-group">
            <label for="file">Reason for Leave:</label>
            <input type="file" id="file" name="file"  required>
        </div>
        <button type="submit" class="submit-button">Submit Application</button>
    </form>
</div>
</body>
</html>
