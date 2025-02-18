package com.day1_csv_file_handling;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteCSVFile {
    public static void main(String[] args) {
        //file we create
        String filePath = "C:\\Users\\Hp\\Desktop\\Java Training\\Week05\\src\\file.csv";

        // Employee data
        String[] employees = {
                "101,Rahul Kumar,IT,75000",
                "102,Akhil Bharti,HR,65000",
                "103,Rudra Ray,Finance,72000",
                "104,Vikash jadav,Marketing,68000",
                "105,Ranjan raj,Sales,70000"
        };

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Writing header
            writer.write("ID,Name,Department,Salary");
            writer.newLine();

            // Writing employee records using for-each loop
            for (String employee : employees) {
                writer.write(employee);
                writer.newLine();
            }

            System.out.println("CSV file '" + filePath + "' written successfully!");
        } catch (IOException e) {
            System.err.println("Error writing the file: " + e.getMessage());
        }
    }
}

