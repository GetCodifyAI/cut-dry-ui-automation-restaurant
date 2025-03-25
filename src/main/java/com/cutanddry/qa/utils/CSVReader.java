package com.cutanddry.qa.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {
    public static String readCSV(String filePath) {
        StringBuilder result = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                result.append(line).append("\n"); // Append each line
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String csvContent = readCSV("src/test/resources/finalResult/test_result.csv");
        System.out.println(csvContent);
    }
}