package com.day2_json;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;
import java.io.File;
import java.util.Set;

public class ValidateEmailJSON {
    public static void main(String[] args) {
        try {
            // Creating ObjectMapper instance to handle JSON data
            ObjectMapper objectMapper = new ObjectMapper();

            // Loading JSON Schema from file
            File schemaFile = new File("email-schema.json");
            JsonSchemaFactory schemaFactory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V202012);
            JsonSchema schema = schemaFactory.getSchema(schemaFile.toURI());

            // Loading JSON data from file
            File jsonFile = new File("user.json");
            JsonNode jsonNode = objectMapper.readTree(jsonFile);

            // Validating JSON data against schema
            Set<ValidationMessage> validationErrors = schema.validate(jsonNode);

            // Printing validation results
            if (validationErrors.isEmpty()) {
                System.out.println("JSON is valid.");
            } else {
                System.out.println("JSON validation errors:");
                validationErrors.forEach(error -> System.out.println(error.getMessage()));
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
