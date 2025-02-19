package com.day2_json;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.util.ArrayList;
import java.util.List;

class Student {
    //attributes
    private String name;
    private int age;

    //constructor to initialize object
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //getter name and age
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class ConvertListToJSON {
    public static void main(String[] args) {
        //try-catch block for exception handling
        try {
            //Creating Object of list class
            List<Student> students = new ArrayList<>();
            students.add(new Student("Rahul Kumar", 23));
            students.add(new Student("Rudra Ray", 22));
            students.add(new Student("Amit Kamal", 21));

            // Creating ObjectMapper instance to convert objects to JSON
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

            // Converting the list of students to JSON format
            String jsonArray = objectMapper.writeValueAsString(students);
            System.out.println(jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

