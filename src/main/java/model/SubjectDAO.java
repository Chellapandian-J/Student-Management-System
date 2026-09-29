package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DBConnection;

public class SubjectDAO {

    public void getAllSubjects() {

        String sql = "SELECT * FROM subjects";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\n===== Available Subjects =====");

            while (rs.next()) {

                System.out.println(
                        rs.getInt("subject_id") + " | " +
                        rs.getString("subject_name") + " | " +
                        rs.getString("department")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}