package com.day2_json;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenerateJsonReport {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/College_database";
        String user = "your_username";
        String password = "your_password";
        String query = "SELECT * FROM your_table";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            List<Map<String, Object>> records = new ArrayList<>();
            int columnCount = rs.getMetaData().getColumnCount();

            while (rs.next()) {
                Map<String, Object> row = new HashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    row.put(rs.getMetaData().getColumnName(i), rs.getObject(i));
                }
                records.add(row);
            }

            // Convert database records to JSON
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonReport = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(records);

            // Print JSON report
            System.out.println("Generated JSON Report:");
            System.out.println(jsonReport);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
