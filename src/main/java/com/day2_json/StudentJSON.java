package com.day2_json;
import org.json.JSONArray;
import org.json.JSONObject;

public class StudentJSON {
    public static void main(String[] args) {
        // Creating  JSON object for the student
        JSONObject student = new JSONObject();

        // Adding name and age fields
        student.put("name", "Rahul Kumar");
        student.put("age", 23);

        // Creating an array for subjects
        JSONArray subjects = new JSONArray();
        subjects.put("Mathematics");
        subjects.put("Physics");
        subjects.put("Computer Science");

        // Adding subjects array to student object
        student.put("subjects", subjects);

        // Print
        System.out.println(student.toString(2));
    }
}
