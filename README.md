# Student Management System

A console-based Student Management System developed using Java, JDBC, MySQL, and Maven.

## Features

- Add student
- View all students
- Update student details
- Delete student
- Mark attendance
- View student attendance
- Calculate attendance percentage
- Add student marks
- View student marks
- View available subjects
- Input validation
- Database connectivity using JDBC

## Technologies Used

- Java 17
- MySQL
- JDBC
- Maven
- VS Code

## Project Structure

student-management-system/
│
├── pom.xml
├── schema.sql
├── test.sql
├── README.md
├── .gitignore
│
└── src/
    └── main/
        └── java/
            ├── Main.java
            │
            ├── dao/
            │   ├── StudentDAO.java
            │   ├── AttendanceDAO.java
            │   ├── MarkDAO.java
            │   └── SubjectDAO.java
            │
            ├── model/
            │   ├── Student.java
            │   ├── Attendance.java
            │   └── Mark.java
            │
            └── util/
                └── DBConnection.java

## Database

The application uses a MySQL database named:

student_db

The database contains four main tables:

- students
- attendance
- subjects
- marks

### Database Relationships

students → attendance

students → marks ← subjects

The `student_id` connects students with their attendance and marks.

The `subject_id` connects marks with subjects.

## How to Run

### 1. Create the Database

Open MySQL and execute:

CREATE DATABASE student_db;

### 2. Create the Tables

Run the SQL statements provided in:

schema.sql

### 3. Configure the Database Password

The application reads the MySQL password from the environment variable:

DB_PASSWORD

On Windows, run:

setx DB_PASSWORD "YOUR_MYSQL_PASSWORD"

Replace YOUR_MYSQL_PASSWORD with your actual MySQL password.

Restart the terminal after setting the environment variable.

### 4. Build the Project

Open the project folder in the terminal and run:

mvn clean compile

### 5. Run the Application

Run Main.java from VS Code.

## Architecture

The project follows a simple DAO-based architecture.

### Model Layer

Model classes represent the data used by the application.

Examples:

- Student
- Attendance
- Mark

### DAO Layer

DAO classes handle database operations.

Examples:

- StudentDAO
- AttendanceDAO
- MarkDAO
- SubjectDAO

### Utility Layer

DBConnection manages the JDBC connection between the Java application and MySQL database.

### Main Class

Main.java provides the console-based user interface and connects user input with the DAO classes.

## JDBC

The application uses JDBC to communicate with the MySQL database.

The main JDBC components used are:

- Connection
- PreparedStatement
- ResultSet

PreparedStatement is used for SQL operations involving user-provided values.

## Student Management

The system allows users to:

- Add new students
- View all students
- Update student information
- Delete students

Student information includes:

- Student ID
- Name
- Email
- Department
- Year of Study

## Attendance Management

The system allows attendance to be recorded for students.

Attendance status can be:

- Present
- Absent

The system can also calculate the attendance percentage of a student.

The attendance percentage is calculated using:

Attendance Percentage = (Present Classes / Total Classes) × 100

## Marks Management

The system allows marks to be stored for students based on subjects.

Marks are restricted to values between:

0 and 100

The system can also display a student's marks along with the corresponding subject name.

## Subject Management

The system stores subjects with their respective departments.

Users can view the available subjects and their subject IDs.

## Input Validation

The application performs basic input validation.

Examples:

- Year of study must be between 1 and 4.
- Marks must be between 0 and 100.
- Attendance status must be Present or Absent.
- Student IDs are validated before performing related operations.

## Security

Database credentials are not stored directly in the source code.

The MySQL password is accessed through the DB_PASSWORD environment variable.

## Future Improvements

Possible future enhancements include:

- Graphical User Interface using JavaFX or Swing
- Login and authentication
- Admin and student roles
- Student search functionality
- Attendance reports
- Grade calculation
- PDF report generation
- REST API backend
- Web-based frontend

## Author

Chellapandian

Bachelor of Engineering - Computer Science and Engineering