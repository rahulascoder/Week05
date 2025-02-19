package com.day2_json;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

// Class representing a User object
class User {
    private String name;
    private int age;

    // Default constructor for Jackson
    public User() {}

    // Constructor to initialize User object
    public User(String name, int age) {
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

public class FilterJSONUsers {
    public static void main(String[] args) {
        try {
            // Creating ObjectMapper instance to handle JSON data
            ObjectMapper objectMapper = new ObjectMapper();

            // Define the JSON file to be read
            File file = new File("C:\\Users\\Hp\\Desktop\\Java Training\\Week05\\file.json");

            // Read and parse the JSON file into a list of User objects
            List<User> users = objectMapper.readValue(file, new TypeReference<List<User>>() {});

            // Filter users older than 25 years
            List<User> filteredUsers = users.stream()
                    .filter(user -> user.getAge() > 25)
                    .collect(Collectors.toList());

            // Printing filtered users
            System.out.println("Users older than 25:");
            for (User user : filteredUsers) {
                System.out.println("Name: " + user.getName() + ", Age: " + user.getAge());
            }
        } catch (Exception e) {
            // Print error details if an exception occurs during JSON processing
            e.printStackTrace();
        }
    }
}