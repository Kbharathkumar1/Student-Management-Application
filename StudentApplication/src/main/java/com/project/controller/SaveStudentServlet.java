package com.project.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/save-student")
public class SaveStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        

        String fName = request.getParameter("firstName");
        String lName = request.getParameter("lastName");
        String course = request.getParameter("course");


        String dbUrl = "jdbc:oracle:thin:@localhost:1521:XE"; 
        String dbUser = "system";
        String dbPassword = "admin";

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            

            try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
                 PreparedStatement pstmt = conn.prepareStatement(
                     "INSERT INTO STUDENTS (ID, FIRST_NAME, LAST_NAME, COURSE) VALUES (STUDENTS_SEQ.NEXTVAL, ?, ?, ?)")) {
                
                pstmt.setString(1, fName);
                pstmt.setString(2, lName);
                pstmt.setString(3, course);
                
               
                int rows = pstmt.executeUpdate();
                
                if (rows > 0) {
               
                    request.getRequestDispatcher("/WEB-INF/views/SaveStudent.jsp").forward(request, response);
                }
            }
        } catch (Exception e) {

            e.printStackTrace();
            response.getWriter().println("Database Error: " + e.getMessage());
        }
    }
}