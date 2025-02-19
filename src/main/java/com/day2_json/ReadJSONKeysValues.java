package com.day2_json;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.Iterator;
import java.util.Map;

public class ReadJSONKeysValues {
    public static void main(String[] args) {
        try {
            // Creating ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // Reading JSON from external file
            File file = new File("C:\\Users\\Hp\\Desktop\\Java Training\\Week05\\file.csv");
            JsonNode rootNode = objectMapper.readTree(file);

            // Iterating through all keys and values
            printJsonKeysAndValues(rootNode, "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printJsonKeysAndValues(JsonNode node, String parentKey) {
        if (node.isObject()) {
            Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> field = fields.next();
                printJsonKeysAndValues(field.getValue(), parentKey + field.getKey() + ".");
            }
        } else if (node.isArray()) {
            for (int i = 0; i < node.size(); i++) {
                printJsonKeysAndValues(node.get(i), parentKey + i + ".");
            }
        } else {
            System.out.println(parentKey.substring(0, parentKey.length() - 1) + " : " + node.asText());
        }
    }
}
