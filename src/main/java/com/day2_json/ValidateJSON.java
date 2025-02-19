package com.day2_json;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ValidateJSON {
    public static void main(String[] args) {
        String jsonString = "{\"name\":\"Rahul kumar\",\"email\":\"rahulkumar@gmail.com\",\"age\":23}";

        // Creating ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        //handling exception using try-catch block
        try {
            // Parsing JSON string
            JsonNode jsonNode = objectMapper.readTree(jsonString);

            // if JSON is valid
            System.out.println("Valid JSON Structure:");
            System.out.println(jsonNode.toPrettyString());
        } catch (Exception e) {
            // If JSON is invalid
            System.out.println("Invalid JSON: " + e.getMessage());
        }
    }
}