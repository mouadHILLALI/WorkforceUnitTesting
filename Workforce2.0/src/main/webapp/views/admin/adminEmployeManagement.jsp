<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Employee Management</title>
    <link rel="stylesheet" href="/static/css/adminEmployeeManagement.css">
</head>
<body>
<nav class="navbar">
    <div class="logo">Admin Dashboard</div>
    <ul class="nav-links">
        <li><a href="/views/admin/admin.jsp">Home</a></li>
        <li><a  href="/user?action=getAll">Manage Employees</a></li>
        <li><a href="/user?action=logout">Logout</a></li>
    </ul>
</nav>

<section class="employee-section">
    <h2>Employee Management</h2>
    <div class="employee-cards-container">
        <c:forEach var="employee" items="${employeeDTOS}">
            <div class="employee-card">
                <img src="https://via.placeholder.com/150" alt="Employee Photo" class="employee-photo"/>
                <div class="card-header">
                    <h3>${employee.userName}</h3>
                    <p><strong>Email:</strong> ${employee.email}</p>
                    <p><strong>Role:</strong> ${employee.position}</p>
                </div>
                <div class="card-body">
                    <p><strong>Salary:</strong> ${employee.salary}</p>
                    <p><strong>Children Count:</strong> ${employee.childrenCount}</p>
                    <p><strong>Phone:</strong> ${employee.phoneNumber}</p>
                </div>
                <div class="card-actions">
                    <a href="/employee?id=${employee.id}&action=update" class="update-btn">Update</a>
                    <a href="/employee?id=${employee.id}&action=delete" class="delete-btn">Delete</a>
                </div>
            </div>
        </c:forEach>
    </div>
</section>
</body>
</html>
