package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Attendance;
import util.DBConnection;

public class AttendanceDAO {

    public void markAttendance(Attendance attendance) {

        String sql = "INSERT INTO attendance " +
                     "(student_id, attendance_date, status) " +
                     "VALUES (?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, attendance.getStudentId());
            ps.setDate(
                2,
                java.sql.Date.valueOf(attendance.getAttendanceDate())
            );
            ps.setString(3, attendance.getStatus());

            ps.executeUpdate();

            System.out.println("Attendance marked successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewAttendance(int studentId) {

        String sql = """
                SELECT s.name, a.attendance_date, a.status
                FROM students s
                JOIN attendance a
                ON s.student_id = a.student_id
                WHERE s.student_id = ?
                ORDER BY a.attendance_date
                """;

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, studentId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println(
                    rs.getString("name") + " | " +
                    rs.getDate("attendance_date") + " | " +
                    rs.getString("status")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getAttendancePercentage(int studentId) {

        String sql = """
                SELECT
                    s.name,
                    COUNT(a.attendance_id) AS total_classes,
                    SUM(a.status = 'Present') AS present_classes,
                    ROUND(
                        SUM(a.status = 'Present') * 100.0
                        / COUNT(a.attendance_id),
                        2
                    ) AS attendance_percentage
                FROM students s
                JOIN attendance a
                ON s.student_id = a.student_id
                WHERE s.student_id = ?
                GROUP BY s.student_id, s.name
                """;

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, studentId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println(
                    "Student: " +
                    rs.getString("name")
                );

                System.out.println(
                    "Total Classes: " +
                    rs.getInt("total_classes")
                );

                System.out.println(
                    "Present Classes: " +
                    rs.getInt("present_classes")
                );

                System.out.println(
                    "Attendance: " +
                    rs.getDouble("attendance_percentage") +
                    "%"
                );
            } else {
                System.out.println("No attendance records found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}