package com.cutanddry.qa.tests.matrix;

import org.testng.annotations.Test;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import com.cutanddry.qa.common.Constants;

public class FinalSlackNotifier1Test {

    private static final String WEBHOOK_URL = Constants.SLACK_WEBHOOK;
    private static final String REPORT_URL = "https://app.circleci.com/pipelines/github/GetCodifyAI/cut-and-dry?branch=master";
    private static final String ENVIRONMENT = "uat"; // Change if needed

    @Test
    public void sendFinalSlackNotification() {
        String csvFile = "src/test/resources/finalResult/test_result.csv";

        int totalTests = 0;
        int passedTests = 0;
        int failedTests = 0;
        String passPercentage = "0%";
        String failPercentage = "0%";

        File file = new File(csvFile);
        if (!file.exists()) {
            System.out.println("⚠️ File not found: " + csvFile);
            return;
        }

        System.out.println("\n📌 Reading CSV File: " + csvFile);
        System.out.println("---------------------------------");

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    System.out.println("📝 CSV Header: " + line);
                    isHeader = false;
                    continue;
                }

                System.out.println("📄 CSV Row: " + line);
                String[] data = line.split(",");

                if (data[0].equalsIgnoreCase("Total")) {
                    totalTests = Integer.parseInt(data[4].trim());
                    passedTests = Integer.parseInt(data[5].trim());
                    failedTests = Integer.parseInt(data[6].trim());
                }

                if (data[0].equalsIgnoreCase("Percentage")) {
                    passPercentage = data[5].trim();
                    failPercentage = data[6].trim();
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        sendSlackSummary(totalTests, passedTests, failedTests, passPercentage, failPercentage);
    }

    public void sendSlackSummary(int totalTests, int passedTests, int failedTests, String passPercentage, String failPercentage) {
        try {
            String message = "*Distributor BVT - Test Suite Execution Completed!*\n" +
                    "*Environment:* " + ENVIRONMENT + "\n" +
                    "*Total Test Executions:* " + totalTests + "\n" +
                    "*Passed:* " + passedTests + " (" + passPercentage + ")\n" +
                    "*Failed:* " + failedTests + " (" + failPercentage + ")\n" +
                    "📊 *View full report:* <" + REPORT_URL + "|Test Report>";

            String payload = "{ \"text\": \"" + message.replace("\n", "\\n") + "\" }";

            // Print the payload to console before sending
            System.out.println("\n🚀 Sending Slack Notification...");
            System.out.println("---------------------------------");
            System.out.println("📨 Payload:\n" + payload);
            System.out.println("---------------------------------\n");

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
            System.out.println("📩 Slack Response Code: " + responseCode);

            if (responseCode != 200) {
                System.out.println("❌ Slack summary not sent! Check webhook URL.");
            } else {
                System.out.println("✅ Final Slack summary sent successfully!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}