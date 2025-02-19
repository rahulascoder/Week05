package com.day2_json;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

// Class representing a Student object
class Student1 {
    private String name;
    private int age;

    // Default constructor for Jackson
    public Student1() {}

    // Constructor to initialize Student object
    public Student1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for age
    public int getAge() {
        return age;
    }
}

public class ParseListToJSON {
    public static void main(String[] args) {
        try {
            // Creating ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

            // Reading JSON from external file
            File file = new File("C:\\Users\\Hp\\Desktop\\Java Training\\Week05\\file.csv");
            List<Student1> students = objectMapper.readValue(file, new TypeReference<List<Student1>>() {});

            System.out.println("Original JSON Array:");
            System.out.println(objectMapper.writeValueAsString(students));

            // Parsing JSON and filter students with age > 25
            List<Student1> filteredStudents = students.stream()
                    .filter(student -> student.getAge() > 25)
                    .collect(Collectors.toList());

            // Converting the filtered list back to JSON
            String filteredJsonArray = objectMapper.writeValueAsString(filteredStudents);
            System.out.println("Filtered JSON Array (Age > 25):");
            System.out.println(filteredJsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
