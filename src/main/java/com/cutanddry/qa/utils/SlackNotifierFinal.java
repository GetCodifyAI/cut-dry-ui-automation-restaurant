package com.cutanddry.qa.utils;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.List;

import com.cutanddry.qa.common.Constants;

public class SlackNotifierFinal {
    private static final String WEBHOOK_URL = Constants.SLACK_WEBHOOK;
    private static final String REPORT_URL = "https://app.circleci.com/pipelines/github/GetCodifyAI/cut-and-dry?branch=master";

    public static void sendSlackAlert(int totalTests, int passedTests, int failedTests, double passRate, double failRate, String environment, List<String> passedTestCases, List<String> failedTestCases, String PART) {
        try {
            String payload = "{"
                    + "\"blocks\": ["
                    + "{"
                    + "\"type\": \"section\","
                    + "\"text\": {"
                    + "\"type\": \"mrkdwn\","
                    + "\"text\": \"*Operator " + PART + " - Test Suite Execution Completed!*\""
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
                    + "},"
                    + "{"
                    + "\"type\": \"mrkdwn\","
                    + "\"text\": \"*Pass Rate:*\\n" + passRate + "%\""
                    + "},"
                    + "{"
                    + "\"type\": \"mrkdwn\","
                    + "\"text\": \"*Fail Rate:*\\n" + failRate + "%\""
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

            // Send the payload to Slack Webhook
            URI uri = new URI(WEBHOOK_URL);
            URL url = uri.toURL();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            connection.setDoOutput(true);

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = payload.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

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