package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Student;
import util.DBConnection;

public class StudentDAO {

    public void addStudent(Student student) {

        String sql = "INSERT INTO students " +
                     "(name, email, department, year_of_study) " +
                     "VALUES (?, ?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getDepartment());
            ps.setInt(4, student.getYearOfStudy());

            ps.executeUpdate();

            System.out.println("Student added successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getAllStudents() {

        String sql = "SELECT * FROM students";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                System.out.println(
                    rs.getInt("student_id") + " | " +
                    rs.getString("name") + " | " +
                    rs.getString("email") + " | " +
                    rs.getString("department") + " | " +
                    rs.getInt("year_of_study")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updateStudent(int studentId, String name,
                          String email, String department,
                          int yearOfStudy) {

    String sql = "UPDATE students " +
                 "SET name = ?, email = ?, department = ?, year_of_study = ? " +
                 "WHERE student_id = ?";

    try (Connection connection = DBConnection.getConnection();
         PreparedStatement ps = connection.prepareStatement(sql)) {

        ps.setString(1, name);
        ps.setString(2, email);
        ps.setString(3, department);
        ps.setInt(4, yearOfStudy);
        ps.setInt(5, studentId);

        int rowsAffected = ps.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("Student updated successfully!");
        } else {
            System.out.println("Student not found.");
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
    }
    public void deleteStudent(int studentId) {

        String sql = "DELETE FROM students WHERE student_id = ?";

        try (Connection connection = DBConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, studentId);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Student deleted successfully!");
            } else {
                System.out.println("Student not found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}