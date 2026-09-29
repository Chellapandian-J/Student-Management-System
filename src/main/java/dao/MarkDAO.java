package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Mark;
import util.DBConnection;

public class MarkDAO {

    public void addMark(Mark mark) {

        String sql = """
                INSERT INTO marks
                (student_id, subject_id, marks)
                VALUES (?, ?, ?)
                """;

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, mark.getStudentId());
            ps.setInt(2, mark.getSubjectId());
            ps.setInt(3, mark.getMarks());

            ps.executeUpdate();

            System.out.println("Marks added successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewStudentMarks(int studentId) {

        String sql = """
                SELECT
                    s.name,
                    sub.subject_name,
                    m.marks
                FROM marks m
                JOIN students s
                    ON m.student_id = s.student_id
                JOIN subjects sub
                    ON m.subject_id = sub.subject_id
                WHERE s.student_id = ?
                """;

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, studentId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println(
                    rs.getString("name") + " | " +
                    rs.getString("subject_name") + " | " +
                    rs.getInt("marks")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}