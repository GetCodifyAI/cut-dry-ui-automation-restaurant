package com.cutanddry.qa.tests.matrix;

import org.testng.annotations.Test;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.*;
import com.cutanddry.qa.common.Constants;

public class FinalSlackNotifierTest {

    private static final String WEBHOOK_URL = Constants.SLACK_WEBHOOK;
    private static final String REPORT_URL = "https://app.circleci.com/pipelines/github/GetCodifyAI/cut-and-dry?branch=master";

    @Test
    public void sendFinalSlackNotification() {
        String[] csvFiles = {
                "src/test/resources/finalResult/test_result.csv"
        };

        int totalTests = 0;
        int passedTests = 0;
        int failedTests = 0;

        for (String csvFile : csvFiles) {
            File file = new File(csvFile);
            if (!file.exists()) {
                System.out.println("File not found: " + csvFile);
                continue;
            }

            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(",");
                    if (data.length >= 2) {
                        totalTests++;
                        if ("PASS".equalsIgnoreCase(data[1])) {
                            passedTests++;
                        } else if ("FAIL".equalsIgnoreCase(data[1])) {
                            failedTests++;
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        sendSlackSummary(totalTests, passedTests, failedTests);
    }

    public void sendSlackSummary(int totalTests, int passedTests, int failedTests) {
        try {
            String payload = "{" +
                    "\"blocks\": [" +
                    "{" +
                    "\"type\": \"section\"," +
                    "\"text\": {" +
                    "\"type\": \"mrkdwn\"," +
                    "\"text\": \"*Regression Test Summary*\"" +
                    "}" +
                    "}," +
                    "{" +
                    "\"type\": \"section\"," +
                    "\"fields\": [" +
                    "{" +
                    "\"type\": \"mrkdwn\"," +
                    "\"text\": \"*Total Tests:*\\n" + totalTests + "\"" +
                    "}," +
                    "{" +
                    "\"type\": \"mrkdwn\"," +
                    "\"text\": \"*Passed:*\\n" + passedTests + "\"" +
                    "}," +
                    "{" +
                    "\"type\": \"mrkdwn\"," +
                    "\"text\": \"*Failed:*\\n" + failedTests + "\"" +
                    "}" +
                    "]" +
                    "}," +
                    "{" +
                    "\"type\": \"section\"," +
                    "\"text\": {" +
                    "\"type\": \"mrkdwn\"," +
                    "\"text\": \"View full report: <" + REPORT_URL + "|Test Report>\"" +
                    "}" +
                    "}" +
                    "]" +
                    "}";

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
                System.out.println("Slack summary not sent: response code - " + responseCode);
            } else {
                System.out.println("Final Slack summary sent successfully!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
