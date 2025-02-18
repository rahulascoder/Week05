package com.day1_csv_file_handling;
import java.io.*;
import java.util.Arrays;

public class ReadCSV {

    public static void main(String[] args) {
        // Path to the CSV file
        String filePath = "students.csv";

        // Reading the CSV file using BufferedReader
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] details = line.split(",");

                if (details.length == 4) {
                    String id = details[0].trim();
                    String name = details[1].trim();
                    int age = Integer.parseInt(details[2].trim());
                    double marks = Double.parseDouble(details[3].trim());

                    // Print the student details
                    System.out.println("Student ID   : " + id);
                    System.out.println("Name         : " + name);
                    System.out.println("Age          : " + age);
                    System.out.println("Marks        : " + marks);
                } else {
                    System.out.println("Invalid data format: " + Arrays.toString(details));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error in data format: " + e.getMessage());
        }
    }
}
