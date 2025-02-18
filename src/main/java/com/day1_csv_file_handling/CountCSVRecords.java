package com.day1_csv_file_handling;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountCSVRecords {
    public static void main(String[] args) {
//        file path
        String filePath = "C:\\Users\\Hp\\Desktop\\Java Training\\Week05\\src\\file.csv";
        int recordCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true;

            while ((line = br.readLine()) != null) {
                if (isFirstLine) { // Skip the header row
                    isFirstLine = false;
                    continue;
                }
                recordCount++; // Count only data rows
            }

            System.out.println("Total number of records: " + recordCount);
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
