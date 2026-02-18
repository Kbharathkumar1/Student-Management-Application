<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Processing...</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light d-flex align-items-center justify-content-center vh-100">
    <div class="container text-center">
        <%
            String fName = request.getParameter("firstName");
            String lName = request.getParameter("lastName");
            String course = request.getParameter("course");

            if (fName == null || lName == null || fName.trim().isEmpty() || lName.trim().isEmpty()) {
                out.println("<div class='alert alert-danger'>Fields cannot be empty.</div>");
                out.println("<a href='StudentForm.html' class='btn btn-primary'>Go Back</a>");
                return;
            }

            String dbUrl = "jdbc:oracle:thin:@localhost:1521:XE"; 
            String dbUser = "system";
            String dbPassword = "admin";

            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                
                String sql = "INSERT INTO STUDENTS (ID, FIRST_NAME, LAST_NAME, COURSE) VALUES (STUDENTS_SEQ.NEXTVAL, ?, ?, ?)";
                
                try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
                     PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    
                    pstmt.setString(1, fName);
                    pstmt.setString(2, lName);
                    pstmt.setString(3, course);
                    pstmt.executeUpdate();
                    

                    out.println("<div class='card p-5 shadow-sm mx-auto' style='max-width: 400px;'>");
                    out.println("<h2 class='text-success mb-3'>Success!</h2>");
                    out.println("<p>Student " + fName + " " + lName + " was saved to the database.</p>");
                    out.println("<a href='view-students' class='btn btn-primary mt-3'>View All Students</a>");
                    out.println("<a href='StudentForm.html' class='btn btn-outline-secondary mt-2'>Add Another</a>");
                    out.println("</div>");

                }
            } catch (Exception e) {
                out.println("<div class='alert alert-danger'><strong>Error:</strong> " + e.getMessage() + "</div>");
            }
        %>
    </div>
</body>
</html>