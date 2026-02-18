package com.project.controller;

import com.project.model.Student;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/view-students") 
public class ViewStudentsServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        List<Student> list = new ArrayList<>();
        
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "admin");
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT * FROM STUDENTS ORDER BY ID DESC")) {
                
                while (rs.next()) {
                    list.add(new Student(
                        rs.getInt("ID"),
                        rs.getString("FIRST_NAME"),
                        rs.getString("LAST_NAME"),
                        rs.getString("COURSE")
                    ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        request.setAttribute("studentList", list);


        request.getRequestDispatcher("/WEB-INF/views/ViewStudents.jsp").forward(request, response);
    }
}