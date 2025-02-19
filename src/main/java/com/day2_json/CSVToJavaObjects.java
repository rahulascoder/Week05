package com.day2_json;
import java.io.*;
import java.util.*;

// Student class
class Student2 {
    private int id;
    private String name;
    private int age;
    private double marks;

    // Constructor
    public Student2(int id, String name, int age, double marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    // Override toString for easy printing
    @Override
    public String toString() {
        return "Student{" +
                "ID=" + id +
                ", Name='" + name + '\'' +
                ", Age=" + age +
                ", Marks=" + marks +
                '}';
    }
}
public class CSVToJavaObjects {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Hp\\Desktop\\Java Training\\Week05\\file.csv";
        // Path to CSV file
        List<Student2> studentList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0].trim());
                String name = data[1].trim();
                int age = Integer.parseInt(data[2].trim());
                double marks = Double.parseDouble(data[3].trim());

                // Create Student object and add to list
                studentList.add(new Student2(id, name, age, marks));
            }

            // Print all students
            System.out.println("List of Students:");
            for (Student2 student : studentList) {
                System.out.println(student);
            }

        } catch (IOException | NumberFormatException e) {
            System.out.println("Error processing the file: " + e.getMessage());
 }
}
}