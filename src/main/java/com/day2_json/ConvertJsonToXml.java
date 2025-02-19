package com.day2_json;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;

public class ConvertJsonToXml {
    public static void main(String[] args) {
        try {
            // Create ObjectMapper instance to handle JSON data
            ObjectMapper objectMapper = new ObjectMapper();

            // Load JSON data from file
            File jsonFile = new File("user.json");
            JsonNode jsonNode = objectMapper.readTree(jsonFile);

            // Convert JSON to XML
            XmlMapper xmlMapper = new XmlMapper();
            String xml = xmlMapper.writeValueAsString(jsonNode);

            // Print XML output
            System.out.println("Converted XML:");
            System.out.println(xml);
        } catch (Exception e) {
            // Print error details if an exception occurs during conversion
            e.printStackTrace();
        }
    }
}
