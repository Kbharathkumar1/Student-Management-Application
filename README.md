# Student Management System (MVC Architecture)

A full-stack Java web application built to demonstrate the **Model-View-Controller (MVC)** design pattern. This project replaces the legacy "Model 1" approach with a secure, scalable architecture that separates business logic (Servlets) from presentation (JSP) and data access (JDBC).

 Application Preview:
<img width="1919" height="958" alt="Screenshot 2026-02-18 183952" src="https://github.com/user-attachments/assets/936741cb-3ea3-4601-94ff-669ce39aa540" />
<img width="1919" height="949" alt="Screenshot 2026-02-18 184019" src="https://github.com/user-attachments/assets/08a0db26-979b-404c-96fc-4663a2cfb56f" />
<img width="1918" height="949" alt="Screenshot 2026-02-18 184038" src="https://github.com/user-attachments/assets/a3ebc9a3-519f-4252-88bd-88367b93e503" />
<img width="1919" height="956" alt="Screenshot 2026-02-18 184134" src="https://github.com/user-attachments/assets/331a9dff-733f-4596-8539-a1fc5f919d03" />
<img width="785" height="344" alt="Screenshot 2026-02-18 184150" src="https://github.com/user-attachments/assets/0460dc91-81b8-43f8-8b0a-dce74f1c2e38" />

==========================================================================================================================================================
Internal Visulas:
1. The Authentication Flow (Login):-
<img width="1024" height="559" alt="image" src="https://github.com/user-attachments/assets/403024ce-326c-438e-b35f-c91e7d1df03b" />
2. The Data Entry Flow (Save Student):-
<img width="1024" height="559" alt="image" src="https://github.com/user-attachments/assets/aafb6a4f-4988-4a65-9eac-a5baf9855080" />
3. The Silent Forward (Success Page):-
<img width="1024" height="559" alt="image" src="https://github.com/user-attachments/assets/def84520-f5c9-4d52-b11d-6624a51dd1f9" />
4. The Reporting Flow (View Students):-
<img width="1024" height="559" alt="image" src="https://github.com/user-attachments/assets/4d81f273-deef-4d52-9da2-cb3d693e6683" />


1. Secure Authentication:
> The entry point requires valid credentials verified against the Oracle database.
<img width="1919" height="958" alt="Screenshot 2026-02-18 183952" src="https://github.com/user-attachments/assets/039097a5-f507-4fe4-a1a7-89b76abecda0" />


2. Data Entry & Validation:
> The input form submits to a Servlet which handles the transaction and auto-increments the ID sequence.
<img width="1919" height="949" alt="Screenshot 2026-02-18 184019" src="https://github.com/user-attachments/assets/f59386f2-95b7-48f3-a4d3-9f223de290de" />

Success Message:
<img width="1918" height="949" alt="Screenshot 2026-02-18 184038" src="https://github.com/user-attachments/assets/1aa77913-adb6-470d-be24-e7fb73d7b01a" />

If You Want To Add Another Record click on ADDANOTHER button:
<img width="1915" height="874" alt="Screenshot 2026-02-18 184513" src="https://github.com/user-attachments/assets/f5ccf1b0-c54f-4dc1-b892-d18b8ee3e2e8" />

3. Dynamic Student Dashboard:
> Data is fetched via the Controller, converting ResultSet rows into Java Objects before rendering.
<img width="1919" height="956" alt="Screenshot 2026-02-18 184134" src="https://github.com/user-attachments/assets/98cacda3-80a4-4491-8f67-3d7bd55b93e3" />

If You Want To Add Another Record click on ADDNEWSTUDENT button
<img width="1919" height="941" alt="Screenshot 2026-02-18 184334" src="https://github.com/user-attachments/assets/35ff3f05-f874-404f-9738-d94f96dcca07" />



Tech Stack:
* Backend: Java SE 17, Servlets, JDBC
* Frontend: JSP, HTML5, CSS3, Bootstrap 5
* Database: Oracle Database 11g Express Edition (XE) / 19c
* Server: Apache Tomcat 9.0
* IDE: Eclipse Enterprise Edition

 Architecture & Logic Flow:

This application strictly enforces "MVC separation":

1.  Controller Layer (`com.project.controller`):
    * Intercepts all HTTP requests.
    * `LoginServlet`: Handles session creation and security.
    * `StudentController`: Manages CRUD operations and directs traffic.
2.  Model Layer (`com.project.model`):
    * POJO classes (`Student.java`) acting as Data Transfer Objects (DTOs).
    * Ensures type safety when moving data from SQL to the View.
3.  View Layer (`WEB-INF/views`):
    * JSP files are hidden inside `WEB-INF` to prevent direct access.
    * Views are passive; they only render data provided by the Servlet.

 Setup & Installation

Prerequisites:
* Java Development Kit (JDK) 8+
* Apache Tomcat Server
* Oracle Database

Step 1: Database Configuration
Run the following SQL commands in your Oracle SQL Command Line:
```sql
CREATE TABLE APP_USERS (
    EMAIL VARCHAR2(50) PRIMARY KEY,
    PASSWORD_HASH VARCHAR2(50)
);

CREATE TABLE STUDENTS (
    ID NUMBER PRIMARY KEY,
    FIRST_NAME VARCHAR2(50),
    LAST_NAME VARCHAR2(50),
    COURSE VARCHAR2(50)
);

CREATE SEQUENCE STUDENTS_SEQ START WITH 1 INCREMENT BY 1;

-- Insert a dummy admin user
INSERT INTO APP_USERS VALUES ('admin@example.com', 'admin123');
COMMIT;

Step 2: Project Setup

Clone this repository.

Import into Eclipse as a "Dynamic Web Project".

Crucial: Add ojdbc8.jar to src/main/webapp/WEB-INF/lib/.

Update dbUser and dbPassword in the Servlets to match your local Oracle credentials.

Step 3: Deployment

Right-click the project -> Run As -> Run on Server.

Navigate to: http://localhost:8080/StudentApplication/LoginForm.html

 Future Enhancements:
----------------------
> Implement "Delete" and "Update" functionality.

> Add client-side validation using JavaScript.

> Migrate JDBC code to a DAO (Data Access Object) layer for cleaner Controllers.
