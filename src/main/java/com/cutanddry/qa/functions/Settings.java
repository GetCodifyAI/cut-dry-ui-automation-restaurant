package com.cutanddry.qa.functions;

import com.cutanddry.qa.pages.SettingsPage;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


public class Settings {
    static SettingsPage settingsPage = new SettingsPage();

    public static void goToOrderSettings(){
        settingsPage.clickOnSettings();
        settingsPage.clickOnOrders();
    }

    public static void setAfterCutOffTime()throws InterruptedException {

        // LocalDateTime currentTime = LocalDateTime.now();
        // LocalDateTime cutoffTime = currentTime.plus(Duration.ofMinutes(695));
        ZonedDateTime currentTime = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));

        // Subtract 10 minutes from the current time to get the cutoff time
        ZonedDateTime cutoffTime = currentTime.plus(Duration.ofMinutes(4));

        // Format the cutoff time in "hhmma" pattern (e.g., "0230PM")
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hhmma");
        String cutoffTimeStr = cutoffTime.format(formatter);

        // Assuming settingsPage.setTime is the method where you set the cutoff time
        settingsPage.setTime(cutoffTimeStr);
    }

    public static void setBeforeCutOffTime() throws InterruptedException {

        // LocalDateTime currentTime = LocalDateTime.now();
        // LocalDateTime cutoffTime = currentTime.plus(Duration.ofMinutes(685));
        // Get the current time in the "America/Los_Angeles" time zone
        ZonedDateTime currentTime = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));

        // Subtract 10 minutes from the current time to get the cutoff time
        ZonedDateTime cutoffTime = currentTime.minus(Duration.ofMinutes(10));

        // Format the cutoff time in "hhmma" pattern (e.g., "0230PM")
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hhmma");
        String cutoffTimeStr = cutoffTime.format(formatter);

        // Assuming settingsPage.setTime is the method where you set the cutoff time
        settingsPage.setTime(cutoffTimeStr);
    }

    public static void saveChanges()throws InterruptedException{
        settingsPage.clickOnSaveChanges();
    }

}