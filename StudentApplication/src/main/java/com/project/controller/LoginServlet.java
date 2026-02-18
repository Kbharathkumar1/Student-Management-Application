package com.project.controller;

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String email = request.getParameter("email");
        String pswd = request.getParameter("pswd");

        
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "admin");
                 PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM APP_USERS WHERE EMAIL = ? AND PASSWORD_HASH = ?")) {
                
                pstmt.setString(1, email);
                pstmt.setString(2, pswd);
                
                ResultSet rs = pstmt.executeQuery();
                
                if (rs.next()) {

                    response.sendRedirect("StudentForm.html");
                } else {

                    response.sendRedirect("LoginForm.html?error=1");
                }
            }
        } catch (Exception e) {

            response.getWriter().println("Database Error: " + e.getMessage());
        }
    }
}