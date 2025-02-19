package com.day2_json;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.opencsv.*;
import com.opencsv.exceptions.CsvException;

import java.io.*;
import java.nio.file.*;
import java.util.*;


public class IPLCensorAnalyzer {
    private static final String JSON_INPUT_FILE = "ipl_matches.json";
    private static final String CSV_INPUT_FILE = "ipl_matches.csv";
    private static final String JSON_OUTPUT_FILE = "censored_ipl_matches.json";
    private static final String CSV_OUTPUT_FILE = "censored_ipl_matches.csv";

    public static void main(String[] args) throws IOException {
        processJsonData(JSON_INPUT_FILE, JSON_OUTPUT_FILE);
        processCsvData(CSV_INPUT_FILE, CSV_OUTPUT_FILE);
    }

    private static void processJsonData(String inputFile, String outputFile) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(new File(inputFile));

        if (rootNode.isArray()) {
            ArrayNode arrayNode = (ArrayNode) rootNode;
            for (JsonNode matchNode : arrayNode) {
                ((ObjectNode) matchNode).put("team1", censorTeamName(matchNode.get("team1").asText()));
                ((ObjectNode) matchNode).put("team2", censorTeamName(matchNode.get("team2").asText()));
                ((ObjectNode) matchNode).put("player_of_match", "REDACTED");
            }
        }

        objectMapper.writeValue(new File(outputFile), rootNode);
    }

    private static void processCsvData(String inputFile, String outputFile) throws IOException {
        try (Reader reader = Files.newBufferedReader(Paths.get(inputFile));
             CSVReader csvReader = new CSVReader(reader);
             Writer writer = Files.newBufferedWriter(Paths.get(outputFile));
             CSVWriter csvWriter = new CSVWriter(writer)) {

            List<String[]> records;
            try {
                records = csvReader.readAll();
            } catch (CsvException e) {
                System.err.println("Error reading CSV file: " + e.getMessage());
                return;
            }

            if (records.isEmpty()) return;

            String[] header = records.get(0);
            csvWriter.writeNext(header);

            for (int i = 1; i < records.size(); i++) {
                String[] row = records.get(i);
                row[1] = censorTeamName(row[1]); // team1
                row[2] = censorTeamName(row[2]); // team2
                row[5] = "REDACTED"; // player_of_match
                csvWriter.writeNext(row);
            }
        }
    }


    private static String censorTeamName(String teamName) {
        String[] words = teamName.split(" ");
        if (words.length > 1) {
            words[words.length - 1] = "***";
        }
        return String.join(" ", words);
    }
}