package com.day2_json;
import org.json.JSONObject;


public class MergeJSONObjects {
    public static void main(String[] args) {
        // Creating first JSON object
        JSONObject json1 = new JSONObject();
        json1.put("name", "Amol");
        json1.put("email", "amol.bridgelabz@gmail.com");

        // Creating second JSON object
        JSONObject json2 = new JSONObject();
        json2.put("age", 30);
        json2.put("city", "New York");

        // Merging two JSON objects manually
        JSONObject mergedJson = new JSONObject(json1.toMap());
        for (String key : json2.keySet()) {
            mergedJson.put(key, json2.get(key));
        }

        // Print merged JSON object
        System.out.println(mergedJson.toString(1));
    }
}