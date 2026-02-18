<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.project.model.Student" %>
<!DOCTYPE html>
<html>
<head>
    <title>All Students</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light p-5">
    <div class="container">
        <div class="d-flex justify-content-between align-items-center mb-4">
            <h2>Student Database</h2>
            <a href="StudentForm.html" class="btn btn-primary">+ Add New Student</a>
        </div>
        
        <div class="card shadow-sm p-4">
            <table class="table table-bordered table-hover mb-0">
                <thead class="table-dark">
                    <tr>
                        <th>ID</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Course</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<Student> students = (List<Student>) request.getAttribute("studentList");
                        if (students != null && !students.isEmpty()) {
                            for (Student s : students) {
                    %>
                        <tr>
                            <td><%= s.getId() %></td>
                            <td><%= s.getFirstName() %></td>
                            <td><%= s.getLastName() %></td>
                            <td><%= s.getCourse() %></td>
                        </tr>
                    <%
                            }
                        } else {
                    %>
                        <tr><td colspan="4" class="text-center py-3">No records found.</td></tr>
                    <% } %>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>