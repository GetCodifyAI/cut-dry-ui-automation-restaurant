package com.cutanddry.qa.utils;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import com.cutanddry.qa.common.Constants;
import org.json.JSONObject;

public class SlackNotifier {
    private static final String WEBHOOK_URL = Constants.SLACK_WEBHOOK;
    //https://hooks.slack.com/services/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

    // Update this with the actual URL where the report is hosted
    private static final String REPORT_URL = "https://app.circleci.com/pipelines/github/GetCodifyAI/cut-and-dry?branch=master";

    public static void sendSlackAlert(int totalTests, int passedTests, int failedTests, String environment, List<String> passedTestCases, List<String> failedTestCases) {
        try {
            // Construct the JSON payload
            String payload = "{"
                    + "\"blocks\": ["
                    + "{"
                    + "\"type\": \"section\","
                    + "\"text\": {"
                    + "\"type\": \"mrkdwn\","
                    + "\"text\": \"*Operator - Test Suite Execution Completed!*\""
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
            URL url = new URL(WEBHOOK_URL);
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
            e.printStackTrace();
        }
    }
}
