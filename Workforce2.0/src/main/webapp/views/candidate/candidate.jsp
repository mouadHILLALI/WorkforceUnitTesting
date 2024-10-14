<%--
  Created by IntelliJ IDEA.
  User: MD
  Date: 10/10/2024
  Time: 10:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Candidate Dashboard</title>
    <link rel="stylesheet" type="text/css" href="/static/css/candidate.css">
</head>
<body>
<div class="container">
    <header class="header">
        <h1>Welcome, ${user.userName}!</h1>
        <a href="/user?action=logout" class="logout">Log Out</a>
    </header>

    <section class="info-section">
        <h2>Personal Information</h2>
        <div class="info-item">
            <strong>Name:</strong> ${user.userName}
        </div>
        <div class="info-item">
            <strong>Email:</strong> ${user.email}
        </div>
        <div class="info-item">
            <strong>Phone:</strong> ${user.phone}
        </div>
    </section>

    <section class="apply-section">
        <h2>Apply for Jobs</h2>
        <form action="applyJob.jsp" method="post" enctype="multipart/form-data">
            <label for="jobPosition">Job Position:</label>
            <input type="text" id="jobPosition" name="jobPosition" required>

            <label for="resume">Upload Resume:</label>
            <input type="file" id="resume" name="resume" accept=".pdf,.doc,.docx" required>

            <button type="submit" class="apply-button">Apply</button>
        </form>
    </section>
</div>
</body>
</html>
