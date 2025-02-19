package com.day2_json;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadJSONFile {
    public static void main(String[] args) {
        //using try catch block to handle exception
        try {
            // Reading JSON file as a String
            String content = new String(Files.readAllBytes(Paths.get("C:\\Users\\Hp\\Desktop\\Java Training\\Week05\\file.csv")));

            // Converting String to JSON Object
            JSONObject jsonObject = new JSONObject(content);

            // Extracting specific fields
            String name = jsonObject.optString("name", "N/A");
            String email = jsonObject.optString("email", "N/A");

            // Printing name and email
            System.out.println("Name: " + name);
            System.out.println("Email: " + email);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}