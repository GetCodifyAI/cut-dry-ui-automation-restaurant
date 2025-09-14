package com.cutanddry.qa.utils;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import com.cutanddry.qa.common.Constants;
import org.json.JSONObject;

import static com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat.URI;

public class SlackNotifier {
    private static final String WEBHOOK_URL = Constants.SLACK_WEBHOOK;
    //https://hooks.slack.com/services/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

    // Update this with the actual URL where the report is hosted
    private static final String REPORT_URL = "https://app.circleci.com/pipelines/github/GetCodifyAI/cut-and-dry?branch=master";

    public static void sendSlackAlert(int totalTests, int passedTests, int failedTests, String environment, List<String> passedTestCases, List<String> failedTestCases, String PART,String host) {
        try {
            if (WEBHOOK_URL == null || WEBHOOK_URL.trim().isEmpty()) {
                System.out.println("Slack webhook URL is not configured. Skipping Slack notification.");
                return;
            }

            String environmentHost = (host != null && !host.trim().isEmpty()) ? host : "unknown";
            
            // Construct the JSON payload
            String payload = "{"
                    + "\"blocks\": ["
                    + "{"
                    + "\"type\": \"section\","
                    + "\"text\": {"
                    + "\"type\": \"mrkdwn\","
                    + "\"text\": \"*Operator " + PART +" [ "+environmentHost+" ] - Test Suite Execution Completed!*\""
                    + "}"
                    + "},"
                    + "{"
                    + "\"type\": \"section\","
                    + "\"fields\": ["
                    + "{"
                    + "\"type\": \"mrkdwn\","
                    + "\"text\": \"*Environment:*\\n" + environment + "\""
                    + "},"
                    + "{"
                    + "\"type\": \"mrkdwn\","
                    + "\"text\": \"*Host:*\\n" + environmentHost + "\""
                    + "},"
                    + "{"
                    + "\"type\": \"mrkdwn\","
                    + "\"text\": \"*Total Test Executions:*\\n" + totalTests + "\""
                    + "},"
                    + "{"
                    + "\"type\": \"mrkdwn\","
                    + "\"text\": \"*Passed:*\\n" + passedTests + "\""
                    + "},"
                    + "{"
                    + "\"type\": \"mrkdwn\","
                    + "\"text\": \"*Failed:*\\n" + failedTests + "\""
                    + "}"
                    + "]"
                    + "},"
                    + "{"
                    + "\"type\": \"section\","
                    + "\"text\": {"
                    + "\"type\": \"mrkdwn\","
                    + "\"text\": \"*Passed Test Cases:*\\n" + String.join(", ", passedTestCases) + "\""
                    + "}"
                    + "},"
                    + "{"
                    + "\"type\": \"section\","
                    + "\"text\": {"
                    + "\"type\": \"mrkdwn\","
                    + "\"text\": \"*Failed Test Cases:*\\n" + String.join(", ", failedTestCases) + "\""
                    + "}"
                    + "},"
                    + "{"
                    + "\"type\": \"section\","
                    + "\"text\": {"
                    + "\"type\": \"mrkdwn\","
                    + "\"text\": \"View the detailed report: <" + REPORT_URL + "|Test Report>\""
                    + "}"
                    + "}"
                    + "]"
                    + "}";

            // Establish a connection to the Slack webhook
            URI uri = new URI(WEBHOOK_URL);
            URL url = uri.toURL();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            connection.setDoOutput(true);

            // Send the JSON payload
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = payload.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // Check the response code
            int responseCode = connection.getResponseCode();
            if (responseCode != 200) {
                System.out.println("Slack alert not sent: response code - "+responseCode);
                throw new RuntimeException("Failed to send Slack alert, response code: " + responseCode);
            }

            System.out.println("Slack alert sent successfully!");

        } catch (Exception e) {
            System.out.println("Failed to send Slack notification: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
