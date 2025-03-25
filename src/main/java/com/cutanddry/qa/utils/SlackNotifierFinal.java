package com.cutanddry.qa.utils;

import com.cutanddry.qa.common.Constants;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class SlackNotifierFinal {
    private static final String WEBHOOK_URL = Constants.SLACK_WEBHOOK;

    public static void sendSlackMessage(String message) {
        try {
            URL url = new URL(WEBHOOK_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String jsonPayload = "{ \"text\": \"" + message.replace("\n", "\\n") + "\" }";
            byte[] out = jsonPayload.getBytes(StandardCharsets.UTF_8);

            try (OutputStream os = conn.getOutputStream()) {
                os.write(out);
            }

            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                System.out.println("Slack message sent successfully!");
            } else {
                System.out.println("Failed to send Slack message. Response Code: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String csvContent = CSVReader.readCSV("src/test/resources/finalResult/test_result.csv"); // Read CSV file
        sendSlackMessage("Test Results:\n" + csvContent); // Send it to Slack
    }
}
